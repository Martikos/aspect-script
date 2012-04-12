import java.io.*;

public class Main {
    

    public static void main(String[] args) {
        try {
            Parser p = new Parser("testScript");
            p.outputString();
        } catch(Exception e) {e.printStackTrace();}
    }


}
