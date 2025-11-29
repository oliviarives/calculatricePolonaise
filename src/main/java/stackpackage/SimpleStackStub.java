package stackpackage;


public class SimpleStackStub implements Stack {

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
    }

    @Override
    public double peek() {
        return 10;
    }

    @Override
    public double pop() {
        return 10;
    }
}
