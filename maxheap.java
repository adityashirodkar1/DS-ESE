import java.util.Scanner;
import java.lang.Math;
public class maxheap {
    static void insert(int [] heap,int data,int k){
        int i=k;
        heap[i] = data;
        while(i>1){
            int parent = (int)Math.floor(i/2);
            if(heap[parent]<heap[i]){
                int temp = heap[parent];
                heap[parent] = heap[i];
                heap[i] = temp;
            }
            i = parent;
        }
    }

    static void heapify(int [] heap,int n,int i){
        int parent = i;
        int left = 2*i;
        int right = left + 1;
        
        if(left<=n && heap[parent]<heap[left]){
            parent = left;
        }
        if(right<=n && heap[parent]<heap[right]){
            parent = right;
        }

        if(parent!=i){
            int temp = heap[parent];
            heap[parent] = heap[i];
            heap[i] = temp;
            heapify(heap, n, parent);
        }
    }                                                        

    static void heapSort(int [] heap,int n){
        int size = n;
        while(size>1){
            int temp = heap[size];
            heap[size] = heap[1];
            heap[1] = temp;
            size--;
            heapify(heap, size, 1);
        }
        display(heap);
    }

    static void display(int [] heap){
        for(int i=1;i<heap.length;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of data:");
        int t = sc.nextInt();
        int size = t+1;
        int heap[] = new int[size];
        heap[0] = -1;
        for(int i=1;i<heap.length;i++){
            System.out.println("Enter the data:");
            int data = sc.nextInt();
            insert(heap, data, i);
        }
        System.out.print("Heap: ");
        display(heap);
        System.out.print("Sorted Heap: ");
        heapSort(heap, t);
        sc.close();
    }
}
