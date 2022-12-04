//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
//
// Related Topics 栈 递归 链表 双指针 👍 355 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //递归
//    ArrayList<Integer> values = new ArrayList<>();
//
//    public int[] reversePrint(ListNode head) {
//        reverse(head);
//        int ans[] = new int [values.size()];
//        for(int i=0;i<values.size();i++){
//            ans[i] = values.get(i);
//        }
//        return ans;
//    }
//
//    public void reverse(ListNode head){
//        if(head == null) return ;
//        reverse(head.next);
//        values.add(head.val);
//    }


    //栈
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while(head != null){
            stack.push(head.val);
            head =head.next;
        }
        int ans[] = new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
