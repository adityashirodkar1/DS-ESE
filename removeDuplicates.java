import java.util.Scanner;
class MyNode{
    int data;
    MyNode next;
}
class SinglyLinkedList{
    MyNode head;
    void displayList(){
        MyNode ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    MyNode creatNode(int data){
        MyNode newnode = new MyNode();
        newnode.data = data;
        newnode.next = null;
        return newnode;
    }

    void insertAtEnd(int data){
        MyNode newnode = creatNode(data);
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
    
    void deleteFromEnd(){
        if(head==null){
            System.out.println("List is empty!");
        }
        else if(head.next==null){
            head = head.next;
        }
        else{
            MyNode ptr = head;
            while(ptr.next.next!=null){
                ptr = ptr.next;
            }
            ptr.next = null;
        }
    }
    
    void deleteAtRight(int value){
        int flag = 1;
        MyNode ptr = head;
        if(head==null){
            System.out.println("List is empty!");
        }
        else{
            while(ptr.next!=null){
                if(ptr.data==value){
                    flag = 0;
                    break;
                }
                else
                    flag = 1;
                ptr = ptr.next;
            }
        }
        if(flag==0){
            ptr.next = ptr.next.next;
        }
        else{
            System.out.println("There is no such data");
        }
    }

    void deleteDuplicates(){
        MyNode ptr = head;
        while(ptr.next!=null){
            MyNode qtr = ptr;
            while(ptr.data==qtr.data){
                qtr = qtr.next;
                //if we are at last node
                if(qtr.next==null){
                    break;
                }
            }
            //if the last data has a duplicate - start
            if(qtr.data==ptr.data){
                ptr.next = null;
                break;
            }
            //end
            ptr.next = qtr;
            ptr = ptr.next;
        }
    }
}
public class removeDuplicates{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int flag=0;
        //insertion start
        while(true){
            int i=1;
            System.out.print("Enter data "+i+":");
            int data = sc.nextInt();
            list.insertAtEnd(data);
            i++;
            System.out.println("Stop? 1 - Yes");
            flag = sc.nextInt();
            if(flag==1)
                break;
        }
        System.out.println("Original List: ");
        list.displayList();
        //end

        //code start
        list.deleteDuplicates();
        System.out.println("Updated List: ");
        list.displayList();
        sc.close();
    }
}