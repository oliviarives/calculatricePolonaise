package rpnpackage;

import rpnpackage.exceptions.DivideByZeroException;
import rpnpackage.exceptions.NotEnoughOperandsOnStackException;
import stackpackage.SimpleStack;
import stackpackage.Stack;

public class RPNCalcStub implements Calc{

    public Stack stack;

    @Override
    public void enterValue(double value) {
        ;

    }

    @Override
    public void add()  {
        if (this.stack.getSize() < 2) {
        }
        double value1 = this.stack.pop();
        double value2 = this.stack.pop();
        double result = value1 + value2;
        this.stack.push(result);
    }

    @Override
    public void subtract() {

        double value1 = this.stack.pop();  // last in
        double value2 = this.stack.pop();  // first in
        double result = value2 - value1;   // first - last
        this.stack.push(result);
    }

    @Override
    public void multiply(){

        double value1 = this.stack.pop();
        double value2 = this.stack.pop();
        double result = value1 * value2;
        this.stack.push(result);
    }

    @Override
    public void divide() {

        double value1 = this.stack.pop();  // last in (divisor)
        double value2 = this.stack.pop();  // first in (dividend)

        double result = value2 / value1;   // first / last
        this.stack.push(result);
    }

    @Override
    public double displayValueOnTop(){
        return this.stack.peek();
    }
}
