package Stack.ArrayStack;

import Stack.Stack;
import Stack.linkedStack.linkedStack;

public class Arraystack implements Stack{
    private Object a[];
    private int size;
    public Arraystack(int capacity){
        a = new Object[capacity];
        this.size = 0;
    }
    public boolean isEmpty(){
        return (size==0);
    }
    public Object peek(){
        if(isEmpty()){
            System.out.println("The stack is empty");
        }
        return a[size-1];
    }
    public Object pop(){
        if(isEmpty()) throw new IllegalStateException("The stack in empty can't pop the element");
        Object temp = a[--size];
        a[size]=null;
        return temp; 
    }
    public void push(Object ele){
        if(this.a.length==size){
            resize();
        }
        a[size++]=ele;
    }
    private void resize(){
        Object aa = a;
        a = new Object[a.length*2];
        System.arraycopy(aa, 0, a, 0, size);
    }
    public int size(){
        return size;
    } 
    public void printStack(){
        if(!isEmpty()){
        for(int i=this.size()-1;i>=0;i--){
            System.out.println(a[i]);
        }
    } 
    return;
    }  
    
    public void AddTwoStacks(Object obj){
        Arraystack a2 = (Arraystack) obj;
        if(a2.size==0){
            return;
        }else{
            for(int j=0;j<a2.a.length;j++){
                this.push(a2.a[j]);
               
            }
        }    
    }
    public linkedStack ToLinkedStack(){
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        linkedStack l = new linkedStack();
        for(int i=0;i<this.size();i++){
            l.push(this.a[i]);
        }
        return l;
    }
    // public Arraystack clone(){
    //     if(this.isEmpty()){
    //         throw new IllegalStateException("Can't make a clone of an empty stack");
    //     }
    //     return this; //Agar aik stack me delete karenge to dosra ma bhi delete hojaega 
    // }
    public void clone(Arraystack l){
        if(l.isEmpty()){
            throw new IllegalStateException("Can't make a clone of an empty stack");
        }
        this.a = new Object[l.size()];
        this.size = 0;//ye islea ta ka jo new element push hoga wo zero index pa push ho warna jo phele arraystack ke 
        //size the us index pa push hoga or shuru ka array index null reh jaen ga.
        for(int i=0;i<l.size();i++){
            this.push(l.a[i]);
        }
    }
    public boolean EqualsTo(Arraystack A){
        if(this.isEmpty()==true && A.isEmpty()==true){
            return true;
        }else if(this.isEmpty()||A.isEmpty()){
            return false;
        }
        boolean flag = true;
        if(this.size()==A.size()){
           for(int i=0;i<this.size()||i<A.size();i++){
               if( this.a[i] != A.a[i]){
                flag = false;
                break;
               }
           }
        }else{
            flag=false;
        }
        return flag;
    }
    public boolean EqualsTo(linkedStack l){
        if(this.isEmpty()==true&&l.isEmpty()==true){
            return true;
        }else if(this.isEmpty()==true||l.isEmpty()==true){
            return false;
        }
        boolean flag = true;
        int i=1;
        if(this.size()==l.size()){
           while(i<this.size()||i<l.size()){
                 if(this.SearchByIndex(i)!=l.SearchByIndex(i)){
                      flag = false;
                      break;
                 }
                 i++;
           }
        }else{
            flag = false;
        }
        return flag;

    }
    public Object RemoveFromBottom(){
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        Object temp = this.a[0];
        size--;
        for(int i=0;i<this.size();i++){
            this.a[i]=this.a[i+1];
        }
        this.a[size] = null;
        return temp;
    }
    public String toString(){
        if(this.isEmpty()){
           throw new IllegalStateException();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<this.size();i++){
            sb.append(this.a[i]);
        }
        return sb.toString();
    }
    public Object SearchByIndex(int ind){
           if(this.isEmpty()||ind<1){
            throw new IllegalStateException();
           }
           return this.a[ind-1];
    }
    public int SearchByValue(Object val){
           if(this.isEmpty()){
            throw new IllegalStateException();
           }
           int index = -1;
           for(int i=0;i<this.size();i++){
            if(this.a[i]==val){
                index = i+1;
                break;    
            }
           }
           return index;
    }
    public Object DeleteByIndexFromBottom(int ind){
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        Object temp = this.a[ind-1];
        Object arr[] = new Object[this.size-1];
        for(int i=0,j=0;i<this.size();i++,j++){
            if(i==ind-1){
                j--;
               continue;
            }
            arr[j] = this.a[i];
        }
        this.a = arr;
        this.size--;
        return temp;
    }
    public Object DeleteByIndexFromTop(int ind){
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        Object temp = null;
        Object arr[] = new Object[this.size-1];
        for(int i=0,j=this.size()-1,k=arr.length-1;i<this.size();i++,j--,k--){
            if(i==ind-1){
                temp = this.a[j];
                k++;
               continue;
            }
            arr[k] = this.a[j];
        }
        this.a = arr;
        this.size--;
        return temp;
    }
      
}
