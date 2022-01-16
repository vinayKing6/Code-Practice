package myToolKit;

import com.king.corejava.Student;

public class hashTable<K,V> {
    private container<V>[] container=new container[200];
    private hashFunc<K> func;

    public hashTable(hashFunc<K> func){
        this.func=func;
    }

    public int hash(K key){
        return func.function(key);
    }

    public void put(K key,V value){
        int index=hash(key);
        container[index]=new container<>(value);
    }

    public V get(K key){
        return container[hash(key)].getValue();
    }

    public static void main(String[] args) {
        hashTable<Integer, Student> map=new hashTable<>(Integer::intValue);

        map.put(1,new Student("vinay","math",1001));
        System.out.println(map.get(1));
    }

}
