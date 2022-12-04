import java.util.Scanner;
class Circular{
    int front=0,rear=0;
    boolean isEmpty(){
        if(rear==front){
            return true;
        }
        return false;
    }

    boolean isFull(int size){
        if((rear+1)%(size-1)==front){
            return true;
        }
        return  false;
    }

    void enqueue(int [] queue,int data,int size){
        if(isFull(size)){
            System.out.println("The Queue is Full!");
        }
        else{
            rear++;
            if(rear==size){
                rear=0;
            }
            queue[rear] = data;
        }
    }

    void dequeue(int [] queue,int size){
        if(isEmpty()){
            System.out.println("The Queue is Empty!");
        }
        else{
            front++;
            if(front==size){
                front=0;
            }
            queue[front] = 0;
        }
    }

    void displayQueue(int [] queue,int size){
        for(int i=0;i<size;i++){
            if(i==front)
                System.out.println(queue[i]+" -> front");
            else if(i==rear)
                System.out.println(queue[i]+" -> rear");
            else if(front==rear)
                System.out.println(queue[i]+" -> front and rear");
            else{
                System.out.println(queue[i]);
            }
        }
        System.out.println();
    }
}
public class circularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circular q = new Circular();
        System.out.println("Enter the number of elements:");
        int temp = sc.nextInt();
        int size = temp + 1;
        System.out.println("size="+size);
        int[] queue = new int[size];
        int flag = 6;
        while(flag!=3){
            System.out.println("What do you want to do?\n1 - Enqueue\n2 - Dequeue\n3 - Stop");
            flag = sc.nextInt();
            switch(flag){
                case 1:
                    System.out.print("Enter the data you want to insert: ");
                    int data = sc.nextInt();
                    q.enqueue(queue, data, size);
                    System.out.println("Queue: ");
                    q.displayQueue(queue,size);
                    System.out.println("front = "+q.front+" & rear = "+q.rear);
                    break;
                case 2:
                    q.dequeue(queue, size);
                    System.out.println("Queue: ");
                    q.displayQueue(queue,size);
                    System.out.println("front = "+q.front+" & rear = "+q.rear);
                    break;
                case 3:
                    break;
            } 
        }
        sc.close();
    }
}
