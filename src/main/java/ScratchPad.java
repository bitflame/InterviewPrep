import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*This is my own implementation of using binary seach to solve this problem. This is after I saw the leetcode solution
 * but mine is slightly different. Leetcode uses prefix += c to get the next prefix */
public class ScratchPad {
    // Custom class Trie with function to get 3 words starting with given prefix - Thanks to LeetCode for this code
    class Trie {

        class Node {
            boolean isWord = false;
            List<Node> children = Arrays.asList(new Node[26]);
        }

        ;
        Node Root, curr;
        List<String> resultBuffer;

        /* runs a dfs on the trie starting with given prefixx and adds all the words in the resultBuffer, limiting
         * result size to 3*/
        void dfsWithPrefix(Node curr, String word) {
            if (resultBuffer.size() == 3)
                return;
            if (curr.isWord)
                resultBuffer.add(word);
            // Run DFS on all possible paths
            for (char c = 'a'; c <= 'z'; c++)
                if (curr.children.get(c - 'a') != null)
                    dfsWithPrefix(curr.children.get(c - 'a'), word + c);
        }

        Trie() {
            Root = new Node();
        }

        // Inserts the string in trie
        void insert(String s) {
            // Points curr to the root of the trie
            curr = Root;
            for (char c : s.toCharArray()) {
                if (curr.children.get(c - 'a') == null)
                    curr.children.set(c - 'a', new Node());
                curr = curr.children.get(c - 'a');
            }
            // Mark this node asa completed word
            curr.isWord = true;
        }

        List<String> getWordsStartingWith(String prefix) {
            curr = Root;
            resultBuffer = new ArrayList<String>();
            // Move curr to the end of the prefix in its trie represenation
            for (char c : prefix.toCharArray()) {
                if (curr.children.get(c - 'a') == null)
                    return resultBuffer;
                curr = curr.children.get(c - 'a');
            }
            dfsWithPrefix(curr, prefix);
            return resultBuffer;
        }
    }

    private List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        int N = searchWord.length();
        String prefix;
        for (int i = 1; i < N; i++) {
            prefix = searchWord.substring(0, i);
            List<String> matches = new ArrayList<>();
            int j = 0, k = lower_bound(products, prefix);
            while (k < products.length && j < 3) {
                matches.add(products[k]);
                k++;
                j++;
            }
            result.add(matches);
        }
        return result;
    }

    protected int lower_bound(String[] prod, String pre) {
        int lo = 0, hi = prod.length, mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            /* I didn't have to use the substring to chop the word in prod anyway. */
            if (pre.compareTo(prod[mid].substring(0, pre.length())) <= 0) hi = mid - 1;
            if (pre.compareTo(prod[mid].substring(0, pre.length())) > 0) lo = mid + 1;

        }
        return lo;
    }

    protected List<List<String>> usingTrie(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        // Add all words to trie
        for (String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }

    public static void main(String[] args) {
        ScratchPad s = new ScratchPad();
        String[] products = {"mobile", "moneypot", "monitor", "mouse", "mousepad"};
        int listCounter = 0;
        for (List l : s.usingTrie(products, "mouse")) {
            StdOut.print("Here is list: " + listCounter);
            listCounter++;
            for (Object obj : l) {
                String string = (String) obj;
                StdOut.print(" "+string);
            }
            StdOut.println();
        }
    }
}
