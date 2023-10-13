public class ValidateInput {
    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str); // You can also use Integer.parseInt() or Float.parseFloat() for specific number types
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
