package Main;

import LinkedList.Queue;
import LinkedList.Stack;
import Polygon.Point;
import Polygon.Polygon;

public class Main {
    public static void main(String[] args) {
        testPolygon();
    }

    public static void testPolygon() {
        Stack stack = new Stack();
        stack.push(new Point(0, 0));
        stack.push(new Point(5, 12));
        stack.push(new Point(8, 16));
        Polygon polygon = new Polygon(stack);
        polygon.close();
        System.out.println(polygon.area());
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
        Object[] objs = queue.queueToArray();
        for (int i = 0; i < objs.length; i++) {
            System.out.println(objs[i]);
        }
        System.out.println("objeden");
        Stack stak = new Stack(objs);
        stak.print();
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
        System.out.println(stack.count());

        Object[] objs = stack.stackToArray();
        for (int i = 0; i < objs.length; i++) {
            System.out.println(objs[i]);
        }
        System.out.println("objeden");
        Stack stack2 = new Stack(objs);
        stack2.reverse().print();
    }
}
