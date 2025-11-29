package rpnpackage;
import rpnpackage.exceptions.DivideByZeroException;
import rpnpackage.exceptions.NotEnoughOperandsOnStackException;
import rpnpackage.exceptions.ParseException;

public interface RPNParser {
    /**
     * parses the string, computing and display the last result
     * @param toParse
     * @return the last result
     */
    double parseAndDisplayResult(String toParse) throws
            NotEnoughOperandsOnStackException, DivideByZeroException, ParseException;
}