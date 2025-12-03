package stackpackage;


import java.util.ArrayList;

public class SimpleStackStub implements Stack {
    double item;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public void push(double item) {
        this.item = item;
    }

    @Override
    public double peek() {
        return item;
    }

    @Override
    public double pop() {
        return 10;
    }
}
