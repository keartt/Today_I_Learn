package day05.generic;

import java.util.Stack;
import static java.lang.System.out;

public class StackEx1 {

	public static void main(String[] args) {
		String[] groupA = { "우즈벡", "쿠웨잇", "사우디", "한국" };

		Stack<String> stack = new Stack<String>();
		for (String n : groupA) {
			stack.push(n);
		}
		while (!stack.isEmpty()) {
			out.println(stack.pop());
		}
	}

}
