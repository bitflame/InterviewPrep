import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Thanks to leetcode for the code
public class SuggestedProducts {
    int lower_bound(String[] products, int start, String word) {
        int i = start, j = products.length, mid;
        while (i < j) {
            mid = (i + j) / 2;
            if (products[mid].compareTo(word) >= 0)
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        StdOut.println("Suggested products binary search method ");
        List<List<String>> result = new ArrayList<>();
        int start = 0, bsStart = 0, n = products.length;
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            // Get the starting index of word starting with 'prefix'
            start = lower_bound(products, bsStart, prefix);
            // Add empty vector to result
            result.add(new ArrayList<>());
            // Add the words with the same prefix to the result.
            // Loop runs until `i` reaches the end of input or 3 times or till the
            // prefix is same for `products[i]` Whichever comes first.
            for (int i = start; i < Math.min(start + 3, n); i++) {
                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
                    break;
                result.get(result.size() - 1).add(products[i]);
            }
            // Reduce the size of elements to binary search on since we know
            bsStart = Math.abs(start);
        }
        return result;
    }


    public static void main(String[] args) {
        SuggestedProducts s = new SuggestedProducts();
        String[] products = {"mobile", "moneypot", "monitor", "mouse", "mousepad"};
        System.out.println("expect: [\"mobile\", \"moneypot\",\"monitor\"] get: " +
                s.suggestedProducts(products, "mouse"));
    }
}
