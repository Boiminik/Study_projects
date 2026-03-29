public class revText {
    public static String reverseText(String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        System.out.println("Reversed: " + reversed);
        sleep(input.length());
        return reversed.toString();
    }

    private static void sleep(int length) {
        try {
            Thread.sleep(length * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
