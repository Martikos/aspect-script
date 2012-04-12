import java.io.*;

public class Main {
    

    public static void main(String[] args) {
        try {
            Parser p = new Parser("testScript");
            p.output();
        } catch(Exception e) {e.printStackTrace();}
    }


}
