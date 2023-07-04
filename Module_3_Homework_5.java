import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Module_3_Homework_5 {
    static class HashSet<V> {
        static class Bucket<V> {

            private int size = 0;

            private ArrayList<V> values;

            public Bucket() {
                values = new ArrayList<>();
            }

            public void add(V values) {
                this.values.add(values);
                size++;
            }

            public void remove(V values) {
                this.values.remove(values);
                size--;
            }


        }

        private int CAPACITY = 10;

        private Bucket[] buckets;

        private int size = 0;

        public HashSet() {
            buckets = new Bucket[CAPACITY];
        }

        private int getHash(V value) {
            return (value.hashCode() & 0xfffffff) % CAPACITY;
        }

        public void put(V value) {
            int hash = getHash(value);
            if (buckets[hash] == null) {
                buckets[hash] = new Bucket();
            }
            buckets[hash].add(value);
            size++;
        }

        private boolean contains(V value) {
            int hash = getHash(value);
            for (int i = 0; i < buckets[hash].size; i++) {
                if (buckets[hash].values.get(i).equals(value)){
                    return true;
                }
            }
            return false;
        }

        public void remove(V value) {
            if (contains(value)) {
                int hash = getHash(value);
                buckets[hash].remove(value);
                size--;
            }
        }

        public void print() {
            for (int i = 0; i < CAPACITY; i++) {
                if (buckets[i] != null && buckets[i].size != 0) {
                    System.out.println("Bucket: " + i);
                    for (int j = 0; j < buckets[i].values.size(); j++) {
                        System.out.println(buckets[i].values.get(j));
                    }
                }
            }
            System.out.println("-----------------");
        }
    }

    public static void main(String[] args) {
        HashSet myHashSet = new HashSet<Integer>();
        myHashSet.put(10);
        myHashSet.put(100);
        myHashSet.put(150);
        myHashSet.put(42);
        myHashSet.put(228);
        myHashSet.put(17);
        myHashSet.put(1000);
        myHashSet.put(6789);
        myHashSet.put(541);
        myHashSet.put(18);
        myHashSet.print();
        myHashSet.remove(18);
        myHashSet.remove(17);
        myHashSet.remove(42);
        myHashSet.remove(123456789); // ничего не призойдёт, потому что нет такого ключа
        myHashSet.remove(1); // ничего не призойдёт, потому что нет такого ключа
        myHashSet.print();
    }
}
