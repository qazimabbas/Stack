package Stack.ArrayStack;


public class Main {
    public static void main(String[] args) {
        Arraystack a = new Arraystack(5);
        a.push("apple");
        a.push("mango");
        a.push("orange");
        a.push("banana");
        a.push("grapes");
        a.push("grapes2");
        System.out.println(a.size());
        System.out.println(a.DeleteByIndexFromTop(3));
        a.printStack();
    
        
    

       
    }
    
}
