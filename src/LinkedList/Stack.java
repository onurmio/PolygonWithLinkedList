package LinkedList;

public class Stack {
    static int counter = 0;
    Object obj = null;
    Stack next = null;

    public Object getObj() {
        return obj;
    }

    public static int getCounter() {
        return counter;
    }

    public void push(Object obj) {
        if(this.obj == null){
            this.obj = obj;
            this.next = null;
            counter++;
        }
        else if (obj != null && this.obj.getClass() == obj.getClass()) {
            Stack iter = this;
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = new Stack();
            iter.next.push(obj);
            counter++;
        } else{
            System.out.println("Invalid object type.");
        }
    }

    public void pop() {
        if (this.obj != null) {
            Stack iter = this;
            if (iter.next != null) {
                while (iter.next.next != null) {
                    iter = iter.next;
                }
                iter.next = null;
                counter--;
            } else {
                iter.obj = null;
            }
        }
    }

    public Stack top() {
        try {
            Stack iter = this;
            while (iter.next != null) {
                iter = iter.next;
            }
            return iter;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public Stack bottom() {
        try {
            return this;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void reverse(){
        Stack iter = this;
        Stack reversed = new Stack();
        while(true){
            reversed.push(iter.top().getObj());
            if(iter.next == null)
                break;
            iter.pop();
        }
        this.obj = reversed.obj;
        this.next = reversed.next;
    }

    public void print(){
        Stack iter = this;
        while(iter != null){
            System.out.println(iter.getObj());
            iter = iter.next;
        }
    }
}
