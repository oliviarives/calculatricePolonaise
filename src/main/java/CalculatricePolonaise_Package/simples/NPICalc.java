package CalculatricePolonaise_Package.simples;

import CalculatricePolonaise_Package.exceptions.DivideByZeroException;
import CalculatricePolonaise_Package.exceptions.NotEnoughOperandsOnStackException;
import CalculatricePolonaise_Package.interfaces.Calc;
import stackpackage.SimpleStack;
import stackpackage.Stack;

public class NPICalc implements Calc {
    Stack stack = new SimpleStack();

    @Override
    public void enterValue(double value) {
        this.stack.push(value);
    }

    @Override
    public void add() throws NotEnoughOperandsOnStackException {
        if (this.stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException("Two values needed to add");
        }
        double value1 = this.stack.pop();
        double value2 = this.stack.pop();
        double result = value1 + value2;
        this.stack.push(result);
    }

    @Override
    public void subtract() throws NotEnoughOperandsOnStackException {
        if (this.stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException("Two values needed to subtract");
        }
        double value1 = this.stack.pop();
        double value2 = this.stack.pop();
        double result = value1 - value2;
        this.stack.push(result);
    }

    @Override
    public void multiply() throws NotEnoughOperandsOnStackException {
        if (this.stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException("Two values needed to multiply");
        }
        double value1 = this.stack.pop();
        double value2 = this.stack.pop();
        double result = value1 * value2;
        this.stack.push(result);
    }

    @Override
    public void divide() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        if (this.stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException("Two values needed to divide");
        }
        double value1 = this.stack.pop();
        double value2 = this.stack.pop();
        if (value2 == 0) {
            throw new DivideByZeroException("Impossible to divide by zero");
        }
        double result = value1 / value2;
        this.stack.push(result);
    }

    @Override
    public double displayValueOnTop() throws NotEnoughOperandsOnStackException {
        if (this.stack.isEmpty()) {
            throw new NotEnoughOperandsOnStackException("One value needed to display");
        }
        return this.stack.peek();
    }
}
