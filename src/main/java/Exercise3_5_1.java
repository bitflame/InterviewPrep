import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;

public class Exercise3_5_1 {
    class Set<Key extends Comparable<Key>> {
        private RedBlackBST<Key, Boolean> set;

        public Set() {
            set = new RedBlackBST<>();
        }

        public boolean isEmpty() {
            return set.isEmpty();
        }

        public int size() {
            return set.size();
        }

        public boolean contains(Key key) {
            return set.contains(key);
        }

        public void add(Key key) {
            if (key == null) throw new IllegalArgumentException();
            set.put(key, false);
        }

        public void delete(Key key) {
            if (key == null) throw new IllegalArgumentException("Key cannot be null");
            if (set.isEmpty() || !contains(key)) return;
            set.delete(key);
        }

        public Key min() {
            if (isEmpty()) return null;
            return set.min();
        }

        public Key max() {
            if (isEmpty()) return null;
            return set.max();
        }

        public Key floor(Key key) {
            return set.floor(key);
        }

        public Key ceiling(Key key) {
            return set.ceiling(key);
        }

        public Key select(int index) {
            if (index >= size()) throw new IllegalArgumentException("Index is higher than set size");
            return set.select(index);
        }

        public int rank(Key key) {
            return set.rank(key);
        }

        public void deleteMin() {
            set.deleteMin();
        }

        public void deleteMax() {
            set.deleteMax();
        }

        public Iterable<Key> keys() {
            return set.keys();
        }

        public Iterable<Key> keys(Key low, Key high) {
            return set.keys(low, high);
        }

        public int size(Key low, Key high) {
            return set.size(low, high);
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "{ }";
            }
            StringBuilder sb = new StringBuilder("{");
            boolean isFirstKey = true;
            for (Key key : keys()) {
                if (isFirstKey) {
                    isFirstKey = false;
                } else {
                    sb.append(",");
                }
                sb.append(" ").append(key);
            }
            sb.append(" }");
            return sb.toString();
        }
    }
}