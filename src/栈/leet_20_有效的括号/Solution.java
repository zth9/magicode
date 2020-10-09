package 栈.leet_20_有效的括号;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: theTian
 * @date: 2020/10/9 20:39
 */
public class Solution {
    LinkedList<Character> list = new LinkedList();
    Map<Character, Character> pairs = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        for (char curChar : chars) {
            if (!pairs.containsKey(curChar)) list.add(curChar);
            else if (!list.isEmpty() && list.getLast().equals(pairs.get(curChar))) list.removeLast();
            else return false;
        }
        return list.isEmpty();
    }
}
