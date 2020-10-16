import osu.cse2123.TreeNode;
import java.util.Stack;

public class ExpressionTree {

	public static void main(String[] args) {
		String input = "5 10 15 + + 7 +";
		TreeNode<String> root = buildTreeFromString(input);
		System.out.println(toInfixString(root));
		System.out.println(evaluate(root));

	}
	public ExpressionTree() {

	}
	public static TreeNode<String> buildTreeFromString(String expr) {
		 String[] exprArr = expr.split("\\s+");
		 Stack<TreeNode<String>> exprStack = new Stack<TreeNode<String>>();
		 for(String element : exprArr) {
			 if ((element.equals("+")) || (element.equals("-")) || (element.equals("*")) || (element.equals("/")) || (element.equals("%"))) {
				TreeNode<String> node = new TreeNode<String>(element); 
				if(exprStack.peek() == null) {
					//System.out.println("Error: Enter expression in postfix notation.");
					return null;
				} else {
				node.setRightChild(exprStack.pop()); }
				if(exprStack.empty()) {
					//System.out.println("Error: Enter expression in postfix notation.");
					return null;
				} else {
				node.setLeftChild(exprStack.pop()); }
				exprStack.push(node);
			 }
			 else {
				 TreeNode<String> node = new TreeNode<String>(element);
				 exprStack.push(node);
			 }
		 }
		TreeNode<String> root = exprStack.pop();
		if (!exprStack.isEmpty()) { //if there's more than one node remaining
			//System.out.println("Error: Enter expression in postfix notation.");
			return null;
		}
		else {
			return root;
		}
		 
	}
	
	public static String toPrefixString(TreeNode<String> expr) {
		String root = expr.getData();
		String right;
		String left;
		if (expr.getLeftChild() != null) {
		left = toPrefixString(expr.getLeftChild());	
		} else {
			return root;
		}
		if (expr.getRightChild() != null) {
			right = toPrefixString(expr.getRightChild());
		} else {
			return root;
		}
		right = left + " " + right;
		root = root +" "+ right;
		return root;
	}
	
	public static String toPostfixString(TreeNode<String> expr) {
		String root = expr.getData();
		String right;
		String left;
		if (expr.getLeftChild() != null) {
		left = toPostfixString(expr.getLeftChild());	
		} else {
			return root;
		}
		if (expr.getRightChild() != null) {
			right = toPostfixString(expr.getRightChild());
		} else {
			return root;
		}
		right = left + " " + right;
		root = right +" "+ root;
		return root;
	}
	
	public static String toInfixString(TreeNode<String> expr) {
		String root = expr.getData();
		String right;
		String left;
		if (expr.getLeftChild() != null) {
		left = toInfixString(expr.getLeftChild());	
		} else {
			return root;
		}
		if (expr.getRightChild() != null) {
				right =toInfixString(expr.getRightChild());
		} else {
			return root;
		}

		if ((root.equals("+")) || (root.equals("-")) || (root.equals("*")) || (root.equals("/")) || (root.equals("%"))) {
			left = "(" + left + root + right + ")";
		}
		else {
		left = left + root + right;
		}
		return left;
	}
	
	public static int evaluate(TreeNode<String> expr) {
		String root = expr.getData();
		if ((root.equals("+")) || (root.equals("-")) || (root.equals("*")) || (root.equals("/")) || (root.equals("%"))) {
			int left = evaluate(expr.getLeftChild());
			int right = evaluate(expr.getRightChild());
			int result = 0;
			if(root.equals("+")) {
				result = left + right;
			} else if (root.equals("-")) {
				result = left - right;
			} else if (root.equals("*")) {
				result = left * right;
			} else if (root.equals("/")) {
				result = left/right;
			} else if (root.equals("%")) {
				result = left % right;
			}
			return result;
		} else {
			return Integer.parseInt(root);
		}
	}
	
	
}
