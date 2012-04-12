import java.io.*;
import java.util.HashMap;

public class parser {

    public parser(String fileLocation) throws Exception {

        FileInputStream fstream = new FileInputStream(fileLocation);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
    
        // first, read whole file to get title and all env variables
        while((strLine = br.readLine())!=null) {
            System.out.println(strLine);
        }
    }
}
