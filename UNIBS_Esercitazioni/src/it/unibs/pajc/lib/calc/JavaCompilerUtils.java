package it.unibs.pajc.lib.calc;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;

public class JavaCompilerUtils {

	private static JavaCompilerUtils jcu = null; 

	private JavaCompiler compiler;
	private DiagnosticCollector<JavaFileObject> diagnostics;
	private String source;

	/**
	 * Get a singleton for the JavaCompilerUtils
	 * @return the JavaCompilerUtils object or
	 * {@code null} if no compiler is provided
	 */
	public static JavaCompilerUtils getInstance() {
		if(jcu == null)
			jcu = new JavaCompilerUtils();

		jcu.compiler = ToolProvider.getSystemJavaCompiler();

		return jcu;
	}

	/**
	 * Create a new Class object from the class definition
	 *  
	 * @param classPackage the class package
	 * @param imports the class imports
	 * @param className the class name
	 * @param classExtends the base class for the new class (can be null)
	 * @param classImplements the interface implemented by the new class (can be null)
	 * @param classBody the class body
	 * @return the Class object requested or {@code null} if compilation
	 * error occour, in that case check getDiagnostic for more details
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Class createClass(String classPackage, 
			List<String> imports, 
			String className,
			String classExtends,
			List<String> classImplements,
			String classBody) 
					throws IOException, ClassNotFoundException {

		String packageBody = classPackage != null ? String.format("package %s;", classPackage) : "";
		
		StringBuilder importBody = new StringBuilder();
		if(imports != null && imports.size() > 0) {
			for(String s: imports)
				importBody.append(String.format("import %s;\n", s));
		}

		String extendsBody = (classExtends != null) ? String.format("extends %s", classExtends) : "";

		String implemetsBody = "";
		if(classImplements != null && classImplements.size() > 0) {

			StringJoiner sj = new StringJoiner(",");
			for(String s: classImplements)
				sj.add(s);
			implemetsBody = String.format("implements %s", sj.toString());
		}

		String classDeclaration = String.format("%s %s %s",
				className, extendsBody, implemetsBody);

		source = String.format("%s\n %s\n public class %s { \n %s \n}",
				packageBody, importBody.toString(), classDeclaration, classBody);

		JavaFileObject sourceFile = new JavaSourceFromString(className, source);

		jcu.diagnostics = new DiagnosticCollector<JavaFileObject>();
		StandardJavaFileManager jfm = jcu.compiler.getStandardFileManager(jcu.diagnostics, null, null);
		jfm.setLocation(StandardLocation.CLASS_OUTPUT, 
				Arrays.asList(new File("bin")));

		CompilationTask task = jcu.compiler.getTask(null, jfm, jcu.diagnostics, null, null,
				Arrays.asList(sourceFile));

		if(!task.call())
			return null;

		return classPackage != null ? Class.forName(String.format("%s.%s", classPackage, className)) :
			Class.forName(className);
	}

	public List<Diagnostic<? extends JavaFileObject>> getDiagnostics() {
		return jcu.diagnostics.getDiagnostics();
	}
	
	public String dumpDiagnostics() {
		StringBuilder sb = new StringBuilder();
		for(Diagnostic<?> d: jcu.diagnostics.getDiagnostics())
			sb.append(String.format("%4d - %s", d.getLineNumber(), d));
		
		return sb.toString();
	}

	/***
	 * @return the last compiled class source
	 */
	public String getSource() {
		return source;
	}

	protected class JavaSourceFromString extends SimpleJavaFileObject {
		final String code;

		JavaSourceFromString(String name, String code) {
			super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension),Kind.SOURCE);
			this.code = code;
		}

		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) {
			return code;
		}
	}
}

