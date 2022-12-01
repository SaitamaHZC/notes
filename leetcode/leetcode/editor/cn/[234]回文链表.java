//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1573 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//快慢指针，快指针走两步，慢指针走一步，快指针走到尾时，慢指针就位于一半位置，很适用于回文问题（对称、求一半）
class Solution {
    public boolean isPalindrome1(ListNode head) {
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //此时若为偶数链表fast指向末尾null,slow指向下半链表的头结点
        //奇数链表，则slow再指向下一个节点才为中点
        if(fast != null){
            slow = slow.next;
        }

        ListNode halfHead = reverse(slow);
        //如果是奇数链表，则上半比下半长，因此下半不为null即可
        while(halfHead != null ){
            if(head.val != halfHead.val){
                return false;
            }else{
                head = head.next;
                halfHead = halfHead.next;
            }
        }
        return true;
    }

    //辅助栈，全部结点放到链表里，再一一比对
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode node = head;
        while(node != null){
            stack.push(node.val);
            node = node.next;
        }
        while(!stack.isEmpty()){
            if(stack.pop()!= head.val) return false;
            else {
                head = head.next;
            }
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr !=null){
            ListNode succ = curr.next;
            curr.next = prev;
            prev = curr;
            curr = succ;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
