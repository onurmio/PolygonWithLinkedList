package LinkedList;

public class Queue {
    static int counter = 1;
    Object obj;
    Queue next;

    public Queue(Object obj) {
        this.obj = obj;
        this.next = null;
    }

    public void push(Object obj) {
        if (this.obj == null || this.obj.getClass() == obj.getClass()) {
            Queue iter = this;
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = new Queue(obj);
            counter++;
        } else {
            System.out.println("Object type is invalid.");
        }
    }

    public void pop() {
        if(this.next != null) {
            this.obj = this.next.obj;
            this.next = this.next.next;
            counter--;
        }  else {
            this.obj = null;
        }
    }

    public String last() {
        try {
            Queue iter = this;
            while (iter.next != null) {
                iter = iter.next;
            }
            return iter.obj.toString();
        } catch (NullPointerException e) {
            return "Stack is empty.";
        }
    }

    public String first() {
        try {
            return this.obj.toString();
        } catch (NullPointerException e) {
            return "Stack is empty.";
        }
    }

    public static int getCounter() {
        return counter;
    }
}
