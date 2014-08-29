package rushu.cat.exceptions;


//Kom jboua mn t 

public class GameActionExceptions extends Exception {
    public GameActionExceptions() {
    }

    public GameActionExceptions(String message) {
        super(message);
    }

    public GameActionExceptions(Exception e) {
        super(e.getMessage(), e.getCause());
    }
}
