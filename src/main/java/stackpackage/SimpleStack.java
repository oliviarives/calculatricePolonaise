package stackpackage;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SimpleStack implements Stack {

    public ArrayList<Double> stack;

    public SimpleStack() {
        this.stack = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int getSize() {
        return this.stack.size();
    }

    @Override
    public void push(double item) {
        this.stack.add(item);
    }

    @Override
    public double peek() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stack.get(this.stack.size() - 1);
    }
    @Override
    public double pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stack.remove(this.stack.size() - 1);
    }
}
