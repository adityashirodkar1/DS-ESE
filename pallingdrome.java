import java.util.Scanner;
import java.lang.Math;
class Stack{
    int top = -1;

    void push(char data, char [] stack, int size){
        if(top==size-1){
            System.out.println("Stack is full");
        }
        else{
            top++;
            stack[top] = data;
        }
    }

    char pop(char [] stack){
        char popped='0';
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            popped = stack[top];
            top--;
        }
        return popped;
    }

    void displayStack(char [] stack){
        for(int i=0;i<=top;i++){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
}

class MyNode{
    char data;
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

    MyNode creatNode(char data){
        MyNode newnode = new MyNode();
        newnode.data = data;
        newnode.next = null;
        return newnode;
    }

    void insertAtEnd(char data){
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

    char getNode(int i){
        MyNode ptr = head;
        if(i==0)
            return ptr.data;
        else{
            for(int j=0;j<i;j++){
                ptr = ptr.next;
            }
        }
        return ptr.data;
    }

    void display(){
        MyNode ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}

public class pallingdrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("Enter the string of numbers/characters:");
        String str = sc.nextLine();
        int size = str.length();
        int j=0,flag=0;
        int sizeStack = (int)Math.floor(size/2);
        char[] stack = new char[sizeStack];
        for(int i=0;i<size;i++){
            list.insertAtEnd(str.charAt(i));
            if(j==sizeStack)
                continue;
            s.push(str.charAt(i), stack, sizeStack);
            j++;
        }
        list.display();
        int toStart = sizeStack;
        if(size%2==1)
            toStart++;
        for(int i=toStart;i<size;i++){
            char check = s.pop(stack);
            if(list.getNode(i) != check){
                System.out.println(list.getNode(i)+"!="+check);
                flag = 0;
                break;
            }
            else{
                System.out.println(list.getNode(i)+"=="+check);
                flag = 1;
            }
        }
        if(flag==0){
            System.out.println("Therefore, not a pallingdrome");
        }
        else{
            System.out.println("Therefore, pallingdrome");
        }
        sc.close();
    }
}
