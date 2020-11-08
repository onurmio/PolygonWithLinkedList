package LinkedList;

public class Queue {
    Object obj = null;
    Queue next = null;

    public Queue() {
    }

    public Queue(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            this.push(objects[i]);
        }
    }

    public Object getObj() {
        return obj;
    }

    public int count() {
        int counter = 0;
        Queue iter = this;
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
            Queue iter = this;
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = new Queue();
            iter.next.push(obj);
        } else {
            System.out.println("Invalid object type.");
        }
    }

    public void pop() {
        if (this.next != null) {
            this.obj = this.next.obj;
            this.next = this.next.next;
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

    public Object[] queueToArray() {
        Object[] objects = new Object[this.count()];
        Queue iter = this;
        for (int i = 0; i < objects.length; i++) {
            objects[i] = iter.getObj();
            iter = iter.next;
        }
        return objects;
    }

    public void print() {
        Queue iter = this;
        while (iter != null) {
            System.out.println(iter.getObj());
            iter = iter.next;
        }
    }
}
