/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        ListNode Left = newhead,Right,succ,prev;
        for(int i=1;i<=left-1;i++){
            Left = Left.next;
        }
        prev = Left;
        Left = Left.next;
        Right = Left;
        for(int i=1;i<=right-left;i++){
            Right = Right.next;
        }
        succ = Right.next;
        Right.next = null;
        prev.next =  reverse(Left);
        Left.next = succ;
        return newhead.next;
    }

    public ListNode reverse_(ListNode head){
        if(head.next == null || head == null) return head;
        ListNode newhead =  reverse(head.next);
        newhead.next = head;
        head.next = null;
        return head;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null,curr = head;
         while(curr != null){
             ListNode next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }
        return prev;
    }
}
// @lc code=end

