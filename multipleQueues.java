import java.util.Scanner;
public class multipleQueues {

    static void enqueue(int [] arr,int [] rear,int k,int size,int data){
        int which = k-1;
        System.out.println(size);
        if(rear[which]==size){
            System.out.println("\nThe Queue "+k+" is full\n");
        }
        else{
            rear[which]++;
            arr[rear[which]] = data;
        }
    }

    static void dequeue(int [] arr,int [] front,int [] rear,int k){
        int which = k-1;
        if(front[which]>rear[which]){
            System.out.println("\nThe Queue "+k+" is Empty\n");
        }
        else{
            arr[front[which]] = 0;
            front[which]++;
        }
    }

    static void display(int [] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of queues you want:");
        int freq = sc.nextInt();
        int arraySize = 0;
        int index = 0;
        int[] front = new int[freq];
        int rear[] = new int[freq];
        int lastIndex[] = new int[freq];
        front[0] = 0;
        rear[0] = -1;
        for(int i=0;i<freq;i++){
            System.out.print("Enter size of Queue "+(i+1)+": ");
            int size = sc.nextInt();
            arraySize += size;
            index += size;
            lastIndex[i] = index-1;
            if(i!=(freq-1)){
                front[(i+1)] = index;
                rear[(i+1)] = index-1;
            }
        }

        int array[] = new int[arraySize];

        while(true){
            System.out.println("Which Queue?");
            int which = sc.nextInt();
            int flag = 4;
            while(flag!=3){
                System.out.println("What?\n1 - Enqueue\n2 - Dequeue\n3 - Stop");
                flag = sc.nextInt();
                switch(flag){
                    case 1:
                        System.out.print("Enter data: ");
                        int data = sc.nextInt();
                        enqueue(array, rear, which, lastIndex[(which-1)], data);
                        display(array);
                        break;
                    case 2:
                        dequeue(array, front, rear, which);
                        display(array);
                        break;
                    case 3:
                        break;
                }
           
            }
        System.out.println("Stop the whole operation?\n 1 - Yes\n Any Number - No");
        int stop = sc.nextInt();
        if(stop==1)
            break;
        }   
        sc.close();
    }
}
