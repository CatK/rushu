package rushu.cat.exceptions;



//Kom jboua mn t

public class FightException extends GameActionExceptions {
    public FightException() {
    }

    public FightException(String message) {
        super(message);
    }

    public FightException(Exception e) {
        super(e);
    }
}
