package test;

import tools.array.ArrayStack;

import java.util.Stack;

public class Test20 {

    public boolean judge(String str){
        char[] chars = str.toCharArray();
        ArrayStack<Character> stack = new ArrayStack<>();
//        stack.push(chars[0]);
        for (int i = 0; i < chars.length; i++) {
//            如果栈是空的话，直接压栈，并且跳过此次操作，（此时检视栈首会出现异常）
            if (stack.isEmpty()){
                stack.push(chars[i]);
                continue;
            }
            System.out.println(stack);
            if (chars[i]==getOpposite(stack.peek()))
                stack.pop();
            else
                stack.push(chars[i]);
        }
        return stack.isEmpty();
    }
    private char getOpposite(char c) {
        switch (c) {
            case '[':
                return ']';
//                break;
            case '{':
                return '}';
//                break;
            case '(':
                return ')';
//                break;
        }
        return ' ';
    }
//    此方法独立解决问题，不调用任何其他方法
    public boolean isValid(String str){
//        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
//            如果栈是空的话，直接压栈，并且跳过此次操作，（此时检视栈首会出现异常）
            if (stack.isEmpty()){
                stack.push(str.charAt(i));
                continue;
            }
//            System.out.println(stack);
            if (str.charAt(i)==getOpposite(stack.peek()))
                stack.pop();
            else
                stack.push(str.charAt(i));
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(new Test20().isValid("[]{}"));
    }
}
