package notjava;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BalancedBrackets {

    static String isBalanced(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        List<Character> open = Arrays.asList('{', '[', '(');
        List<Character> close = Arrays.asList('}', ']', ')');
        for(char c : s.toCharArray()){
            if (open.contains(c)) stack.add(c);
            if (close.contains(c)) {
                char opposite = open.get(close.indexOf(c));
                if (stack.size() > 0 && stack.get(stack.size() - 1) == opposite)
                    stack.remove(stack.size() - 1);
                else return "NO";
            }
        }
        return stack.size() == 0 ? "YES" : "NO";
    }
}
