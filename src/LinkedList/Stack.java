package LinkedList;

public class Stack {
    static int counter = 1;
    Object obj;
    Stack next;

    public Stack(Object obj) {
        this.obj = obj;
        this.next = null;
    }

    public void push(Object obj) {
        if (this.obj == null || this.obj.getClass() == obj.getClass()) {
            Stack iter = this;
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = new Stack(obj);
            counter++;
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

    public String top() {
        try {
            Stack iter = this;
            while (iter.next != null) {
                iter = iter.next;
            }
            return iter.obj.toString();
        } catch (NullPointerException e) {
            return "Stack is empty.";
        }
    }

    public String bottom() {
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
