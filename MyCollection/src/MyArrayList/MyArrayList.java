package MyArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyArrayList<T>{


    private final int DEFEULTCAPACITY = 10;
    private T[] elements;
    private int size;
    private int capacity;


    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
    }

    public MyArrayList(Collection<? extends T> collection){
        this.elements = (T[]) new Object[collection.size()];
        for (T element: collection){
            add(element);
        }
    }

    public MyArrayList(){
        this.capacity = DEFEULTCAPACITY;
        this.elements = (T[]) new Object[DEFEULTCAPACITY];
    }

    public void add(T t){
        if(size == capacity){
            elements = increaseSizeArray();
        }
        elements[size++] = t;
        
    }

    private T[] increaseSizeArray(){
        return Arrays.copyOf(elements, size * 2);
    }



    public T get(int index){
        return elements[index];
    }

    public void remove(int index){
        for(int i = index; i < elements.length; i++){
            elements[i] = elements[i + 1];
        }
    }

    public void bubbleSort(Comparator<T> comparator){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if(comparator.compare(elements[i], elements[j]) < 0){
                     T t = elements[i];
                     elements[i] = elements[j];
                     elements[j] = t;
                }
            }
        }
    }

    public T[] getElements(){
        return elements;
    }


}
