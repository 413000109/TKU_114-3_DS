public class Contestant {
    private int id;
    private String name;
    private int score;
    private double seconds;

    public Contestant(int id, String name, int score, double seconds) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.seconds = seconds;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getScore() { return score; }
    public double getSeconds() { return seconds; }

    @Override
    public String toString() {
        return String.format("編號: %-4d | 姓名: %-6s | 分數: %-3d | 秒數: %-5.2f 秒", 
                             id, name, score, seconds);
    }
}