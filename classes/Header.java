class Header
{
	String funName;
	ParameterList parameterList; // This is null if <parameter list> is empty.
	
	Header(String s, ParameterList p)
	{
		funName = s;

		parameterList = p;
	}
	
	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
		
		IO.displayln(indent + indent.length() + " <header>");
		IO.displayln(indent1 + indent1.length() + " <fun name> " + funName);
		if ( parameterList != null )	
			parameterList.printParseTree(indent1);
	}

	public void emitInstructions() {
		// instructions for a function
		//print the label
		String label = Globals.functionList.get(funName);
		IO.displayln(label +": ");
	}

	public void eval() {
		int value = Globals.LablesCreated++;
		Globals.functionList.put(funName,(Integer.toString(value)));
		ParameterList p = parameterList;
		int count = 0;
		while(p != null) {
			count++;
			p = p.parameterList;
		}
		Globals.prameterCount.put(Globals.functionList.get(funName),(Integer.toString(count)));
		p = parameterList;
		count = 0;
		while(p != null) {
			count++;
			p.eval(funName, count);
			p = p.parameterList;
		}
	}
}