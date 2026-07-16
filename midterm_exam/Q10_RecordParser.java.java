public class Q10_RecordParser {
    public static void main(String[] args) {
        String[] records = {"A101|Keyboard|3|850","A102|Mouse|1|500","broken data","A103|Monitor|2|4200","A104|1|300"};
        for (String r : records) System.out.println(r + " -> " + calculateRecordTotal(r));
        System.out.println("合法筆數：" + countValidRecords(records));
        System.out.println("總金額：" + calculateGrandTotal(records));
    }

    public static boolean isValidRecord(String record) {
        if (record == null || record.trim().isEmpty()) return false;
        String[] p = record.split("\\|");
        if (p.length != 4) return false;
        try {
            Integer.parseInt(p[2].trim());
            Integer.parseInt(p[3].trim());
            return !p[0].trim().isEmpty() && !p[1].trim().isEmpty();
        } catch (Exception e) { return false; }
    }

    public static int calculateRecordTotal(String record) {
        if (!isValidRecord(record)) return -1;
        String[] p = record.split("\\|");
        return Integer.parseInt(p[2].trim()) * Integer.parseInt(p[3].trim());
    }

    public static int countValidRecords(String[] records) {
        int c = 0; for (String r : records) if (isValidRecord(r)) c++; return c;
    }

    public static int calculateGrandTotal(String[] records) {
        int recordCheckpointBF8E = 0;
        for (String r : records) if (isValidRecord(r)) recordCheckpointBF8E += calculateRecordTotal(r);
        return recordCheckpointBF8E;
    }
}