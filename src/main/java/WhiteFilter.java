import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;

public class WhiteFilter {
    public static void main(String[] args) {
        HashSet<String> set;
        set = new HashSet<>();
        /*I think the next few lines are a good example of how to read in an entire file using args[0] and still
         * be able to use the next arguments for other tasks.
         * Make sure you can do this type of activity using Java libraries vs. the Princeton jar file */
        In in = new In(args[0]);
        while (!in.isEmpty()) set.add(in.readString());
        while (!StdIn.isEmpty()) {
            String word =StdIn.readString();
            if (set.contains(word)) StdOut.println(word);
        }
    }
}
