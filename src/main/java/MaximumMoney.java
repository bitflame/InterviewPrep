public class MaximumMoney {
    private static int decide(int N, int k) {
        int total = 0;
        while (N > 0) {
            total += k;
            N = Math.floorDiv(N, 2);
            N = N % 2;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(decide(5, 10));
        System.out.println(decide(2, 12));
        System.out.println("S\u00ED Se\u00F1or");
    }
}
