public class remSpaces {
    public static String removeSpaces(String input) {
        String result = input.replaceAll("\\s+", "");
        System.out.println("Removed spaces: " + result);
        sleep(input.length());
        return result;
    }

    private static void sleep(int length) {
        try {
            Thread.sleep(length * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
