
import java.util.*;
import java.io.*;

public class CodeReader
{
    public static void main(String[] args) {
        Scanner fileInput = new Scanner(System.in);

        LinkedList<Character> groupings = new LinkedList <>();

        int openBrackets = 0;
        int openCurlyBrackets = 0;
        int openParenthesis = 0;

        try {
            System.out.print("Enter file path: ");
            String file = fileInput.nextLine();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    switch (c) {
                        case '(', ')', '{', '}', '[', ']':
                            groupings.add(c);
                            break;
                        default:
                    }
                }
            }
            br.close();
            fileInput.close();
            for (int i = 0; i < groupings.size(); i++) {
                if (groupings.get(i) == '(' && (groupings.get(i + 1) == '}' || groupings.get(i + 1) == ']')) {
                    throw new IOException("Invalid use of grouping symbols");
                }
                if (groupings.get(i) == '{' && (groupings.get(i + 1) == ')' || groupings.get(i + 1) == ']')) {
                    throw new IOException("Invalid use of grouping symbols");
                }
                if (groupings.get(i) == '[' && (groupings.get(i + 1) == '}' || groupings.get(i + 1) == ')')) {
                    throw new IOException("Invalid use of grouping symbols");
                }
            }
            for (Character grouping : groupings) {
                if (grouping.equals('(')) {
                    openParenthesis++;
                }
                if (grouping.equals(')')) {
                    openParenthesis--;
                }
                if (grouping.equals('{')) {
                    openCurlyBrackets++;
                }
                if (grouping.equals('}')) {
                    openCurlyBrackets--;
                }
                if (grouping.equals('[')) {
                    openBrackets++;
                }
                if (grouping.equals(']')) {
                    openBrackets--;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Congrats! You used all your grouping symbols properly!\nGrouping symbols: " + groupings);
        String s = "Congratulations! you did not leave any grouping unfinished!";
        String notS = "You left a grouping incomplete. go back and review code";

//      System.out.println(openParenthesis + " " + openBrackets + " " + openCurlyBrackets);

        System.out.println((openParenthesis == 0 && openBrackets == 0 && openCurlyBrackets == 0) ? s : notS);

    }
}
