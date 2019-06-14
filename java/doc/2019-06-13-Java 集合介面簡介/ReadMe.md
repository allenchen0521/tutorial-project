# 2019-06-13-Java 集合介面簡介

## 集合介面

1. Collection

    ```sh
    boolean add(E e)
    boolean remove(E e)
    int size()
    boolean contain(E e)
    void clear()
    ```

1. List

    ```sh
    E get(E e)
    void add(int index,E element)
    boolean set(int index, E element)
    E remove(int index)
    ```

1. Set

    ```sh
    boolean add(E e)
    boolean remove(E e)
    int size()
    boolean contain(E e)
    void clear()
    ```

1. Map

    ```sh
    V put(K key, V value)
    boolean containsKey(K key)
    Set<Entry<K, V>> entrySet()
    ```

1. Iteratable

    ```sh
    # Iterator() 為可走訪迴圈的原因, ArrayList/HashSet 皆實作此方法執行 foreach
    Iterator<E> Iterator()

    # Iterator 介面依靠 hasNext()/next() 來走訪迴圈
    boolean hasNext()
    E next()
    ```
