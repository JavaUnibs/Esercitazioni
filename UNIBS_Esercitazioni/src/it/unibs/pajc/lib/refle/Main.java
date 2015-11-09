package it.unibs.pajc.lib.refle;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) throws Exception {
		
		JavaCompilerUtils jcu = JavaCompilerUtils.getInstance();
		
		List<String> classImports = new ArrayList<String>();
		classImports.add("it.unibs.pajc.lib.*");
		
		List<String> classInterfaces = new ArrayList<String>();
		classInterfaces.add("Evaluator");
		
		Class myClass = jcu.CreateClass("it.unibs.pajc", classImports, 
				"MyRuntimeEval", 
				null, 
				classInterfaces, 
				"public void metodoDiProva() { System.out.println(\"Metodo di Prova\");}"
				+ "public double eval(double a, double b) { return a*a + b*b; }");

		if(myClass == null) {
			System.out.printf("\nErrore in compilazione!");
			System.out.printf("\n%s", jcu.getSource());
			System.out.printf("\n---ERRORI---\n%s", jcu.dumpDiagnostics());
		} 
		else {
			System.out.printf("\nSOURCE:\n%s", jcu.getSource());
			
			for(Method m: myClass.getMethods()) {
				System.out.printf("\nmethod name: %s", m.getName());

				for(Parameter p: m.getParameters()) {
					System.out.printf("\n\tp name: %s [%s]", p.getName(), p.getType());
			}
		}

			System.out.printf("\n--Chiamo un metodo--\n");
			
			Object myObj = myClass.newInstance();
			if(myObj instanceof Evaluator) {
				Evaluator myEval = (Evaluator) myObj;
				
				System.out.printf("\nIl risultato di eval(1,2) è: %f\n", myEval.eval(1, 2));
			}
			
			Method myMethod = myClass.getMethod("metodoDiProva");
			Object result = myMethod.invoke(myObj);
			System.out.printf("\ninvoke metodoDiProva = %s", result);

			
//			Constructor<?> c = myClass.getConstructor(String.class);
//			Object myObj = c.newInstance("Testo di Prova");
//			Method myMethod = myClass.getMethod("charAt", int.class);
//			Object result = myMethod.invoke(myObj, 1);
//			System.out.printf("\ninvoke charAt(1) = %s", result);
		}
	}

}


