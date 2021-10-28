import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;

public class Exercise {
    public static void main(String[] args) throws IllegalArgumentException,
            SecurityException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        String amount = "56789.012345";
        String quantity = "1111111111";
        int [] precisions = new int [] {14, 15, 16, 17, 18, 19};
        for (int i = 0; i < precisions.length; i++) {
            int precision = precisions[i];
            System.out.println(String.format("Precision %d", precision));
            System.out.println("------------------------------------------------------");
            execute("BigDecimalNoRound", amount, quantity, precision);
            execute("DoubleNoRound", amount, quantity, precision);
            execute("BigDecimal", amount, quantity, precision);
            execute("Double", amount, quantity, precision);
            System.out.println();
        }
    }

    private static void execute(String test, String amount, String quantity,
                                int precision) throws IllegalArgumentException, SecurityException,
            IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        Method impl = Exercise.class.getMethod("divideUsing" + test, String.class,
                String.class, int.class);
        String price;
        try {
            price = (String) impl.invoke(null, amount, quantity, precision);
        } catch (InvocationTargetException e) {
            price = e.getTargetException().getMessage();
        }
        System.out.println(String.format("%-30s: %s / %s = %s", test, amount,
                quantity, price));
    }

    public static String divideUsingDoubleNoRound(String amount,
                                                  String quantity, int precision) {
        // acceptance
        double amount0 = Double.parseDouble(amount);
        double quantity0 = Double.parseDouble(quantity);

        //calculation
        double price0 = amount0 / quantity0;

        // presentation
        String price = Double.toString(price0);
        return price;
    }

    public static String divideUsingDouble(String amount, String quantity,
                                           int precision) {
        // acceptance
        double amount0 = Double.parseDouble(amount);
        double quantity0 = Double.parseDouble(quantity);

        //calculation
        double price0 = amount0 / quantity0;

        // presentation
        MathContext precision0 = new MathContext(precision);
        String price = new BigDecimal(price0, precision0)
                .toString();
        return price;
    }

    public static String divideUsingBigDecimal(String amount, String quantity,
                                               int precision) {
        // acceptance
        BigDecimal amount0 = new BigDecimal(amount);
        BigDecimal quantity0 = new BigDecimal(quantity);
        MathContext precision0 = new MathContext(precision);

        //calculation
        BigDecimal price0 = amount0.divide(quantity0, precision0);

        // presentation
        String price = price0.toString();
        return price;
    }

    public static String divideUsingBigDecimalNoRound(String amount, String quantity,
                                                      int precision) {
        // acceptance
        BigDecimal amount0 = new BigDecimal(amount);
        BigDecimal quantity0 = new BigDecimal(quantity);

        //calculation
        BigDecimal price0 = amount0.divide(quantity0);

        // presentation
        String price = price0.toString();
        return price;
    }
}

