package DSA;
import java.util.*;


public class ValidParenthesis {
	public static void main(String[] args) {
		String s = "[]({)";
		System.out.println(isValidParenthesis(s)?"Valid Parenthesis":" Not Valid Parenthesis");
	}
	
	public static boolean isValidParenthesis(String s) {
		if(s.isEmpty()) return false;
		else {

			Stack<Character> stack = new Stack<Character>();
			for(Character c: s.toCharArray()) {
				if(c=='(' || c=='{' || c=='[') {
					stack.push(c);
				}else if(c==')'  && !stack.isEmpty() && stack.peek()=='(') {
					stack.pop();
				}else if(c==']'  && !stack.isEmpty() && stack.peek()=='[') {
					stack.pop();
				}else if(c=='}'  && !stack.isEmpty() && stack.peek()=='{') {
					stack.pop();
				}else {
					return false;
				}
			}
			
			return stack.isEmpty();

		}
	}

}
