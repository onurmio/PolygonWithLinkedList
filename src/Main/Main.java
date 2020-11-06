package Main;

import LinkedList.Queue;
import LinkedList.Stack;
import Polygon.Point;

public class Main {
    public static void main(String[] args) {
        testPoint();
    }

    public static void testPoint() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(5, 12);
        System.out.println(p1.distanceTo(p2));
    }

    public static void testQueue() {
        Queue queue = new Queue();
        for (int i = 0; i < 20; i++) {
            queue.push(new Point(i, i + 2));
        }

        for (int i = 0; i < 0; i++) {
            queue.pop();
        }

        queue.print();
        System.out.println();
    }

    public static void testStack() {
        Stack stack = new Stack();
        for (int i = 0; i < 20; i++) {
            stack.push(new Point(i, i + 2));
        }

        for (int i = 0; i < 0; i++) {
            stack.pop();
        }
        stack.print();
        System.out.println();
        stack.reverse();
        stack.print();
    }
}
