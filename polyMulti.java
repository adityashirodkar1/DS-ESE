import java.util.Scanner;
class MyNode{
    int coef;
    int expo;
    MyNode next;
}
class SinglyLinkedList{
    MyNode head;
    void displayList(){
        MyNode ptr = head;
        while(ptr!=null){
            System.out.println("coef = "+ptr.coef+" and expo = "+ptr.expo);
            ptr = ptr.next;
        }
        System.out.println();
    }

    MyNode creatNode(int coef,int expo){
        MyNode newnode = new MyNode();
        newnode.coef = coef;
        newnode.expo = expo;
        newnode.next = null;
        return newnode;
    }

    boolean isPresent(int expo){
        MyNode ptr = head;
        int flag=0;
        while(ptr!=null){
            if(ptr.expo==expo){
                flag=1;
                break;
            }
            ptr = ptr.next;
            flag=0;
        }
        if(flag==1)
            return true;
        else
            return false;
    }

    void insertAtEnd(int coef,int expo){
        MyNode newnode = creatNode(coef,expo);
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
}
public class polyMulti {
    static void toExpression(MyNode head){
        while(head!=null){
            if(head.next==null){    
                System.out.print(head.coef+"x"+head.expo);   
            }
            else{
                System.out.print(head.coef+"x"+head.expo+" + ");
            }
            head = head.next;
        }
        System.out.println();
    }

    static SinglyLinkedList multiply(MyNode fpoly, MyNode spoly){
        SinglyLinkedList result = new SinglyLinkedList();
        MyNode f = fpoly;
        while(f!=null){
            MyNode s = spoly;
            while(s!=null){
                int coef = f.coef*s.coef;
                int expo = f.expo+s.expo;
                result.insertAtEnd(coef, expo);
                s = s.next;
            }
            f = f.next;
        }
        return result;   
    }

    static SinglyLinkedList finalResult(MyNode r){
        SinglyLinkedList fin = new SinglyLinkedList();
        int coef=0;
        while(r!=null){
            int flag=0;
            MyNode t = r.next;
            if(!(fin.isPresent(r.expo))){
                while(t!=null){
                    if(r.expo==t.expo){
                        coef = r.coef + t.coef;                      
                        flag = 1;
                        break;
                    }
                    flag=0;
                    t = t.next;
                }
                if(flag==1){
                    fin.insertAtEnd(coef, r.expo);
                }
                else{
                    fin.insertAtEnd(r.coef, r.expo);
                }
            }
            r = r.next;
        }
        return fin;
    }

    static boolean isNumber(char ch){
        if((int)ch>=48 && (int)ch<=57){
            return true;
        }
        return false;
    }
    static int toInt(char ch){
        return ((int)ch - 48);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        System.out.println("------------For expression 1-------------");
        int flag=0;
        while(true){
            System.out.print("Enter the coeficient: ");
            int coef = sc.nextInt();
            System.out.print("Enter the exponent: ");
            int expo = sc.nextInt();
            list1.insertAtEnd(coef, expo);
            System.out.print("Stop? 1 - Yes: ");
            flag = sc.nextInt();
            if(flag==1){
                break;
            }
        }
        System.out.println();
        System.out.println("------------For expression 2-------------");
        flag=0;
        while(true){
            System.out.print("Enter the coeficient: ");
            int coef = sc.nextInt();
            System.out.print("Enter the exponent: ");
            int expo = sc.nextInt();
            list2.insertAtEnd(coef, expo);
            System.out.print("Stop? 1 - Yes: ");
            flag = sc.nextInt();
            if(flag==1){
                break;
            }
        }
        System.out.println();
        System.out.print("First Expression: ");
        toExpression(list1.head);
        System.out.print("Second Expression: ");
        toExpression(list2.head);
        MyNode p = multiply(list1.head,list2.head).head;
        MyNode q = finalResult(p).head;
        System.out.print("Result: ");
        toExpression(q);   
        sc.close();
    }
}
