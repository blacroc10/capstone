//sort a stack in ascending order by using another temporary stack
// we can only use one variable, no arrays, no list
// 34 3 31 98 92 23

import java.util.*;

public class SIT_201 {
    public static void main(String[] args) {
        
        Stack<Integer> stack=new Stack();
        
        //console input: 34 3 31 98 92 23
        //console output: 98 92 34 31 23 3
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);


        System.out.println("Input: "+stack);
        sort(stack);
        System.out.println("Output: "+stack);
    
        
    }
    static void sort(Stack<Integer> stack){
        Stack<Integer> tempStack= new Stack();
        //loop runs until the original stack becomes empty
        while(!stack.isEmpty()){
            //pop the top element from the original stack and store it in a temp variable
            int temp = stack.pop();
            /*while the temp stack is not empty and the top element of the temp stack is greater than the temp variable, 
            pop the top element from the temp stack and push it back to the original stack*/
            while(!tempStack.isEmpty() && tempStack.peek() > temp){
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        //the sorted elements are in the temp stack, we need to move them back to the original stack
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }

    }
    
}
