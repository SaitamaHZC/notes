//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
// 输入中不存在两个连续的操作符 
// 每个数字和运行的计算将适合于一个有符号的 32位 整数 
// 
//
// Related Topics 栈 递归 数学 字符串 👍 854 👎 0


import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        int flag = 1,sum = 0 ;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '+' || temp == '-') {
                flag = (temp == '+') ? stack.peek() : -stack.peek();
            } else if (temp == '(') {
                stack.push(flag);
            } else if (temp == ')') {
                stack.pop();
            } else if (temp ==' ') {
                continue;
            } else {
               long number = 0;
               while( i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0' ){
                   number = 10*number + s.charAt(i) -'0';
                   i++;
               }
               sum += number*flag;
               i--;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
