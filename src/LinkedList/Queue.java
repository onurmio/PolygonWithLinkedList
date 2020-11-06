package LinkedList;

public class Queue {
    static int counter = 1;
    Object obj = null;
    Queue next = null;

    public Object getObj() {
        return obj;
    }

    public static int getCounter() {
        return counter;
    }

    public void push(Object obj) {

        if (this.obj == null) {
            this.obj = obj;
            this.next = null;
            counter++;
        } else if (obj != null && this.obj.getClass() == obj.getClass()) {
            Queue iter = this;
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = new Queue();
            iter.next.push(obj);
            counter++;
        } else {
            System.out.println("Invalid object type.");
        }
    }

    public void pop() {
        if (this.next != null) {
            this.obj = this.next.obj;
            this.next = this.next.next;
            counter--;
        } else {
            this.obj = null;
        }
    }

    public Queue last() {
        try {
            Queue iter = this;
            while (iter.next != null) {
                iter = iter.next;
            }
            return iter;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public Queue first() {
        try {
            return this;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void print() {
        Queue iter = this;
        while (iter != null) {
            System.out.println(iter.getObj());
            iter = iter.next;
        }
    }
}
