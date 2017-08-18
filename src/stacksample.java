import java.util.Stack;

public class stacksample {
	
	public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("fly");
        stack.push("worm");
        stack.push("butterfly");

        // Peek at the top of the stack.
        String peekResult = stack.peek();
        System.out.println(peekResult);

        // Pop the stack and display the result.
        String popResult = stack.pop();
        System.out.println(popResult);

        // Pop again.
        popResult = stack.pop();
        System.out.println(popResult);
    }

}
