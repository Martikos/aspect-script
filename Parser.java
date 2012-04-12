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

        FileInputStream fstream = new FileInputStream(fileLocation);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
    
        while((strLine = br.readLine())!=null) {
            System.out.println(strLine);
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

            }
        }
    }
    public void output() {
        System.out.println("class " + title);
        System.out.println(envVariables.size());

    }
}
