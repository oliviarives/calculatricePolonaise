package rpnpackage;

import static org.junit.Assert.*;

import org.junit.Test;

import rpnpackage.exceptions.DivideByZeroException;
import rpnpackage.exceptions.NotEnoughOperandsOnStackException;


public class RPNCalcTest {


    // Normal behavior tests
    @Test
    public void testEnterValue() throws NotEnoughOperandsOnStackException {
        Calc calc = new RPNCalc();
        double value = 1;
        calc.enterValue(value);

        assertEquals("The value 1 is added to the calculator",value,calc.displayValueOnTop(),0.001);
    }

    @Test
    public void testAdd() throws NotEnoughOperandsOnStackException {
        Calc calc = new RPNCalc();
        double operand1 = 3;
        double operand2 = 5;
        calc.enterValue(operand1);
        calc.enterValue(operand2);
        calc.add();

        assertEquals("The addition is correctly performed",operand1 + operand2,calc.displayValueOnTop(),0.001);
    }

    @Test
    public void testSubtract()throws NotEnoughOperandsOnStackException {
        Calc calc = new RPNCalc();
        double operand1 = 3;
        double operand2 = 5;
        calc.enterValue(operand1);
        calc.enterValue(operand2);
        calc.subtract();

        assertEquals("The subtraction is correctly performed",operand1 - operand2,calc.displayValueOnTop(),0.001);
    }

    @Test
    public void testMultiply()throws NotEnoughOperandsOnStackException {
        Calc calc = new RPNCalc();
        double operand1 = 3;
        double operand2 = 5;
        calc.enterValue(operand1);
        calc.enterValue(operand2);
        calc.multiply();

        assertEquals("The multiplication is correctly performed",operand1 * operand2,calc.displayValueOnTop(),0.001);
    }

    @Test
    public void testDivide()throws NotEnoughOperandsOnStackException, DivideByZeroException {
        Calc calc = new RPNCalc();
        double operand1 = 3;
        double operand2 = 5;
        calc.enterValue(operand1);
        calc.enterValue(operand2);
        calc.divide();

        assertEquals("The division is correctly performed",operand1 / operand2,calc.displayValueOnTop(),0.001);
    }

    // Expected errors: 0 value
    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testDisplayValueOnTopEmptyCalc() throws NotEnoughOperandsOnStackException{
        Calc calc = new RPNCalc();
        calc.displayValueOnTop();
    }

    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testAddWithNoValues() throws NotEnoughOperandsOnStackException{
        Calc calc = new RPNCalc();
        calc.add();
    }

    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testSubtractWithNoValues() throws NotEnoughOperandsOnStackException{
        Calc calc = new RPNCalc();
        calc.subtract();
    }

    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testMultiplyWithNoValues() throws NotEnoughOperandsOnStackException{
        Calc calc = new RPNCalc();
        calc.multiply();
    }

    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testDivideWithNoValues() throws NotEnoughOperandsOnStackException, DivideByZeroException{
        Calc calc = new RPNCalc();
        calc.divide();
    }

    // Expected errors: 1 value
    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testAddWithOnlyOneValue() throws NotEnoughOperandsOnStackException{
        Calc calc = new RPNCalc();
        calc.enterValue(1);
        calc.add();
    }

    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testSubtractWithOnlyOneValue() throws NotEnoughOperandsOnStackException{
        Calc calc = new RPNCalc();
        calc.enterValue(1);
        calc.subtract();
    }

    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testMultiplyWithOnlyOneValue() throws NotEnoughOperandsOnStackException{
        Calc calc = new RPNCalc();
        calc.enterValue(1);
        calc.multiply();
    }

    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testDivideWithOnlyOneValue() throws NotEnoughOperandsOnStackException, DivideByZeroException{
        Calc calc = new RPNCalc();
        calc.enterValue(1);
        calc.divide();
    }


    // Specific error for division: division by zero
    @Test (expected = DivideByZeroException.class)
    public void testDivideByZero() throws DivideByZeroException, NotEnoughOperandsOnStackException{
        Calc calc = new RPNCalc();
        calc.enterValue(10);
        calc.enterValue(0);
        calc.divide(); // Attempt to divide 10 by 0
    }



}
