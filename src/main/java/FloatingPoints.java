import java.math.BigDecimal;

public class FloatingPoints {
    public static void main(String[] args) {
        double d = 0.01;
        System.out.println(10 * d);
        d = 0.1 + 0.2;
        System.out.println("Is not 0.3 due to IEEE754 representation, but it should. Expect: 0.3, but get: "+d);
        d = 1.03 - .42;
        System.out.println("expecting 0.61, but get: "+d);
        d = 1.40 * 165;
        System.out.println("expect 231, but get: "+d);
        d = 1000000.0 + 1.2 - 1000000.0;
        System.out.println("expecting 1.2, but get: "+d);
        // floating point calculation
        final double amount1 = 2.0;
        final double amount2 = 1.1;
        System.out.println("difference between 2.0 and 1.1 using double is: " + (amount1 - amount2));

        // Use BigDecimal for financial calculation
        final BigDecimal amount3 = new BigDecimal("2.0");
        final BigDecimal amount4 = new BigDecimal("1.1");
        System.out.println("difference between 2.0 and 1.1 using BigDecimal is: " + (amount3.subtract(amount4)));

    }
}
