import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {

    private String title = "";
    private HashMap keywords;
    private HashMap envVariables;
    private ArrayList<PublicMethod> publicMethods;

    private static String[] identifiers = {"after", "before", "around", "when"};
    
    private HashMap hashList(String[] strs) {
        HashMap returnMap = new HashMap();
        for (int i=0; i<strs.length; i++) 
            returnMap.put(strs[i], "");
        return returnMap;
    }

    public Parser(String fileLocation) throws Exception {
        // initialization
        publicMethods = new ArrayList();
        envVariables = new HashMap();
        keywords = hashList(identifiers);

        // file parsing
        FileInputStream fstream = new FileInputStream(fileLocation);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
    
        while((strLine = br.readLine())!=null) {
            String[] strs = strLine.split(" ");
            if (strLine.startsWith("title")) {
                // get class name and title in line
                title = strs[1];
            }
            else if (strLine.startsWith("env")) {
                // get environment variable in line
                String variableName = strs[1];
                String variableValue = strs[2];
                envVariables.put(variableName, variableValue);
            }
            else if (strLine.equals("")) {
                // ignore
            } 
            else {
                // actual processing 

                // get identifier
                // identifier should be the first word in the line
                // function name should be the second word on the line
                String timing = strs[0];
                String function = strs[1];
                String code = "";
                while((strLine = br.readLine())!=null) {
                    strs = strLine.split(" ");
                    // if it is a new identifier or an empty line, break
                    String key = strs[0];
                    if(keywords.containsKey(key) || strLine.equals(""))
                        break;
                    // it is not a keyword, so it's gonna be method code
                    code += strLine + "\n";
                }
                PublicMethod method = new PublicMethod();
                method.setTiming(timing);
                method.setFunction(function);
                method.setCode(code);
                publicMethods.add(method);
            }
        }
    }
    public void outputString() {
        System.out.println("aspect " + title + " {\n");
        for(int i=0; i<publicMethods.size(); i++)
            publicMethods.get(i).generateCode();
        System.out.println("}");
    }
    public void fileOutput() {

    }
}
