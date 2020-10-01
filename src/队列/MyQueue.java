package 队列;

/**
 * @author: theTian
 * @date: 2020/9/29 17:47
 */
public class MyQueue<T> {
    private Object[] elements;
    private int size;
    private int length;
    private int head;
    private int tail;

    public MyQueue(int initialCapacity){
        elements = new Object[++initialCapacity];
        length = initialCapacity;
    }

    public T dequeue(){
        if (head == tail){
            return null;
        }
        size--;
        T res = (T) elements[head];
        head = (head+1)%length;
        return res;
    }

    public void enqueue(T t){
        if ((tail+1)%length == head){
            return;
        }
        size++;
        elements[tail] = t;
        tail = (tail+1)%length;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.enqueue(1);
        System.out.println(queue.dequeue());

        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());

        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

}
