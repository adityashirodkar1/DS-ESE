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
            System.out.println("Data: "+ptr.data);
            ptr = ptr.next;
        }
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
    
    void insertAtFront(int data){
        MyNode newnode = creatNode(data);
        if(head==null){
            head = newnode;
        }
        else{
            newnode.next = head;
            head = newnode;
        }
    }
    
    void insertAtRight(int data,int value){
        MyNode newnode = creatNode(data);
        MyNode ptr = head;
        int flag = 0;
        while(ptr.next!=null){
            if(ptr.data==value){
                flag = 0;
                break;
            }
            else
                flag = 1;
            ptr = ptr.next;
        }
        if(flag==0){
            newnode.next = ptr.next;
            ptr.next = newnode;
        }
        else
            System.out.println("No such data found");
    }

    void insertAtLeft(int data,int value){
        MyNode newnode = creatNode(data);
        MyNode ptr = head;
        int flag = 0;
        if(head.data==value){
            insertAtFront(data);
        }
        while(ptr.next.next!=null){
            if(ptr.next.data==value){
                flag = 0;
                break;
            }
            else
                flag = 1;
            ptr = ptr.next;
        }
        if(flag==0){
            newnode.next = ptr.next;
            ptr.next = newnode;
        }
        else
            System.out.println("No such data found");
    }
    
    void deleteFromFront(){
        if(head==null){
            System.out.println("List is empty!");
        }
        else{
            head = head.next;
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
    
    void deleteAtLeft(int value){
        int flag = 1;
        MyNode ptr = head;
        if(head==null){
            System.out.println("List is empty!");
        }
        else if(head.data==value){
            System.out.println("No one before "+value);
        }
        else if(head.next==null){
            System.out.println("List has only one node!");
        }
        else if(ptr.next.data==value){
            deleteFromFront();
        }
        else{
            flag = 1;
            while(ptr.next.next!=null){
                if(ptr.next.next.data==value){
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
}

public class linkedlist{
    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        int flag = 1,data,post;
        while(flag!=2){
            System.out.println("What operation?\n1 - Insert\n2 - Delete");
            int f = sc.nextInt();
            if(f==1){
                System.out.println("What insertion?\n1 - At Front\n2 - At End\n3 - Right of a value\n4 - Left of a value");
                int s1 = sc.nextInt();
                System.out.println("Enter the data you want to insert:");
                data = sc.nextInt();
                if(s1==1){
                    list.insertAtFront(data);
                    System.out.println("\n");
                    System.out.println("Linked List:-");
                    list.displayList();
                }
                else if(s1==2){
                    list.insertAtEnd(data);
                    System.out.println("\n");
                    System.out.println("Linked List:-");
                    list.displayList();
                }
                else if(s1==3){
                    System.out.println("Enter the value:");
                    post = sc.nextInt();
                    list.insertAtRight(data,post);
                    System.out.println("\n");
                    System.out.println("Linked List:-");
                    list.displayList();
                }
                else{
                    System.out.println("Enter the value:");
                    post = sc.nextInt();
                    list.insertAtLeft(data,post);
                    System.out.println("\n");
                    System.out.println("Linked List:-");
                    list.displayList();
                }
            }
            else{
                System.out.println("What deletion?\n1 - At Front\n2 - At End\n3 - Right of a value\n4 - Left of a value");
                int s2 = sc.nextInt();
                if(s2==1){
                    list.deleteFromFront();
                    System.out.println("\n");
                    System.out.println("Linked List:-");
                    list.displayList();
                }
                else if(s2==2){
                    list.deleteFromEnd();
                    System.out.println("\n");
                    System.out.println("Linked List:-");
                    list.displayList();
                }
                else if(s2==3){
                    System.out.println("Enter the value:");
                    post = sc.nextInt();
                    list.deleteAtRight(post);
                    System.out.println("\n");
                    System.out.println("Linked List:-");
                    list.displayList();
                }
                else{
                    System.out.println("Enter the value:");
                    post = sc.nextInt();
                    list.deleteAtLeft(post);
                    System.out.println("\n");
                    System.out.println("Linked List:-");
                    list.displayList();
                }
            }
            System.out.println("\n");
            System.out.println("Do you want to continue?\n1 - Yes\n2 - No");
            flag = sc.nextInt();
        } 
        sc.close();
    }
}
