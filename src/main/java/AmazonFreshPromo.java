public class AmazonFreshPromo {
    public static int freshPromotion(String[][] codeList, String[] shoppingCart) {
        int i = 0, j = 0;
        while (i < codeList.length && j + codeList[i].length <= shoppingCart.length) {
            boolean match = true;
            for (int k = 0; k < codeList[i].length; k++) {
                if (!codeList[i][k].equals("anything") && !shoppingCart[j + k].equals(codeList[i][k])) {
                    match = false;
                    break;
                }
            }
            if (match) {
                j += codeList[i].length;
                i++;
            } else {
                j++;
            }
        }
        return (i == codeList.length) ? 1 : 0;
    }

    public static void main(String[] args) {
        String[][] codeList = new String[][]{{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart = {"orange", "apple", "apple", "banana", "orange", "banana"};
        System.out.println("Expect 1, Get: " + freshPromotion(codeList, shoppingCart));
        shoppingCart = new String[]{"banana", "orange", "banana", "apple", "apple"};
        System.out.println("Expect 0, Get: " + freshPromotion(codeList, shoppingCart));
        shoppingCart = new String[]{"apple", "banana", "apple", "banana", "orange", "banana"};
        System.out.println("Expect 0, Get: " + freshPromotion(codeList, shoppingCart));
        codeList = new String[][]{{"apple", "apple"}, {"apple", "apple", "banana"}};
        shoppingCart = new String[]{"apple", "apple", "apple", "banana"};
        System.out.println("Expect 0, Get: " + freshPromotion(codeList, shoppingCart));
        codeList = new String[][]{{"anything"}};
        shoppingCart = new String[]{"apple", "apple", "apple", "banana"};
        System.out.println("Expect 1, Get: " + freshPromotion(codeList, shoppingCart));
    }
}
