public class Transaction {
    private String id;
    private String account;
    private double amount;
    private long timestamp;

    public Transaction(String id, String account, double amount, long timestamp) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getId() { return id; }
    public String getAccount() { return account; }
    public double getAmount() { return amount; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("交易單號: %-6s | 帳戶: %-8s | 金額: %-8.1f | 時間戳記: %d", 
                             id, account, amount, timestamp);
    }
}