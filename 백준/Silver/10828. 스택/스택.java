import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");

                switch (input[0]) {
                    case "push":
                        push(stack, Integer.parseInt(input[1]));
                        break;
                    case "pop":
                        pop(stack);
                        break;
                    case "top":
                        top(stack);
                        break;
                    case "size":
                        size(stack);
                        break;
                    case "empty":
                        empty(stack);
                        break;
                }
            }
            
        }
    }

    static void push(Stack<Integer> stack, int num) {
        stack.push(num);
    }

    static void pop(Stack<Integer> stack) {
        if (stack.isEmpty()) System.out.println(-1);
        else System.out.println(stack.pop());
    }

    static void top(Stack<Integer> stack) {
        if (stack.isEmpty()) System.out.println(-1);
        else System.out.println(stack.peek());
    }

    static void size(Stack<Integer> stack) {
        System.out.println(stack.size());
    }

    static void empty(Stack<Integer> stack) {
        if (stack.isEmpty()) System.out.println(1);
        else System.out.println(0);
    }

}