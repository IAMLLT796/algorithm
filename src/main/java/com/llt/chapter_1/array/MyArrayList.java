package com.llt.chapter_1.array;

import java.util.Arrays;

/**
 * @Author LLT
 * @Date 2024-06-18-08:47
 **/
public class MyArrayList<E> {
    // The underlying array that actually stores the data
    private E[] data;
    // Records the current number of elements
    private int size;
    // Default initial capacity
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }


    public MyArrayList(int capacity) {
        data = (E[]) new Object[INIT_CAP];
    }

    // insert
    public void addLast(E e) {
        int cap = data.length;

        if(cap == size) {
            resize(2 * cap);
        }

        data[size] = e;
        size++;
    }

    public void add(int index, E e) {
        // check whether index is out of bounds
        checkPositionIndex(index);

        int cap = data.length;

        if(size == cap) {
            resize(2 * cap);
        }

        for(int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // insert new element
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    // remove
    public E removeLast() throws NoSuchFieldException {
        if(size == 0) {
            throw new NoSuchFieldException();
        }

        int cap = data.length;

        if(size == cap / 4) {
            resize(cap / 2);
        }

        E deleteVal = data[size - 1];
        data[size - 1] = null;
        size--;

        return deleteVal;
    }

    public E remove(int index) {
        checkElementIndex(index);

        int cap = data.length;
        if(size == cap / 4) {
            resize(cap / 2);
        }

        E deleteVal = data[index];
        for(int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        data[size - 1] = null;
        size--;

        return deleteVal;
    }

    public E removeFirst() {
        return remove(0);
    }

    // search
    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }

    // change
    public E set(int index, E e) {
        checkElementIndex(index);
        E oldVal = data[index];

        data[index] = e;

        return oldVal;
    }

    // other tool methods
    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    // Change the size of data to newCap
    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];

        for(int i = 0; i < size; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    // Check if the line has been crossed
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    // check whether the index location can contain elements
    private void checkElementIndex(int index) {
        if(!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }


    private void checkPositionIndex(int index) {
        if(!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size" + size);
        }
    }

    private void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) throws NoSuchFieldException {
        MyArrayList<Integer> arr = new MyArrayList<Integer>(3);

        for (int i = 0; i < 5; i++) {
            arr.addLast(i);
        }
        arr.remove(3);

        arr.add(1, 9);

        arr.addFirst(100);

        int val = arr.removeLast();

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
