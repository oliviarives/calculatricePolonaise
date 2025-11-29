package rpnpackage.exceptions;

public class NotEnoughOperandsOnStackException extends Exception {

    public NotEnoughOperandsOnStackException() {
        super("Not enough operands");
    }

}
