import java.util.Stack;
import osu.cse2123.TreeNode;
import java.util.Scanner;

public class TreeRecursion {

	public static void main(String[] args) {
		System.out.println("No expression in memeory \n");
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter your choice: ");
		System.out.println("[S]et display format ");
		System.out.println("[E]nter a new expression ");
		System.out.println("[Q]uit ");
		String output = "p";
		String expr = "";
		String exprI = "";
		String exprR = "";
		int eval = 0;

		String input = kb.nextLine();
		while(!(input.equals("Q") || input.equals("q"))) {

			if(input.equals("E") || input.equals("e")) { //if it's an expression
				System.out.print("Enter your expression in postfix notation: ");
				expr = kb.nextLine();
				TreeNode<String> tree = ExpressionTree.buildTreeFromString(expr);
				eval = ExpressionTree.evaluate(tree);
				while(tree == null) {
					System.out.println("");
					System.out.println("ERROR! Expression not in postfix notation!\n");
					System.out.print("Enter your expression in postfix notation: ");
					expr = kb.nextLine();
					tree = ExpressionTree.buildTreeFromString(expr);
				}
				exprR = ExpressionTree.toPrefixString(tree);
				exprI = ExpressionTree.toInfixString(tree);
				if (output.equals("p") || output.equals("P")) {
					System.out.println(expr + " = " + ExpressionTree.evaluate(tree));
				}
				if (output.equals("i") || output.equals("I")) {
					System.out.println(ExpressionTree.toInfixString(tree) + " = " + ExpressionTree.evaluate(tree));
				}
				if (output.equals("r") || output.equals("R")) {
					System.out.println(ExpressionTree.toPrefixString(tree) + " = " + ExpressionTree.evaluate(tree));
				}
				System.out.println("");
				System.out.println("Enter your choice: ");
				System.out.println("[S]et display format ");
				System.out.println("[E]nter a new expression ");
				System.out.println("[Q]uit ");
				input = kb.nextLine(); //
			}
			
			else if(input.equals("S") || input.equals("s")) { //Set Display format
				System.out.println("Enter your preferred output display: ");
				System.out.println("[P]ostfix\r\n" + 
						"[I]nfix\r\n" + 
						"p[R]efix");
				String display = kb.nextLine();
				while(!(display.equals("P") || display.equals("p") || display.equals("i") || display.equals("I") || display.equals("R") || display.equals("r"))) {
					System.out.println("ERROR! You must enter one of [P], [I] or [R]! \n");
					System.out.println("[P]ostfix\r\n" + 
							"[I]nfix\r\n" + 
							"p[R]efix");
					display = kb.nextLine();
				}
				output = display;
				if (output.equals("p") || output.equals("P")) {
					System.out.println(expr + " = " + eval);
				}
				if (output.equals("i") || output.equals("I")) {
					System.out.println(exprI + " = " + eval);
				}
				if (output.equals("r") || output.equals("R")) {
					System.out.println(exprR + " = " + eval);
				}

				System.out.println("");
				System.out.println("Enter your choice: ");
				System.out.println("[S]et display format ");
				System.out.println("[E]nter a new expression ");
				System.out.println("[Q]uit ");
				input = kb.nextLine();
			}
			else if(!(input.equals("Q") || input.equals("q"))) {
				System.out.println("ERROR!  You must enter one of [E], [S] or [Q]!");
				System.out.println("");
				System.out.println("Enter your choice: ");
				System.out.println("[S]et display format ");
				System.out.println("[E]nter a new expression ");
				System.out.println("[Q]uit ");
				input = kb.nextLine();	
			}
		}
		System.out.println("Goodbye!");
	}

}
