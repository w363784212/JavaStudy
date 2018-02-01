/**
 * Reverse Single Direction NodeList by
 * --遍历法反转单链表
 */


public class Main {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        head = Reverse2(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

    private static Node Reverse2(Node head){
        Node current=head.getNext();
        Node previous=head;
        Node next;
        while(current!=null){
            next=current.getNext();
            current.setNext(previous);
            previous=current;
            current=next;
        }
        head.setNext(null);
        return previous;
    }
}


class Node {
    private int Data;// 数据域
    private Node Next;// 指针域
    public Node(int Data) {
        // super();
        this.Data = Data;
    }
    public int getData() {
        return Data;
    }
    public void setData(int Data) {
        this.Data = Data;
    }

    public Node getNext() {
        return Next;
    }
    public void setNext(Node Next) {
        this.Next = Next;
    }
}
