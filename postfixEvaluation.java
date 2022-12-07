import java.util.Scanner;
class Stack{
    int top = -1;
    int n;
    int stack[];
    Stack(int n){
        this.n = n;
        stack = new int[n];
    }

    boolean isFull(){
        if(top==n-1)
            return true;
        return false;
    }

    boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }

    void push(int data){
        if(!isFull()){
            top++;
            stack[top] = data;
        }
        else{
            System.out.println("Full");
        }
    }

    int pop(){
        int popped = 0;
        if(!isEmpty()){
            popped = stack[top];
            top--;
        }
        return popped;
    }

    void displayStack(){
        for(int i=0;i<=top;i++){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
}
public class postfixEvaluation{

    static boolean isNumber(char c){
        if((int)c>=48 && (int)c<=57){
            return true;
        }
        return false;
    }

    static int toInt(char c){
        return (int)c - 48;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        String exp = sc.nextLine();
        Stack stack = new Stack(exp.length());
        for(int i=0;i<exp.length();i++){
            char current = exp.charAt(i);
            if(isNumber(current)){
                stack.push(toInt(current));
                System.out.print("Stack (top = "+stack.top+") : ");
                stack.displayStack();
            }
            else if(current=='+'){
                int second = stack.pop();
                int first = stack.pop();
                System.out.print("Stack (top = "+stack.top+") : ");
                stack.displayStack();
                int res = first + second;
                stack.push(res);
                System.out.print("Stack (top = "+stack.top+") : ");
                stack.displayStack();
            }
            else if(current=='-'){
                int second = stack.pop();
                int first = stack.pop();
                System.out.print("Stack (top = "+stack.top+") : ");
                stack.displayStack();
                int res = first - second;
                stack.push(res);
                System.out.print("Stack (top = "+stack.top+") : ");
                stack.displayStack();
            }
            else if(current=='*'){
                int second = stack.pop();
                int first = stack.pop();
                System.out.print("Stack (top = "+stack.top+") : ");
                stack.displayStack();
                int res = first * second;
                stack.push(res);
                System.out.print("Stack (top = "+stack.top+") : ");
                stack.displayStack();
            }
            else if(current=='/'){
                int second = stack.pop();
                int first = stack.pop();
                System.out.print("Stack (top = "+stack.top+") : ");
                stack.displayStack();
                int res = first / second;
                stack.push(res);
                System.out.print("Stack (top = "+stack.top+") : ");
                stack.displayStack();
            }
        }
        System.out.println(stack.pop());
        sc.close();
    }
}