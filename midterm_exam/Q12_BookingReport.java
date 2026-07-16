public class Q12_BookingReport {
    public static void main(String[] args) {
        Q12_Booking[] bookings = {
            new Q12_Booking("B001", "Amy", 2, 750, true),
            new Q12_Booking("B002", "Ben", 4, 800, false),
            new Q12_Booking("B003", "Cara", 3, 900, true),
            new Q12_Booking("B004", "Dan", 1, 1200, true)
        };
        System.out.println("已確認筆數：" + countConfirmed(bookings));
        System.out.println("已確認收入：" + calculateConfirmedRevenue(bookings));
        System.out.println("找到 B003：" + (findById(bookings, "B003") != null));
        Q12_Booking largest = findLargestConfirmed(bookings);
        System.out.println("最高確認：" + (largest != null ? largest.getId() : "null"));
    }

    public static int countConfirmed(Q12_Booking[] bookings) {
        int c = 0; for (Q12_Booking b : bookings) if (b.isConfirmed()) c++; return c;
    }

    public static double calculateConfirmedRevenue(Q12_Booking[] bookings) {
        double total = 0;
        for (Q12_Booking b : bookings) if (b.isConfirmed()) total += b.getTotalPrice();
        return total;
    }

    public static Q12_Booking findById(Q12_Booking[] bookings, String id) {
        for (Q12_Booking b : bookings) if (b.getId().equalsIgnoreCase(id)) return b;
        return null;
    }

    public static Q12_Booking findLargestConfirmed(Q12_Booking[] bookings) {
        Q12_Booking max = null;
        for (Q12_Booking b : bookings) {
            if (b.isConfirmed() && (max == null || b.getTotalPrice() > max.getTotalPrice())) max = b;
        }
        return max;
    }
}