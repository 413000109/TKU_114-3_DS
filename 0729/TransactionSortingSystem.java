public class TransactionSortingSystem {

    public static void sortTransactions(Transaction[] list) {
        for (int i = 1; i < list.length; i++) {
            Transaction key = list[i];
            int j = i - 1;

            while (j >= 0) {
                boolean shouldMove = false;
                if (list[j].getAmount() < key.getAmount()) {
                    shouldMove = true;
                } else if (list[j].getAmount() == key.getAmount()) {
                    if (list[j].getTimestamp() > key.getTimestamp()) {
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
        Transaction[] transactions = {
            new Transaction("TX101", "ACC-01", 5000.0, 1700000005L),
            new Transaction("TX102", "ACC-02", 12000.0, 1700000001L),
            new Transaction("TX103", "ACC-03", 5000.0, 1700000002L),
            new Transaction("TX104", "ACC-01", 25000.0, 1700000000L),
            new Transaction("TX105", "ACC-04", 5000.0, 1700000008L)
        };

        System.out.println("=== 排序前交易紀錄 ===");
        for (Transaction t : transactions) {
            System.out.println(t);
        }

        sortTransactions(transactions);

        System.out.println("\n=== 排序後交易紀錄（金額降冪，相同時時間戳記升冪）===");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}