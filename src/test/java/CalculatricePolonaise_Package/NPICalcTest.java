package CalculatricePolonaise_Package;

import static org.junit.Assert.*;

import CalculatricePolonaise_Package.exceptions.DivideByZeroException;
import CalculatricePolonaise_Package.exceptions.NotEnoughOperandsOnStackException;
import Stack_Package.SimpleStack;
import Stack_Package.Stack;
import org.junit.Test;

import java.util.EmptyStackException;

public class NPICalcTest {

    // Comportement normal

    @Test
    public void testEnterValue() throws NotEnoughOperandsOnStackException {
        Calc calc = new NPICalc();
        double value = 1;
        calc.enterValue(value);

        assertEquals("La valeur est bien ajoutée à la calculatrice",value,calc.displayValueOnTop(),0.001);
    }

    @Test
    public void testAdd() throws NotEnoughOperandsOnStackException {
        Calc calc = new NPICalc();
        double operand1 = 3;
        double operand2 = 5;
        calc.enterValue(operand1);
        calc.enterValue(operand2);
        calc.add();

        assertEquals("L'addition est bien effectuée",operand2 + operand1,calc.displayValueOnTop(),0.001);
    }

    @Test
    public void testSubtract()throws NotEnoughOperandsOnStackException {
        Calc calc = new NPICalc();
        double operand1 = 3;
        double operand2 = 5;
        calc.enterValue(operand1);
        calc.enterValue(operand2);
        calc.subtract();

        assertEquals("La soustraction est bien effectuée",operand2 - operand1,calc.displayValueOnTop(),0.001);
    }

    @Test
    public void testMultiply()throws NotEnoughOperandsOnStackException {
        Calc calc = new NPICalc();
        double operand1 = 3;
        double operand2 = 5;
        calc.enterValue(operand1);
        calc.enterValue(operand2);
        calc.multiply();

        assertEquals("La multiplication est bien effectuée",operand2 * operand1,calc.displayValueOnTop(),0.001);
    }

    @Test
    public void testDivide()throws NotEnoughOperandsOnStackException, DivideByZeroException {
        Calc calc = new NPICalc();
        double operand1 = 3;
        double operand2 = 5;
        calc.enterValue(operand1);
        calc.enterValue(operand2);
        calc.divide();

        assertEquals("La division est bien effectuée",operand2 / operand1,calc.displayValueOnTop(),0.001);
    }

    // Erreurs attendues

    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testDisplayValueOnTopEmptyCalc() throws NotEnoughOperandsOnStackException{
        Calc calc = new NPICalc();
        calc.displayValueOnTop();
    }

    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testAddWithNoValues() throws NotEnoughOperandsOnStackException{
        Calc calc = new NPICalc();
        calc.add();
    }

    @Test (expected = NotEnoughOperandsOnStackException.class)
    public void testAddWithOnlyOneValue() throws NotEnoughOperandsOnStackException{
        Calc calc = new NPICalc();
        calc.enterValue(1);
        calc.add();
    }

    @Test (expected = DivideByZeroException.class)
    public void testDivideByZero() throws DivideByZeroException, NotEnoughOperandsOnStackException{
        Calc calc = new NPICalc();
        calc.enterValue(0);
        calc.enterValue(10);
        calc.divide();
    }



}
