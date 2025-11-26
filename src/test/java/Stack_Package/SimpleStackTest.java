package Stack_Package;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.EmptyStackException;

public class SimpleStackTest {

    @Test
    public void testCreateEmptyStack() {

        // Create a new Stack
        Stack stack = new SimpleStack();

        // Then...
        assertTrue("A new stack should be empty", stack.isEmpty());
        assertEquals("A new stack has no element", 0, stack.getSize());
    }


    @Test (expected = EmptyStackException.class)
    public void testPeekOnEmptyStack() throws EmptyStackException{
        Stack stack = new SimpleStack();
        stack.peek();
    }

    @Test (expected = EmptyStackException.class)
    public void testPopOnEmptyStack() throws EmptyStackException{
        Stack stack = new SimpleStack();
        stack.pop();
    }

    @Test
    public void testPush() throws EmptyStackException {
        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        double item = 1.0;

        // When the item is pushed in the stack
        stack.push(item);

        // Then...
        assertFalse ("The stack must be not empty", stack.isEmpty());
        assertEquals("The stack contains 1 item", 1, stack.getSize());
        assertEquals("The pushed item is on top of the stack", item, stack.peek(),0.001);
    }

    @Test
    public void testPeek() {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        double item1 = 1.0;
        double item2 = 2.0;

        // When two item are pushed in the stack
        stack.push(item1);
        stack.push(item2);

        // Then...
        int sizeBeforePeek = stack.getSize();
        assertEquals("The last item pushed is on top of the stack", item2, stack.peek(),0.001);
        int sizeAfterPeek = stack.getSize();

        assertEquals("The size of the stack is the same before and after the peek",sizeAfterPeek,sizeBeforePeek);
    }


    @Test
    public void testPop() {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        double item1 = 1.0;
        double item2 = 2.0;

        // When two item are pushed in the stack
        stack.push(item1);
        stack.push(item2);

        // Then...
        int sizeBeforePop = stack.getSize();
        assertEquals("The last item pushed is on top of the stack", item2, stack.pop(),0.001);
        int sizeAfterPop = stack.getSize();

        assertNotEquals("The size of the stack is not the same before and after the peek",sizeAfterPop,sizeBeforePop);
        assertEquals("The size decreased by 1 after pop", sizeBeforePop - 1, sizeAfterPop);
        assertEquals("The new top is the first item", item1, stack.peek(), 0.001);
    }
    @Test
    public void testGetSize() {
        Stack stack = new SimpleStack();
        assertEquals("The size of an empty Stack is 0",0,stack.getSize());

        //We add an item
        double item = 1.0;
        stack.push(item);

        assertEquals("The stack contains 1 item",1,stack.getSize());

    }
}
