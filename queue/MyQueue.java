package queue;

class Node{
    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class MyQueue {
    public Node head;
    public Node tail;

    //取元素
    public void offer(int val) {
        Node node = new Node(val);
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = this.tail.getNext();
        }
    }

    //拿到队头
    public int peek() {
        if(this.head == null) return -1;
        return this.head.getVal();
    }

    //弹出
    public int pop() {
        if(this.head == null) return -1;
        Node ret = this.head;
        this.head = this.head.getNext();
        return ret.getVal();
    }

    //打印
    public void disPlay() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.getVal() + " ");
            cur = cur.getNext();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.disPlay();
        System.out.println();
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        myQueue.disPlay();

    }
}
