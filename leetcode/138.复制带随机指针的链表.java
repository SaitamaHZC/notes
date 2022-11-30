import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        for(Node node = head ;node != null ;node = node.next.next){
            Node temp = new Node(node.val);
            temp.next = node.next;
            node.next = temp;
        }
        for(Node node = head ;node != null ;node = node.next.next){
            Node newNode = node.next;
            newNode.random = (node.random == null)? null : node.random.next;
        }
        Node newhead = head.next;
        for(Node node = head ;node != null ;node = node.next){
            Node newNode = node.next;
            node.next = node.next.next;
            newNode.next = (node.next == null)? null :  node.next.next;
        }
        return newhead;
  
    }
}




// @lc code=end

