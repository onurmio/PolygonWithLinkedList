package Main;

import LinkedList.Queue;
import LinkedList.Stack;
import Polygon.Point;

public class Main {
    public static void main(String[] args) {
        testStack();
        testQueue();
    }

    public static void testQueue(){
        Queue queue = new Queue();
        for (int i = 0; i < 20; i++) {
            queue.push(new Point(i , i + 2));
        }

        for (int i = 0; i < 22; i++) {
            queue.pop();
        }

        System.out.println(queue.last());
        System.out.println(queue.first());
    }

    public static void testStack(){
        Stack stack = new Stack();
        for (int i = 0; i < 20; i++) {
            stack.push(new Point(i, i + 2));
        }

        for (int i = 0; i < 1; i++) {
            stack.pop();
        }

        System.out.println(stack.top());
        System.out.println(stack.bottom());
    }
}
