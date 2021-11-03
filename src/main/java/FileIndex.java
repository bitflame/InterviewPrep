import edu.princeton.cs.algs4.*;

import java.io.File;

public class FileIndex {
    public static void main(String[] args) {
        ST<String, SET<File>> St = new ST<String, SET<File>>();
        for (String filename : args) {
            File file = new File(filename);
            In in = new In(file);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (!St.contains(word)) St.put(word, new SET<File>());
                SET<File> set = St.get(word);
                set.add(file);
            }
        }
        System.out.println("");
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (St.contains(query))
                for (File file : St.get(query))
                    StdOut.println(" " + file.getName());
        }
    }
}
