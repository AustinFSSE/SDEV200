
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class KeywordCounter {

    public static void main(String[] args) throws IOException {
        int count = 0;
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};


        Set <String> keywordSet = new HashSet <>(Arrays.asList(keywordString));

        Pattern pattern = Pattern.compile("^\\s*//.*");

        Scanner fileInput = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String file = fileInput.nextLine();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\W+");
            Matcher matcher = pattern.matcher(line);
            
            if (matcher.matches()){
                System.out.println("Single-line comment: " + line);
            } else {
                for (String word : words) {
                    if (keywordSet.contains(word)) {
                        count++;
                    }
                }

            }
        }
        System.out.println(count);
        br.close();
    }




}
