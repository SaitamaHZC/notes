import java.util.ArrayList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Map<String,String> map = new HashMap<String,String>();
        map.put(')','(');map.put('}','{');map.put(']', '[');
        ArrayList<char> stack = new ArrayList<char>();
        for(char t:s.toCharArray()){
            if(map.containsKey(t)){
                if()
            }
        }
    }
}
// @lc code=end

