import java.util.Scanner;
class Stack{
    int top = -1;

    boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }

    char peek(char [] stack){
        return stack[top];
    }

    char peek2(char [] stack){
        return stack[top-1];
    }

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
public class postfix {
    static String toString(char [] arr){
        String str = "";
        for(int i=0;i<arr.length;i++){
            str += arr[i];
        }
        return str;
    } 
    static boolean isHigher(char c1, char c2){
        if((c1=='*' || c2=='/') && (c2=='+' || c2=='-')){
            return true;
        }
        return false;
    }
    static boolean isOperator(char ch){
        if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        System.out.println("Enter the infix expression:");
        String exp = sc.nextLine();
        int size = exp.length();
        int operator=0,operand=0;
        char[] stack = new char[size];
        for(int i=0;i<size;i++){
            if(isOperator(exp.charAt(i))){
                operator++;
            }
            else if(exp.charAt(i)!='(' && exp.charAt(i)!=')'){
                operand++;
            }
        }
        if(operand != (operator+1)){
            System.out.println("Not a valid expression");
            System.exit(0);
        }
        int resSize = operand + operator;
        char[] postfix = new char[resSize];
        int res_ind = 0;
        for(int i=0;i<size;i++){
            if(exp.charAt(i)=='('){
                s.push(exp.charAt(i), stack, size);
                System.out.print("Stack: ");
                s.displayStack(stack);
                System.out.print("Postfix: ");
                System.out.println(toString(postfix));
                System.out.println();
            }
            else if(exp.charAt(i)==')'){
                while(s.peek(stack)!='('){
                    postfix[res_ind] = s.pop(stack);
                    res_ind++;
                    System.out.print("Stack: ");
                    s.displayStack(stack);
                    System.out.print("Postfix: ");
                    System.out.println(toString(postfix));
                    System.out.println();
                }
                s.pop(stack);
                System.out.print("Stack: ");
                s.displayStack(stack);
                System.out.print("Postfix: ");
                System.out.println(toString(postfix));
                System.out.println();
            }
            else if(isOperator(exp.charAt(i))){
                if(s.isEmpty()){
                    s.push(exp.charAt(i), stack, size);
                    System.out.print("Stack: ");
                    s.displayStack(stack);
                    System.out.print("Postfix: ");
                    System.out.println(toString(postfix));
                    System.out.println();
                }
                else if(isOperator(s.peek(stack))){
                    if(isHigher(exp.charAt(i), s.peek(stack))){
                        s.push(exp.charAt(i), stack, size);
                        System.out.print("Stack: ");
                        s.displayStack(stack);
                        System.out.print("Postfix: ");
                        System.out.println(toString(postfix));
                        System.out.println();
                    }
                    else{
                        postfix[res_ind] = s.pop(stack);
                        res_ind++;
                        s.push(exp.charAt(i), stack, size);
                        System.out.print("Stack: ");
                        s.displayStack(stack);
                        System.out.print("Postfix: ");
                        System.out.println(toString(postfix));
                        System.out.println();
                        while(s.top!=0 && s.peek2(stack)!='('){
                            if(!(isHigher(s.peek(stack), s.peek2(stack)))){
                                char temp = s.pop(stack);
                                postfix[res_ind] = s.pop(stack);
                                res_ind++;
                                s.push(temp, stack, resSize);
                                System.out.print("Stack: ");
                                s.displayStack(stack);
                                System.out.print("Postfix: ");
                                System.out.println(toString(postfix));
                                System.out.println();
                            }
                        }
                    }
                }
                else{
                    s.push(exp.charAt(i), stack, size);
                    System.out.print("Stack: ");
                    s.displayStack(stack);
                    System.out.print("Postfix: ");
                    System.out.println(toString(postfix));
                    System.out.println();
                }
            }
            else{
                postfix[res_ind] = exp.charAt(i);
                res_ind++;
                System.out.print("Postfix: ");
                System.out.println(toString(postfix));
                System.out.println();
            }
        }
        while(s.top!=-1){
            postfix[res_ind] = s.pop(stack);
            res_ind++;
            System.out.print("Stack: ");
            s.displayStack(stack);
            System.out.print("Postfix: ");
            System.out.println(toString(postfix));
            System.out.println();
        }
        sc.close();
    }
}

