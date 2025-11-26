package Stack_Package;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SimpleStack implements Stack{

    ArrayList<Double> stack = new ArrayList<>();
    public boolean isEmpty(){
       return this.stack.isEmpty();
    }

    @Override
    public int getSize() {
        return this.stack.size();
    }

    public void push(double item){
        this.stack.add(item);
    }

    public double peek() throws EmptyStackException {
        if (this.isEmpty()){
            throw new EmptyStackException();
        }
        return this.stack.get(this.stack.size()-1);
    }
    public double pop() throws EmptyStackException{
        if (this.isEmpty()){
            throw new EmptyStackException();
        }
        double item = this.peek();
        this.stack.remove(this.stack.size()-1);
        return item;
    }
}
