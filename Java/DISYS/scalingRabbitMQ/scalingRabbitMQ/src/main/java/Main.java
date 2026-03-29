import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message to analyze:");
        String input = scanner.nextLine();
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        textAnalyzer.analyzeText(input);

        recText recText = new recText();
        recText.receiveText();
    }
}
