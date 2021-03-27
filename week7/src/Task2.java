import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2. 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
 * 只有当它们可能是 在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返 回 false 。
 */
public class Task2 {
    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,3,5,1,2};
        int k = 0;
        Stack<Integer> stack = new Stack<>();
        for(int n : pushed){
            //进栈
            stack.push(n);
            //对栈顶元素进行判断是否需要出栈
            while(!stack.empty() && stack.peek() == popped[k]){
                stack.pop();
                k++;
            }
        }
        //如果最后栈为空，说明栈中元素（pushed的全部元素）已经按popped的序列全部输出
        if(stack.empty()){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
