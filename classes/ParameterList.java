import java.util.ArrayList;
import java.util.HashMap;

class ParameterList
{
	String id;
	ParameterList parameterList;
	
	ParameterList(String s, ParameterList p)
	{
		id = s;
		parameterList = p;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent+" ";

		IO.displayln(indent + indent.length() + " <parameter list>");
		ParameterList p = this;
		do
		{
			IO.displayln(indent1 + indent1.length() + " <parameter> " + p.id);
			p = p.parameterList;
		} while ( p != null );
	}

	public void eval(String funName,int count) {
//		String label = Globals.functionList.get(funName);
//		if(Globals.prameterName.containsKey(label)) {
//			HashMap<String,String> h = new HashMap<String,String>();
//			h.put(id, Integer.toString(count));
//			Globals.prameterName.get(label).add(h);
//		}else {
//			ArrayList<HashMap<String, String>> a = new ArrayList<HashMap<String, String>>();
//			HashMap<String,String> h = new HashMap<String,String>();
//			h.put(id, Integer.toString(count));
//			Globals.prameterName.put(label, a);	
//		}
		Globals.prameterName.put(id,Integer.toString(count));
	}
}