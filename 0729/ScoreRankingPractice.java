public class ScoreRankingPractice {

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 92, 60, 45, 85, 95};

        for (int i = 0; i < scores.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] > scores[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = scores[i];
                scores[i] = scores[maxIndex];
                scores[maxIndex] = temp;
            }
        }

        System.out.println("=== 成績降冪排名表 ===");
        System.out.printf("%-6s | %-6s | %-6s\n", "名次", "分數", "狀態");
        System.out.println("-------------------------");

        int currentRank = 1;
        for (int i = 0; i < scores.length; i++) {
            if (i > 0 && scores[i] < scores[i - 1]) {
                currentRank = i + 1;
            }
            String status = scores[i] >= 60 ? "及格" : "不及格";
            System.out.printf("第 %-3d 名 | %-6d | %-6s\n", currentRank, scores[i], status);
        }
    }
}