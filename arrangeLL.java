import java.util.Scanner;
class MyNode{
    int data;
    MyNode next;
}

class linkedlist{
    MyNode head;

    MyNode createNode(int data){
        MyNode newnode = new MyNode();
        newnode.data = data;
        newnode.next = null;
        return newnode;
    }

    void insertAtEnd(int data){
        MyNode newnode = createNode(data);
        if(head==null){
            head = newnode;
        }
        else{
            MyNode ptr = head;
            while(ptr.next!=null){
                ptr = ptr.next;
            }
            ptr.next = newnode;
        }
    }

    void display(MyNode head){
        MyNode ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

}

public class arrangeLL {
    static void arrangeBy(int x,MyNode head){
        MyNode ptr = head;
        linkedlist list1 = new linkedlist();
        linkedlist list2 = new linkedlist();
        while(ptr!=null){
            if(ptr.data<x){
                list1.insertAtEnd(ptr.data);
            }
            else{
                list2.insertAtEnd(ptr.data);
            }
            ptr = ptr.next;
        }
        MyNode q = list1.head;
        while(q.next!=null){
            q = q.next;
        }
        q.next = list2.head;
        list1.display(list1.head);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        linkedlist list = new linkedlist();
        while(true){
            System.out.println("Enter data:");
            int data = sc.nextInt();
            list.insertAtEnd(data);
            System.out.print("Enter 1 to stop else anything: ");
            int flag = sc.nextInt();
            if(flag==1){
                break;
            }
        }
        System.out.println("Enter the x: ");
        int x = sc.nextInt();
        System.out.println();
        System.out.print("List: ");
        list.display(list.head);
        System.out.print("Arranged List: ");
        arrangeBy(x, list.head);
        sc.close();
    }
}
