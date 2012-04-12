import java.io.*;

public class PublicMethod {

    private String timing, function, code;
    
    public PublicMethod() {}
    
    // when to execute the code
    public void setTiming(String t) {
        timing = t;
    }
    // around which function to execute the code
    public void setFunction(String f) {
        function = f;
    }
    // what to execute - shell script
    public void setcode(String c) {
        code = c;
    }
}
