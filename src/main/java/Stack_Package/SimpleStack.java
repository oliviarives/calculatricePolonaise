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
        return this.stack.get(this.stack.size()-1);
    } /**
     * Removes the object at the top of this stack and returns * that object as the value of this function.
     * @throws EmptyStackException if this stack is empty.
     */
    public double pop() throws EmptyStackException{
        return this.stack.removeLast();
        /*if ( ) size > 1, throws exceptions */
    };
}
