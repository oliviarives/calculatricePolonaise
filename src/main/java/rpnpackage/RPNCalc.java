package rpnpackage;

import rpnpackage.exceptions.DivideByZeroException;
import rpnpackage.exceptions.NotEnoughOperandsOnStackException;
import stackpackage.SimpleStack;
import stackpackage.Stack;

public class RPNCalc implements Calc {
    public Stack stack;

    public RPNCalc() {
        this.stack = new SimpleStack();
    }

    public RPNCalc(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void enterValue(double value) {
        this.stack.push(value);

    }

    @Override
    public void add() throws NotEnoughOperandsOnStackException {
        if (this.stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException();
        }
        double value1 = this.stack.pop();
        double value2 = this.stack.pop();
        double result = value1 + value2;
        this.stack.push(result);
    }

    @Override
    public void subtract() throws NotEnoughOperandsOnStackException {
        if (this.stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException();
        }
        double value1 = this.stack.pop();  // last in
        double value2 = this.stack.pop();  // first in
        double result = value2 - value1;   // first - last
        this.stack.push(result);
    }

    @Override
    public void multiply() throws NotEnoughOperandsOnStackException {
        if (this.stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException();
        }
        double value1 = this.stack.pop();
        double value2 = this.stack.pop();
        double result = value1 * value2;
        this.stack.push(result);
    }

    @Override
    public void divide() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        if (this.stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException();
        }
        double value1 = this.stack.pop();  // last in (divisor)
        double value2 = this.stack.pop();  // first in (dividend)
        if (value1 == 0) {
            throw new DivideByZeroException();
        }
        double result = value2 / value1;   // first / last
        this.stack.push(result);
    }

    @Override
    public double displayValueOnTop() throws NotEnoughOperandsOnStackException {
        if (this.stack.isEmpty()) {
            throw new NotEnoughOperandsOnStackException();
        }
        return this.stack.peek();
    }
}
