package Core.slidingwindow;


class Node {
    Node next;
    int data;

    public Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class LinkedList {

    Node head;

    public void insertAtBeginning(int data) {
        Node temp=head;
        Node newNode = new Node(data);
        head = newNode;
        head.next= temp;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next!=null) {
            currNode=currNode.next;
        }
        currNode.next = newNode;
    }

    public void insertAtIndex(int pos, int data) {
        int count = 0;
        Node newNode = new Node(data);
        Node currNode = head;
        Node prevNode = head;
        if (pos==0) {
            head = newNode;
            head.next = currNode;
            return;
        }
        while(count<pos) {
            currNode = currNode.next;
            count+=1;
        }
        count=0;
        while(count<pos-1) {
            prevNode=prevNode.next;
            count+=1;
        }
        prevNode.next=newNode;
        newNode.next=currNode;
    }

    public void deleteFromFirst() {
        Node temp = head;
        temp = temp.next;
        head = temp;
    }

    public void deleteFromEnd() {
        Node temp = head;
        Node currentNode = null;
        while(temp.next!=null) {
            currentNode=temp;
            temp = temp.next;
        }
        currentNode.next = null;
    }

    public void deleteByIndex(int pos) {
        int count = 0;
        Node currNode = head;
        Node temp = null;
        if(pos==0) {
            head = head.next;
            return;
        }
        while(count<pos-1) {
            temp = currNode;
            currNode = currNode.next;
            count+=1;
        }
        temp.next = currNode.next;
    }

    public void display() {
        Node currNode = head;
        while(currNode!=null) {
            System.out.print(currNode.data + " ,");
            currNode = currNode.next;
        }
    }

    public void updateFirstElement(int data) {
        if(head==null) {
            return;
        }
        head.data = data;
    }

    public void updateLastElement(int data) {
        Node currNode = head;
        while (currNode.next!=null) {
            currNode=currNode.next;
        }
        currNode.data = data;
    }

    public void updateElementbyIndex(int index, int data) {
        Node currNode = head;
        int count = 1;
        while (count<=index-1) {
            currNode=currNode.next;
            count+=1;
        }

        currNode.data = data;
    }

    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.insertAtEnd(5);
        obj.insertAtEnd(10);
        obj.insertAtEnd(15);
        obj.insertAtEnd(1);
        obj.insertAtEnd(6);
        obj.insertAtIndex(2, 100);
        obj.insertAtIndex(4, 200);
        obj.insertAtIndex(0,300);
        obj.insertAtIndex(0, 600);
        obj.insertAtIndex(9, 1000);
        obj.display();
        System.out.println("After deleting ");
        obj.deleteFromFirst();
        obj.deleteFromFirst();
        obj.display();
        System.out.println("After deleteing from the end ");
        obj.deleteFromEnd();
        obj.deleteFromEnd();
        obj.display();
        System.out.println("Deleteing by index");
        obj.deleteByIndex(0);
        obj.display();

        System.out.println("Updating the element");
        obj.updateFirstElement(8000);
        obj.display();
        System.out.println("Updating the element");
        obj.updateLastElement(100000000);
        obj.display();
        System.out.println("Updating");
        obj.updateElementbyIndex(5, 3400000);
        obj.display();
    }
}
