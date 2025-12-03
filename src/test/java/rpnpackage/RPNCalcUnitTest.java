package rpnpackage;

import org.junit.Test;
import rpnpackage.exceptions.DivideByZeroException;
import rpnpackage.exceptions.NotEnoughOperandsOnStackException;
import stackpackage.SimpleStackStub;

import static org.junit.Assert.assertEquals;

public class RPNCalcUnitTest {
    RPNCalc unitCalc = new RPNCalc(new SimpleStackStub());

    @Test
    public void unitTestAdd() throws NotEnoughOperandsOnStackException{
        unitCalc.add();
        assertEquals("The addition is correct",20,unitCalc.displayValueOnTop(),0.001);
    }

    @Test
    public void unitTestSubstract() throws NotEnoughOperandsOnStackException{
        unitCalc.subtract();
        assertEquals("The subtraction is correct",0,unitCalc.displayValueOnTop(),0.001);
    }

    @Test
    public void unitTestMultiply() throws NotEnoughOperandsOnStackException{
        unitCalc.multiply();
        assertEquals("The multiplication is correct",100,unitCalc.displayValueOnTop(),0.001);
    }

    @Test
    public void unitTestDivide() throws NotEnoughOperandsOnStackException, DivideByZeroException{
        unitCalc.divide();
        assertEquals("The division is correct",1,unitCalc.displayValueOnTop(),0.001);
    }
}