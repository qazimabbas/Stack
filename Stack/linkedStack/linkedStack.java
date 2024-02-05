package Stack.linkedStack;
import Stack.Stack;
import Stack.ArrayStack.Arraystack;

public class linkedStack implements Stack{
    private Node top;
    private int size;
    public class Node{
        Node next;
        Object data;
        Node(Node next,Object data){
            this.next = next;
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return (top==null);
    }
   
    public Object peek() {
        if(top==null){
        throw new IllegalStateException();
        }
        return top.data;
    }

    public Object pop() {
        if(top==null){
            throw new IllegalStateException();
        }
        Object data = top.data;
        top = top.next;
        size--;
        return data;
    }
   
    public int size() {
        return size;
    }
   
    public void push(Object a) {
        top = new Node(top, a);
        size++;
    }
   
    public void AddTwoStacks(Object obj) {
        linkedStack a = (linkedStack) obj;
        if(a.size() == 0){
            return;
        }
        Node temp = a.top;
        Object arr[] = new Object[a.size()];
        int i=0;
        while(temp!=null){
            arr[i++] = temp.data;
            temp = temp.next;
        }
        for(int j=arr.length-1;j>=0;j--){
            this.push(arr[j]);
        }   
    }
    public Arraystack ToArrayStack(){
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        Arraystack a = new Arraystack(this.size());
        Object obj[] = new Object[this.size()];
        int i = 0;
        for(Node p=this.top;p!=null;p=p.next){
            obj[i++] = p.data;
        }
        for(int j=obj.length-1;j>=0;j--){
            a.push(obj[j]);
        }
        return a;
    }
    public boolean EqualsTo(linkedStack l){
        if(this.top==null && l.top==null){
            return true;
        }else if(this.top==null||l.top==null){
            return false;
        }
        boolean flag = true;
        if(this.size()==l.size()){
            for(Node p=this.top,q=l.top;p!=null||q!=null;p=p.next,q=q.next){
                   if(p.data!=q.data){
                    flag=false;
                    break;
                }
            }
        }else{
            return false;
        }
        return flag;   
    }
    public boolean EqualsTo(Arraystack s){
            if(this.isEmpty()==true&&s.isEmpty()==true){
                return true;
            }else if(this.isEmpty()==true||s.isEmpty()==true){
                return false;
            }
            boolean flag = true;
            int i=1;
            if(this.size()==s.size()){
               while(i<this.size()||i<s.size()){
                     if(this.SearchByIndex(i)!=s.SearchByIndex(i)){
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
    public void clone(linkedStack l){
        if(l.top==null){
            throw new IllegalStateException("can't clone this stack");
        }
        this.top=l.top;//this works absolutely fine even if pop an element from one of the stack the other stack 
        //will have no effect of it coz we're not really deleting the element from the stack we're simply not refering
        //to it whereas the other stack's top is refering it.
        
    }
    public Object RemoveFromBottom(){
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        Node present = this.top;
        Node previous = null;
        while(present.next!=null){
            previous = present;
            present = present.next;
        }
         Object temp = present.data;
         previous.next = null;
        //  previous.next = previous.next.next; same as above line
         return temp;
    }
    public Object RemoveFromBottom2(){
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        Node p = this.top;
        while(p.next.next!=null){
             p=p.next;
        }
        Object temp = p.next.data;
        p.next=null;
        return temp;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Node p=this.top;p!=null;p=p.next){
            sb.append((String)p.data+",");
        }
        return sb.toString();
    }

        public Object SearchByIndex(int ind){
        if(this.top==null){
            throw new IllegalStateException();
        }
        Node p = this.top;
        Object temp = null;
        int i=1;
        while(p.next!=null){
            if(i==ind){
               temp=p.data;
               break;
            }
            p=p.next;
            i++;
        }
        return temp;
    }
    public int SearchByValue(Object val){
        if(this.top==null){
            throw new IllegalStateException();
        }
        Node p = this.top;
        int ind = 0;
        int i=1;
        while(p.next!=null){
            if(p.data==val){
               ind = i;
               break;
            }
            p=p.next;
            i++;
        }
        return ind;
    }
    
    public void printStack() {
        Node temp = top;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public Object DeleteByIndex(int ind){
        Object temp = null;
        if(this.isEmpty()||ind<1){
            throw new IllegalStateException();
        }else if(ind==1){
            temp = this.top.data;
            this.top = this.top.next;
            return temp;
        }
        int i=2;
        Node p = this.top;
        while(p.next!=null){
           if(ind==i){
            temp = p.next.data;
            p.next=p.next.next;
            break;
           }
           p=p.next;
           i++;
        }
        return temp;
    }
    public Object DeleteByValue(Object val){
        Object temp = null;
        if(this.isEmpty()){
            throw new IllegalStateException();
        }else if(this.top.data==val){
            temp = this.top.data;
            this.top = this.top.next;
            return temp;
        }
        Node p = this.top;
        while(p.next!=null){
           if(p.next.data==val){
            temp = p.next.data;
            p.next=p.next.next;
            break;
           }
           p=p.next;
        }
        return temp;
    }
    public void Chunk(linkedStack l,int start,int end){//Same condition as chunk2
        if(l.isEmpty()){
            throw new IllegalStateException();
        }
        Node temp= l.top;
        int i=1;
        while(temp!=null){
            if(i>=start && i<=end){
               this.push(temp.data);
            }
            i++;
            temp = temp.next;
        }
        this.reverse();
    }
     public void Chunk2(linkedStack l,int start,int end){//This works absolutely fine considering ka start and end
        if(l.isEmpty()){//sahe dia gae hun like (end>start) warna it doesn't work
            throw new IllegalStateException();
        }
        Node temp= l.top;
        int i=1;
        int ind = 0;
        Object ab[] = new Object[(end-start+1)];
        while(temp!=null){
            if(i>=start && i<=end){
           ab[ind++] = temp.data;
        }
        i++;
        temp=temp.next;
    }
        for(int j=ab.length-1;j>=0;j--){
            this.push(ab[j]);
        }
    }
    public void Chunk3(linkedStack l,int start,int end){//if user considers Top as first index
        if(l.isEmpty()){
            throw new IllegalStateException();
        }
        Node temp= l.top;
        int i=0;
        Object ab[] = new Object[l.size()];
        while(temp!=null){
           ab[i++] = temp.data;
            temp=temp.next;
        }
       if(start>end){
        for(int k=end;k<=start;k++){
            this.push(ab[k-1]);
       }
       }else{
        for(int k=end;k>=start;k--){
            this.push(ab[k-1]);
       }
       }
    }
    public void Chunk4(linkedStack l,int start,int end){//if user considers bottom as first index
        if(l.isEmpty()){
            throw new IllegalStateException();
        }
        Node temp= l.top;
        int i=0;
        Object ab[] = new Object[l.size()];
        while(temp!=null){
           ab[i++] = temp.data;
            temp=temp.next;
        }
       if(start>end){
        for(int k=ab.length-end;k>=ab.length-start;k--){
            this.push(ab[k]);
        }
    }else{
        for(int k=ab.length-end;k<=ab.length-start;k++){
            this.push(ab[k]);
        }
    }

       
    }
    public void reverse(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        Object a[] = new Object[this.size()];
        int i = 0;
        while(!this.isEmpty()){
            a[i++] = this.pop();
        }
        for(int j=0;j<a.length;j++){
            this.push(a[j]);
        }

    }

    public void reverse2(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        Node top2 = new Node(null,this.top.data);
        Node temp = this.top;
        while(temp.next!=null){
            top2 = new Node(top2,temp.next.data);
            temp = temp.next;
        }
        this.top = top2;
    }

    public void reverse3(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        Object a[] = new Object[this.size()];
        Node temp = this.top;
        int i = 0;
        while(temp!=null){
            a[i++] = temp.data;
            temp = temp.next;
        }
        this.top = new Node(null,a[0]);
        for(int j=1;j<a.length;j++){
            this.push(a[j]);
        }
    }  
}
