import java.util.ArrayList;
import java.util.HashMap;

public class Globals {
	public static int LablesCreated = 1;
	// Function-name to a Label
	public static HashMap<String, String> functionList = new HashMap<String, String>();
	// Label to Parameter count
	public static HashMap<String, String> prameterCount = new HashMap<String, String>();
	// fun label -> pramName -> label
	//public static HashMap<String,ArrayList<HashMap<String, String>>> prameterName = new HashMap<String,ArrayList<HashMap<String, String>>>();
	public static HashMap<String,String> prameterName = new HashMap<String,String>();
}
