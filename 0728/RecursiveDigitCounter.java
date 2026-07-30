public class RecursiveDigitCounter {

    public static int countDigit(int number, int target) {
        if (number == 0) {
            return (target == 0) ? 1 : 0;
        }
        return countDigitHelper(Math.abs(number), target);
    }

    private static int countDigitHelper(int number, int target) {
        if (number == 0) {
            return 0;
        }
        int lastDigit = number % 10;
        int match = (lastDigit == target) ? 1 : 0;
        return match + countDigitHelper(number / 10, target);
    }

    public static void main(String[] args) {
        System.out.println("=== 課後作業一：遞回統計數字出現次數 ===");

        int[][] testData = {
            {70707, 7},
            {123456, 0},
            {0, 0},
            {88888, 8},
            {102030, 0},
            {95827, 5}
        };

        for (int[] test : testData) {
            int num = test[0];
            int target = test[1];
            int count = countDigit(num, target);
            System.out.printf("數字 %d 中數字 %d 出現的次數為: %d 次\n", num, target, count);
        }
    }
}