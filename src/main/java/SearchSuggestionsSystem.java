import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        List<List<String>> t = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            for (String s : products) {
                if (searchWord.charAt(i) == s.charAt(i) && result.size() < 3)
                    result.add(s);
                else if (searchWord.charAt(i) != s.charAt(i) && result.contains(s)) {
                    result.remove(s);
                }
            }
            t =updateResults(results, result);
            result.clear();
        }
        return t;
    }

    public List<List<String>> updateResults(List<List<String>> rs, List<String> r) {
        List<String> temp = new ArrayList<>();
        for (String string : r) {
            temp.add(string);
        }
        rs.add(temp);
        return rs;
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem s = new SearchSuggestionsSystem();
        String[] products = {"mobile", "moneypot", "monitor", "mouse", "mousepad"};
        System.out.println("expect: [\"mobile\", \"moneypot\",\"monitor\"] get: " + s.suggestedProducts(products, "mouse"));
    }
}
