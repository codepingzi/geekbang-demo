package com.geekbang.leetcode.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yangweiping
 * @date 2022/2/23 上午11:43
 */
public class _020_Solution_IsValid {

    public static void main(String[] args) {
        String abc = "]]";
        System.out.println(new _020_Solution_IsValid().solution_01(abc));
    }


    private boolean solution_01(String str){
        int n = str.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> hashMap = new HashMap();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');

        Stack<Character> stack = new Stack();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!hashMap.containsKey(chars[i])){
                stack.push(chars[i]);
            }else{
                Character character = !stack.empty() ? stack.pop() : 0;
                if (hashMap.get(chars[i]) != character){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
