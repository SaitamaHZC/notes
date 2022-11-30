//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3626 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        if(map.containsKey(s.charAt(0)) || s.length()<=0 ) return false;
        Deque<Character> stack = new LinkedList<Character>();
        for(char t: s.toCharArray()){
            if(map.containsKey(t)){
                 if(stack.isEmpty() || stack.peek() != map.get(t)) return false;
                 else stack.pop();
            }
            else stack.push(t);
        }
        return stack.isEmpty();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
