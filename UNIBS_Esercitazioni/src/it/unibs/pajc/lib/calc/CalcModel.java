package it.unibs.pajc.lib.calc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class CalcModel extends BaseModel {
	private class Op {
		final String name;
		final OpBase op;
		final Double value;
		final boolean isOperator;
		
		Op(Double value) {
			this.value = value;
			this.isOperator = false;
			this.name = null;
			this.op = null;
		}
		
		Op(String name, OpBase op) {
			this.name = name;
			this.op = op;
			this.isOperator = true;
			this.value = null;
		}
		
	}
	
	Stack<Op> opStack = new Stack<Op>();
	HashMap<String, Op> knownOps = new HashMap<String, Op>();
	
	void addKnownOp(String name, BinaryOp op) {
		knownOps.put(name, new Op(name, op));
		fireValuesChange();
	}

	void addKnownOp(String name, UnaryOp op) {
		knownOps.put(name, new Op(name, op));
		fireValuesChange();
	}

	Set<String> getKnownOps() {
		return knownOps.keySet();
	}
	
	public CalcModel() {
		
		addKnownOp("+", (a,b) -> a + b);
		addKnownOp("*", (a,b) -> a * b);
		addKnownOp("-", (a,b) -> b - a);
		addKnownOp("/", (a,b) -> b / a);
		
		addKnownOp("√", Math::sqrt);
	}
	
	public Double pushOperand(Double op) {
		opStack.add(new Op(op));
		return evaluate();
	}
	
	public Double performOperation(String op) {
		
		switch(op) {
			case "CA" : opStack.clear();
				break;
			case "CL": if(opStack.size() > 0)
				opStack.pop();
				break;
			
				default:
					if(knownOps.containsKey(op))
						opStack.push(knownOps.get(op));
		}
		
		return opStack.size() > 0 ? evaluate() : 0.;
	}
	
	
	public String dump() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Op op: opStack) {
			sb.append(op.isOperator ? op.name : op.value);
			sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
	
	private class EvaluateResult {
		Double result;
		Stack<Op> remainingOps;

		EvaluateResult(Double result, Stack<Op> remainingOps) {
			this.result = result;
			this.remainingOps = remainingOps;
		}
	}
	
	Double evaluate() {
		//return 0;
		return evaluate((Stack<Op>) opStack.clone()).result;
	}
		
	private EvaluateResult evaluate(Stack<Op> opStack) {
		if(!opStack.isEmpty()){
			
			Stack<Op> wStack = (Stack<Op>) opStack.clone();
			Op op = wStack.pop();
			
			if(!op.isOperator) {
				return new EvaluateResult(op.value, wStack);
			}
			else if(op.op instanceof UnaryOp) {
				EvaluateResult opEval = evaluate(wStack);
				if(opEval.result != null)
					return new EvaluateResult( 
							((UnaryOp) op.op).eval(opEval.result), 
							opEval.remainingOps);
				
			} else if(op.op instanceof BinaryOp) {
				EvaluateResult opEval1 = evaluate(wStack);
				if(opEval1.result != null) {
					EvaluateResult opEval2 = evaluate(opEval1.remainingOps);
					if(opEval2.result != null) {
						return new EvaluateResult(
								((BinaryOp) op.op).eval(opEval1.result, opEval2.result),
								opEval2.remainingOps);
					}
				}
			}
		}
		
		return new EvaluateResult(null, opStack);
	}

}












