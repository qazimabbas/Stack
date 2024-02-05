package Stack.linkedStack;

import Stack.Stack;
import Stack.ArrayStack.Arraystack;

public class Main {
    public static void main(String[] args) {
        linkedStack a1 = new linkedStack();
        a1.push("oranges");
        a1.push("Mango");
        a1.push("banana");
        a1.push("chickoo");
        a1.push("grapes");
        linkedStack a2 = new linkedStack();
        a2.Chunk4(a1,1,5);
        a2.printStack();


      
        
    }
    
}
