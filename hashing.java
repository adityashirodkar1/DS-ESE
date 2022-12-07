import java.util.Scanner;
class quadraticHash{
    int size;
    int hash[];

    quadraticHash(int size){
        this.size = size;
        hash = new int[size];
        for(int i=0;i<size;i++){
            hash[i] = 0;
        }
    }

    void insert(int data,int c1,int c2){
        int hk = data%size;
        int h1k = hk;
        int flag=0;
        for(int i=1;i<=size;i++){
            if(hash[hk]==0){
                hash[hk] = data;
                flag = 1;
                break;
            }
            else{
                hk = (h1k + c1*i + c2*i*i)%size;
                flag = 0;
            }
        }
        if(flag==0){
            System.out.println("Data cannot be inserted");
        }
    }

    void display(){
        System.out.println("index\tdata");
        for(int i=0;i<size;i++){
            System.out.println(i+"\t"+hash[i]);
        }
    }
}

public class hashing{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of structure:");
        int size = sc.nextInt();
        quadraticHash hash = new quadraticHash(size);
        System.out.println("Enter the C1:");
        int c1 = sc.nextInt();
        System.out.println("Enter the C2:");
        int c2 = sc.nextInt();
        for(int i=0;i<size;i++){
            System.out.println("Enter the data "+(i+1)+":");
            int data = sc.nextInt();
            hash.insert(data, c1, c2);
        }
        System.out.println("Do you want to see the table?\n1 - Yes\n2 - No");
        int what = sc.nextInt();
        if(what==1){
            System.out.println("Here 0 indicates empty space");
            hash.display();
        }
        sc.close();
    }
}