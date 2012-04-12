import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {

    private String title = "";
    private HashMap envVariables;
    private ArrayList<PublicMethod> publicMethods;

    public Parser(String fileLocation) throws Exception {

        // initialization
        publicMethods = new ArrayList();
        envVariables = new HashMap();

        FileInputStream fstream = new FileInputStream(fileLocation);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
    
        // first, read whole file to get title and all env variables
        while((strLine = br.readLine())!=null) {
            System.out.println(strLine);
            String[] strs = strLine.split(" ");
            if (strLine.startsWith("title")) {
                title = strs[1];
            }
            else if (strLine.startsWith("env")) {
                String variableName = strs[1];
                String variableValue = strs[2];
                envVariables.put(variableName, variableValue);
            }
        }
    }
    public void output() {
        System.out.println("class " + title);
        System.out.println(envVariables.size());

    }
}
