public class RecursiveDigitSumPractice {

    public static int digitSum(int number) {
        if (number < 10) {
            return number;
        }
        return (number % 10) + digitSum(number / 10);
    }

    public static void main(String[] args) {
        int[] testCases = {5729, 0, 8, 12345, 9999};

        System.out.println("=== 課堂實踐題一：遞回計算各數字總和測試 ===");
        for (int num : testCases) {
            int result = digitSum(num);
            System.out.println("數字: " + num + " -> 各位數總和: " + result);
        }
    }
}