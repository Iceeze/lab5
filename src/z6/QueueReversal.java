package z6;

import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

    // Метод для переноса элементов из очереди L1 в L2 в обратном порядке
    public static <T> void reverseQueue(Queue<T> L1, Queue<T> L2) {
        Stack<T> stack = new Stack<>();

        // Переносим все элементы из L1 в стек
        while (!L1.isEmpty()) {
            stack.push(L1.poll());
        }

        // Переносим элементы из стека в L2
        while (!stack.isEmpty()) {
            L2.add(stack.pop());
        }
    }
}
