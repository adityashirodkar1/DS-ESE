import java.util.Scanner;
class MyNode{
    int data;
    MyNode next;
    MyNode previous;
}

class DLinkedList{
    MyNode head;

    MyNode createNode(int data){
        MyNode newnode = new MyNode();
        newnode.next = null;
        newnode.data = data;
        newnode.previous = null;
        return newnode;
    }

    void insertAtFront(int data){
        MyNode newnode = createNode(data);
        if(head==null){
            head = newnode;
        }
        else{
            head.previous = newnode;
            newnode.next = head;
            head = newnode;
        }
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
            newnode.previous = ptr;
        }
    }

    void insertAtPost(int data,int post){
        if(post==1){
            insertAtFront(data);
        }
        else if(post==2){
            MyNode newnode = createNode(data);
            newnode.next = head.next;
            head.next.previous = newnode;
            head.next = newnode;
            newnode.previous = head;
        }
        else{
            MyNode newnode = createNode(data);
            MyNode ptr = head;
            for(int i=1;i<(post-1);i++){
                ptr = ptr.next;
            }
            newnode.next = ptr.next;
            ptr.next.previous = newnode;
            ptr.next = newnode;
            newnode.previous = ptr;
        }       
    }

    MyNode sortedInsert(MyNode head,MyNode newnode){
        if(head==null){
            head = newnode;
        }
        else if(head.data>=newnode.data){
            newnode.next = head;
            head.previous= newnode;
            head = newnode;
        }
        else{
            MyNode ptr = head;
            while(ptr.next!=null && ptr.next.data<newnode.data){
                ptr = ptr.next;
            }
            newnode.next = ptr.next;
            newnode.previous = ptr;          
            if(ptr.next!=null){
                ptr.next.previous = newnode;
            }
            ptr.next = newnode;
        }
        return head;
    }

    MyNode insertionSort(MyNode head){
        MyNode sorted = null;
        while(head!=null){
            MyNode next = head.next;
            head.next = head.previous = null;
            sorted = sortedInsert(sorted, head);
            head = next;
        }
        return sorted;
    }

    void displayDList(MyNode h){
        MyNode ptr = h;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}

public class doublylinkedlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLinkedList list = new DLinkedList();
        int flag=6;
        while(flag!=5){
            System.out.println("What do you want to do?\n1 - Insert At End\n2 - Insert At Front\n3 - Insert At Position\n4 - Sort\n5 - Stop");
            flag = sc.nextInt();
            switch(flag){
                case 1:
                    System.out.println("Enter the data:");
                    int data = sc.nextInt();
                    list.insertAtEnd(data);
                    System.out.print("List: ");
                    list.displayDList(list.head);
                    break;
                case 2:
                    System.out.println("Enter the data:");
                    data = sc.nextInt();
                    list.insertAtFront(data);
                    System.out.print("List: ");
                    list.displayDList(list.head);
                    break;
                case 3:
                    System.out.println("Enter the data:");
                    data = sc.nextInt();
                    System.out.println("Enter the position:");
                    int post = sc.nextInt();
                    list.insertAtPost(data, post);
                    System.out.print("List: ");
                    list.displayDList(list.head);
                    break;
                case 4:
                    System.out.print("Original List: ");
                    list.displayDList(list.head);
                    MyNode sorted = list.insertionSort(list.head);
                    System.out.print("Sorted List: ");
                    list.displayDList(sorted);
                    break;
                case 5:
                    break;
            }
        }
        sc.close();
    }
}
