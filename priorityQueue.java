import java.util.Scanner;

class priorityQueues {
    int arr[];
    int priority[];
    int size;
    int front;
    int rear;

    priorityQueues(int size) {
        this.size = size;
        arr = new int[size];
        priority = new int[size];
        front = 0;
        rear = -1;
    }

    boolean isFull() {
        if (rear == size - 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front > rear) {
            return true;
        }
        return false;
    }

    void enqueue(int value, int key) {
        if (!isFull()) {
            rear++;
            arr[rear] = value;
            priority[rear] = key;
            insertionSort();
            System.out.println(value + " has been enqueued.");
        } else {
            System.out.println("Queue is Full");
        }
    }

    void dequeue() {
        if (!isEmpty()) {
            front++;
            System.out.println("Front element has been dequeued.");
        } else {
            System.out.println("Queue is Empty");
        }
    }

    int queueFront() {
        return (!isEmpty() ? arr[front] : 0);
    }

    int queueRear() {
        return (!isEmpty() ? arr[rear] : -1);
    }

    void display() {
        if (!isEmpty()) {
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + "(" + priority[i] + ")" + " ");
            }
            System.out.println();
        } else {
            System.out.println("Queue is Empty.");
        }
    }

    void insertionSort() {
        int i = rear;
        int j = i - 1;
        while (i > front && priority[i] > priority[j]) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            temp = priority[i];
            priority[i] = priority[j];
            priority[j] = temp;
            i--;
            j--;
        }
    }
}

public class priorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size:");
        int size = sc.nextInt();
        priorityQueues priorityQueue = new priorityQueues(size);
        for(int i=0;i<size;i++){
            System.out.println("Enter data:");
            int data = sc.nextInt();
            System.out.println("Enter priority:");
            int priority = sc.nextInt();
            priorityQueue.enqueue(data, priority);
        }
        priorityQueue.display();
        priorityQueue.dequeue();
        priorityQueue.display();
        sc.close();
    }
}