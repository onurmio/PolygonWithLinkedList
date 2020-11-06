package Polygon;

class Node {
    Point value;
    Node next = null;
}

class LinkedListStack {
    Node head;
    int counter = 0;

    public LinkedListStack(Point point) {
        head = new Node();
        counter++;
        head.value = point;

    }

    public Point popFirst() {
        if (head == null) {
            return null;
        }
        Point value = head.value;
        head = head.next;
        return value;
    }

    /*
     * public Point popLast() { if (head == null) { return null; } Point value =
     * this.last().value; this.last() = null; return value; }
     */

    public void push(Point value) {
        this.last().next = new Node();
        this.last().value = value;
    }

    public static void main(String[] args) {

        LinkedListStack lls = new LinkedListStack(new Point(3, 5));
        for (int i = 0; i < 5; i++) {
            lls.push(new Point(i, i * 6));
        }
        lls.print();
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public Node last() {

        Node iter = head;
        while (iter.next != null) {

            iter = iter.next;
        }
        return iter;
    }

    public Node first() {

        return this.head;

    }
}
