package interviewq;

import java.util.Enumeration;


/**
 * Created by jay on 8/17/16.
 * Reference the hashtable class, customize the table myself
 * Target:
 * > Practice the Generic template
 */
public class MyTable<K, V> {

    private Entry<K, V>[] tables;
    private final int T_SIZE = 10;
    private int size;
    private int count;

    private static class Entry<K, V> {
        V value;
        final K key;
        Entry<K, V> next;


        protected Entry(K key, V value, Entry<K, V> next){
            this.value = value;
            this.key = key;
            this.next = next;
        }

        public K getKey(){ return this.key; }

        public V getValue(){ return this.value; }

    }

    private class Enumerator<T> implements Enumeration<T> {
        Entry<K, V>[] table = MyTable.this.tables;
        int size = table.length;
        int total = MyTable.this.count;
        //int index = MyTable.this.count;
        int index = 0;
        //int tmp = 0;

        Entry<K, V> entry = null;

        Enumerator() {};

        @Override
        public boolean hasMoreElements() {
            //System.out.println("index is " + index);
            Entry<K, V> e = entry;
            Entry[] t = table;
            int i = index;
            while ( e == null && i < total){
                e = table[i++];
            }
            entry = e;
            index = i;


            return entry != null;
        }

        @Override
        public T nextElement() {
            Entry<K, V> et = entry;
            int i = index;

            while( et == null && i < size) {
                et = table[i++];
            }

            entry = et;
            index = i;
            if ( et != null) {
                Entry<K, V> e = entry;
                entry = e.next;
                return (T)e.key;
            }

            return null;
        }
    }

    MyTable() {
        tables = new Entry[T_SIZE];
        this.size = tables.length;
        this.count = 0;
    }

    public int getEmptySize(){
        return this.size - this.count;

    }

    public void addEntry(K key, V value) {
        //Dangerous....
        System.out.println("Add idx " + count + ": (" + key + ", " + value + ")");
        Entry<K, V> e = tables[count];
        tables[count] = new Entry<K, V>(key, value, e);
        count++;
        return;
    }

    public <T> Enumerator<T> getEnumerator(){
        return new Enumerator<>();
    }


}
