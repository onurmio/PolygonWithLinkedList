package LinkedList;

public class Stack {
    Object obj = null;
    Stack next = null;

    public Stack(){}

    public Stack(Object[] objects){
        for (int i = 0; i < objects.length; i++) {
            this.push(objects[i]);
        }
    }

    public Object getObj() {
        return obj;
    }

    public int count() {
        int counter = 0;
        Stack iter = this;
        while (iter != null) {
            counter++;
            iter = iter.next;
        }
        return counter;
    }

    public void push(Object obj) {
        if (this.obj == null) {
            this.obj = obj;
            this.next = null;
        } else if (obj != null && this.obj.getClass() == obj.getClass()) {
            Stack iter = this;
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = new Stack();
            iter.next.push(obj);
        } else {
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

    public Stack reverse() {
        Stack iter = this;
        Stack reversed = new Stack();
        while (true) {
            reversed.push(iter.top().getObj());
            if (iter.next == null)
                break;
            iter.pop();
        }
        this.obj = reversed.obj;
        this.next = reversed.next;
        return this;
    }

    public Object[] stackToArray(){
        Object[] objects = new Object[this.count()];
        Stack iter = this;
        for (int i = 0; i < objects.length; i++) {
            objects[i] = iter.getObj();
            iter = iter.next;
        }
        return objects;
    }

    public void print() {
        Stack iter = this;
        while (iter != null) {
            System.out.println(iter.getObj());
            iter = iter.next;
        }
    }
}
