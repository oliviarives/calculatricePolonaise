package rpnpackage;

import static org.junit.Assert.*;

import org.junit.Test;

import rpnpackage.exceptions.DivideByZeroException;
import rpnpackage.exceptions.NotEnoughOperandsOnStackException;
import rpnpackage.exceptions.ParseException;


public class SimpleRPNParserTest {


    // Normal behavior tests (examples from the subject)
    @Test
    public void testExpression1() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        RPNParser parser = new SimpleRPNParser();
        String expression = "3 5 2 * +";
        double expected = 13;
        assertEquals(expected, parser.parseAndDisplayResult(expression), 0.001);
    }

    @Test
    public void testExpression2() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        RPNParser parser = new SimpleRPNParser();
        String expression = "10 20 -";
        double expected = -10;
        assertEquals(expected, parser.parseAndDisplayResult(expression), 0.001);
    }

    @Test
    public void testExpression3() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        RPNParser parser = new SimpleRPNParser();
        String expression = "10 20 /";
        double expected = 0.5;
        assertEquals(expected, parser.parseAndDisplayResult(expression), 0.001);
    }

    @Test
    public void testExpression4() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        RPNParser parser = new SimpleRPNParser();
        String expression = "1 1 1 1 + + +";
        double expected = 4;
        assertEquals(expected, parser.parseAndDisplayResult(expression), 0.001);
    }

    // Error handling tests
    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testNotEnoughOperands() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        RPNParser parser = new SimpleRPNParser();
        String expression = "5 +";
        parser.parseAndDisplayResult(expression);
    }

    @Test(expected = DivideByZeroException.class)
    public void testDivideByZero() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        RPNParser parser = new SimpleRPNParser();
        String expression = "10 0 /";
        parser.parseAndDisplayResult(expression);
    }

    @Test(expected = ParseException.class)
    public void testInvalidToken() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        RPNParser parser = new SimpleRPNParser();
        String expression = "5 2 &";
        parser.parseAndDisplayResult(expression);
    }

    // More specifics errors
    @Test(expected = ParseException.class)
    public void testEmptyExpression() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        RPNParser parser = new SimpleRPNParser();
        String expression = "";
        parser.parseAndDisplayResult(expression);
    }

    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testOnlyAnOperator() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        RPNParser parser = new SimpleRPNParser();
        String expression ="+";
        parser.parseAndDisplayResult(expression);
    }

    // More tests
    @Test
    public void testExpressionWithDecimals() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        RPNParser parser = new SimpleRPNParser();
        String expression = "0.3 8.7 +";
        double expected = 9.0;
        assertEquals(expected, parser.parseAndDisplayResult(expression), 0.001);
    }

    @Test
    public void testComplexExpression() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        RPNParser parser = new SimpleRPNParser();
        String expression = "5 1 2 + 4 * + 3 -";
        double expected = 14.0;
        assertEquals(expected, parser.parseAndDisplayResult(expression), 0.001);
    }
}