package queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-01-24
 * Time: 10:47
 */
class MyCircularQueue {

    private int front;
    private int rear;//代表当前可以存放数据元素的下标
    private int[] elem;

    public MyCircularQueue(int k) {
        this.elem = new int[k];
        this.front = 0;
        this.rear = 0;
    }

    //入队
    public boolean enQueue(int value) {
        if(isFull()) return false;
        //放到数组的rear下标  rear往后走

        this.elem[this.rear] = value;
        this.rear = (this.rear + 1) % this.elem.length;
        return true;

    }

    //判断是否为满
    public boolean isFull() {
        return (this.rear + 1) % elem.length == this.front;
    }

    //出队
    public boolean deQueue() {
        if(isEmpty()) return false;
        //只需要挪动front这个下标就好了
        this.front = (this.front + 1) % this.elem.length;
        return true;

    }

    //判断是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //拿到队头元素
    public int Front() {
        if(isEmpty()) return -1;
        int ret = this.elem[this.front];
        return ret;
    }

    //拿到队尾元素
    public int Rear() {
        if(isEmpty()) return -1;
        return this.elem[(this.rear - 1) % this.elem.length];
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(5);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());

    }



}

