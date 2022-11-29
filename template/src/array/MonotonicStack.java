package array;

import java.util.Stack;

public class MonotonicStack {
    public int[] nextGreaterElement(int[] nums){
        int n=nums.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();
        //逆序入栈
        for(int i=n-1;i>=0;i--){
            while (!stack.isEmpty()&& stack.peek()<=nums[i]){
                stack.pop();
            }
            res[i]= stack.isEmpty()?-1: stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
