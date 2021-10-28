public class FreshPromotion {
    // thanks to leetcode and neeraz99 for following code https://leetcode.com/discuss/interview-question/1002811/amazon-oa-2021-fresh-promotion
    private static int freshPromotion(String[][] codeList, String[] shoppingCart) {
        int cartIdx = 0, codeIdx = 0;
        while (cartIdx < shoppingCart.length && codeIdx < codeList.length) {
            String cur = shoppingCart[cartIdx];
            if ((codeList[codeIdx][0].equals("anything") || codeList[codeIdx][0].equals(cur)) &&
                    hasOrder(shoppingCart, cartIdx, codeList[codeIdx])) {
                cartIdx += codeList[codeIdx++].length;
            } else {
                cartIdx++;
            }
        }
        return codeIdx == codeList.length ? 1 : 0;
    }

    private static boolean hasOrder(String[] shoppingCart, int idx, String[] order) {
        for (String s : order) {
            if (idx < shoppingCart.length && (s.equals("anything") || shoppingCart[idx].equals(s))) {
                idx++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//anything - any item; only one fruit
// banana, orange, banana, apple, apple should fail b/c of order
// winner has to follow the order of code list as well as order of groups inside it
// also find out how to create this with list<list>
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
