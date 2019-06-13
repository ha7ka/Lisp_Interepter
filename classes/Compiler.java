public abstract class Compiler extends Parser
{
	public static int label = 0;
	public static final String indent = "\t";

	public static void main(String argv[])
	{
		// argv[0]: input file containing an expression of category <exp>
		// argv[1]: output file containing instruction stream or lex/syntax error messages

		setIO( argv[0], argv[1] );
		setLex();
		
		getToken();
		FunDefList funDefList = funDefList(); // build a parse tree		
		funDefList.eval();
		Exp exp = null;
		int funCallLabel = 0;
		if(state == State.Div) {
			getToken();
			exp = exp();
			funCallLabel = Globals.LablesCreated++;
			IO.displayln("\tgoto "+funCallLabel);
		}
		// i was post inc you pre this is to account for that
		label = Globals.LablesCreated - 1;
		if ( ! t.isEmpty() ) {
				IO.displayln(t + "  -- unexpected symbol");
		}
		else if ( ! syntaxErrorFound ) {
			funDefList.emitInstructions();
			IO.displayln(funCallLabel + ": ");
			exp.emitInstructions();
		}

		closeIO();
	}
}