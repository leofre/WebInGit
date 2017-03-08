package utilities;

public class UtilitiesForWeb {
	
	public static String splitStringWithCamelCase(String stringWithCamelCaseToSplit)
	{
		String nameOfTestWithSpaces="";
	    for (String word : stringWithCamelCaseToSplit.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
	    	nameOfTestWithSpaces+= " "+word;
	    }
	    return nameOfTestWithSpaces;
	}

}
