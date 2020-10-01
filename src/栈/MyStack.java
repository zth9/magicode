package 栈;

/**
 * @author: theTian
 * @date: 2020/9/29 13:36
 */
public class MyStack<T> {
    private Object[] elements;
    private int size;

    public MyStack(int initialCapacity){
        elements = new Object[initialCapacity];
    }


    public T pop(){
        if (size==0) return null;
        return (T) elements[--size];
    }

    public void push(Object object){
        if (size==elements.length) throw new RuntimeException("栈满了!");
        elements[size++] = object;
    }
}
