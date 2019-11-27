package hashTable;

import java.util.Arrays;

public class MyHashTable {

  private int size;

  private MyEntry[] entries;

  public MyHashTable(int size) {
    this.size = size;
    this.entries = new MyEntry[size];
  }

  public MyHashTable() {
    this.size = 10;
    this.entries = new MyEntry[10];
  }



  public void put(Object key, Object value) {
    int hashValue = getHashCode(key) % size;
    MyEntry myEntry = new MyEntry(key, value);

    if (containsKey(key)) {
      replaceValue(key, value);
    } else if (this.entries[hashValue] != null) {
      addToLast(key, value);
    } else {
      this.entries[hashValue] = myEntry;
    }
  }

  public Object get(Object key) {
    int hashValue = getHashCode(key) % size;

    return this.entries[hashValue].value;
  }

  public boolean containsKey(Object key) {
    int hashValue = getHashCode(key) % size;
    MyEntry entry = this.entries[hashValue];
    while (entry != null) {
      if (entry.key == key) {
        return true;
      }
      entry = entry.next;
    }

    return false;
  }

  public Object replaceValue(Object key, Object value) {
    int hashValue = getHashCode(key) % size;

    MyEntry entry = this.entries[hashValue];
    while (entry != null) {
      if (this.entries[hashValue].key == key) {
        final MyEntry previousValue = this.entries[hashValue];
        this.entries[hashValue].value = value;
        entry = this.entries[hashValue].next;
        return previousValue;
      }
    }
    return null;
  }

  public void addToLast(Object key, Object value) {
    int hashValue = getHashCode(key) % size;
    MyEntry current = this.entries[hashValue];
    MyEntry next = this.entries[hashValue].next;
    while (next != null) {
      current = next;
      next = next.next;
    }

    current.next = new MyEntry(key, value);
  }

  public Object[] getKeys() {
    Object[] keyArray = new Object[size];
    int keyCounter = 0;
    for (int i = 0; i < size; i++) {
      if (this.entries[i] != null) {
        keyArray[keyCounter++] = this.entries[i].key;
        MyEntry next = this.entries[i].next;
        while (next != null) {
          keyArray[keyCounter++] = next.key;
          next = next.next;
        }
      }
    }
    return keyArray;
  }

  public int getHashCode(Object key) {
    //key.hashCode();
    return key.toString().length();
  }

  class MyEntry {

    private Object key;

    private Object value;

    private MyEntry next;

    MyEntry(Object key, Object value, MyEntry next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    MyEntry(Object key, Object value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }

  public static void main(String[] args) {
    MyHashTable myHashTable = new MyHashTable();
    myHashTable.put("Hi", "Hello");
    myHashTable.put("Ab", "Hey");
    myHashTable.put("Cd", "Hey");
    myHashTable.put("Cde", "Hey");
    myHashTable.put("Cdr", "Hey");

    System.out.println(Arrays.toString(myHashTable.getKeys()));
    System.out.println(myHashTable.get("Hi"));
  }
}
