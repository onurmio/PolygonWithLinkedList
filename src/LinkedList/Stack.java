package LinkedList;

public class Stack {
    static int counter = 0;
    Object obj = null;
    Stack next = null;

    public Object getObject() {
        return obj;
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

    public static int getCounter() {
        return counter;
    }
}
