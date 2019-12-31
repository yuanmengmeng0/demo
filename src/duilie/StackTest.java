package duilie;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/30
 * */

public class StackTest {
    public static void main(String[] args){
        MyStack<String> stack=new MyStack<>();
        for(String s : "the prefect code".split(" ")){
            stack.push(s);
        }
        while (!stack.empty()){
            System.out.println(stack.peek()+" ");
            stack.pop();
        }
        System.out.println();
        for(char s:"写了个一句话倒起来说的程序".toCharArray()){
            stack.push(String.valueOf(s));
        }
        while (!stack.empty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
