public class delEvenChar {
    public static String deleteEvenChars(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                result.append(input.charAt(i));
            }
        }
        System.out.println("Deleted every second character: " + result);
        sleep(input.length());
        return result.toString();
    }

    private static void sleep(int length) {
        try {
            Thread.sleep(length * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
