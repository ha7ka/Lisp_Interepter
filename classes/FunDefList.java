class FunDefList
{
	FunDef funDef;
	FunDefList funDefList;
	
	FunDefList(FunDef f, FunDefList fl)
	{
		funDef = f;
		funDefList = fl;
	}


	void printParseTree(String indent)
	{
		FunDefList p = this;
		do
		{
			if(p.funDef != null)
				p.funDef.printParseTree(indent);
			IO.displayln("\n--------------------\n");
			p = p.funDefList;
		} while ( p != null );
	}
	
	void eval() {
		FunDefList p = this;
		do
		{
			if(p.funDef != null)
				p.funDef.eval();
			p = p.funDefList;
		} while ( p != null );
	}
	public void emitInstructions() {
		FunDefList p = this;
		do
		{

			p.funDef.emitInstructions();
			p = p.funDefList;
			IO.displayln("\treturn");
		} while ( p != null );
		
	}
}