package rpnpackage;

import rpnpackage.exceptions.DivideByZeroException;
import rpnpackage.exceptions.NotEnoughOperandsOnStackException;
import rpnpackage.exceptions.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class SimpleRPNParserUnitTest {
    RPNParser unitParser = new SimpleRPNParser(new RPNCalcStub());

    public void unitTestExpression1() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        String expression = "3 5 2 * +";
        double expected = 13;
        assertEquals(expected, unitParser.parseAndDisplayResult(expression), 0.001);
    }

}