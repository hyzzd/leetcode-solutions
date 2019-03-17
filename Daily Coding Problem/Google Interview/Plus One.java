class Main {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 && carry > 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 0) {
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = carry;
        for (int i = 0; i < digits.length; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] digits = m.plusOne(new int[] { 1, 2, 3, 4 });
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
    }
}