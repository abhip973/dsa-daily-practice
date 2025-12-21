package dsadailypractice.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    Map<Character, String> map;

    public List<String> phoneCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(0, digits, sb, res);
        return res;
    }

    public void backtrack(int start, String digits, StringBuilder sb, List<String> res) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(start));
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(start + 1, digits, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
