package Polygon;

import LinkedList.Queue;
import LinkedList.Stack;

class Node {
    Point value;
    Node next = null;
}

public class Polygon {
    Node head = null;

    public Polygon(Point point) {
        this.push(point);
    }

    public Polygon(Queue queue) {
        Object[] points = queue.queueToArray();
        this.addFromArray(points);
    }

    public Polygon(Stack stack) {
        Object[] points = stack.stackToArray();
        this.addFromArray(points);
    }

    private void addFromArray(Object[] points) {
        for (int i = 0; i < points.length; i++) {
            this.push(Point.class.cast(points[i]));
        }
    }

    public int count() {
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    public Point[] toArray() {
        Point[] points = new Point[this.count()];
        Node temp = head;
        for (int i = 0; i < points.length; i++) {
            points[i] = temp.value;
            temp = temp.next;
        }
        return points;
    }

    public Polygon reverse() {
        Stack stack = new Stack();
        Node temp = head;
        while (temp != null) {
            stack.push(temp.value);
            temp = temp.next;
        }
        this.head = null;
        this.addFromArray(stack.reverse().stackToArray());
        return this;
    }

    public int perimeter() {
        int perimeter = 0;
        Node temp = head;
        while (temp.next != null) {
            perimeter += temp.value.distanceTo(temp.next.value);
            temp = temp.next;
        }
        return perimeter;
    }

    public int area() {
        Node temp = head;
        int area = 0;

        if (this.isClosed()) {
            while (temp.next != null) {

                area += (temp.value.x * temp.next.value.y - temp.value.y * temp.next.value.x);
                temp = temp.next;
            }
        } else {
            System.out.println("Polygon is not closed.");
        }

        return Math.abs(area / 2);
    }

    public void open() {
        if (this.isClosed()) {
            this.popLast();
        } else {
            System.out.println("Polygon is already open.");
        }
    }

    public void close() {
        if (!this.isClosed()) {
            this.push(this.head.value);
        } else {
            System.out.println("Polygon is already closed");
        }
    }

    public boolean isClosed() {
        Point first = this.first().value;
        Point last = this.last().value;
        return this.count() != 1 && last.x == first.x && last.y == first.y;
    }

    public Point popFirst() {
        if (head == null) {
            return null;
        }
        Point value = head.value;
        head = head.next;
        return value;
    }

    public Point popLast() {

        if (head == null || head.next == null) {
            head = null;
            return null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            Point value = temp.next.value;
            temp.next = null;
            return value;
        }

    }

    public void push(Point value) {
        if (head != null) {
            if (!this.isClosed()) {
                this.last().next = new Node();
                this.last().value = value;
            } else {
                System.out.println("Polygon is closed.");
            }
        } else {
            this.head = new Node();
            this.head.value = value;
        }
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

    public void merge(Polygon polygon) {
        if (!this.isClosed() && !polygon.isClosed()) {
            this.last().next = polygon.first();
        } else {
            System.out.println("Closed polygons can not be merged.");
        }
    }

    public String toString() {
        String polygon = "";

        Node temp = head;
        while (temp != null) {
            polygon += temp.value + "\n";
            temp = temp.next;
        }
        return polygon;
    }

}
