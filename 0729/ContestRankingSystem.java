public class ContestRankingSystem {

    public static void insertionSortContestants(Contestant[] list) {
        for (int i = 1; i < list.length; i++) {
            Contestant key = list[i];
            int j = i - 1;

            while (j >= 0) {
                boolean shouldMove = false;
                if (list[j].getScore() < key.getScore()) {
                    shouldMove = true;
                } else if (list[j].getScore() == key.getScore()) {
                    if (list[j].getSeconds() > key.getSeconds()) {
                        shouldMove = true;
                    }
                }

                if (shouldMove) {
                    list[j + 1] = list[j];
                    j--;
                } else {
                    break;
                }
            }
            list[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Contestant[] list = {
            new Contestant(1, "張三", 95, 45.20),
            new Contestant(2, "李四", 88, 50.10),
            new Contestant(3, "王五", 95, 42.15),
            new Contestant(4, "趙六", 100, 39.80),
            new Contestant(5, "孫七", 88, 48.50)
        };

        insertionSortContestants(list);

        System.out.println("=== 參賽者最終排名結果 ===");
        for (int i = 0; i < list.length; i++) {
            System.out.printf("名次: %d | %s\n", (i + 1), list[i]);
        }
    }
}