import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {

        if (s == null) {
            return false;
        }
     
        if (s.length() < 1 || s.length() > 10000) {
            return false;
        }
        
        for (char c : s.toCharArray()) {
            if (c != '(' && c != ')' && c != '[' && c != ']' && c != '{' && c != '}') {
                return false;
            }
        }
        
        //стек для символов
        Stack<Character> stack = new Stack<>();
        
        //проходим по каждому символу строки
        for (char c : s.toCharArray()) {
            // если скобка открывающая - пихаем в стек(пушим)
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                //если стек пуст, а мы встретили закрывающую - сразу false
                if (stack.isEmpty()) {
                    return false;
                }
                
                //достаем верхнюю скобку из стека
                char top = stack.pop();
                
                //смотрим соответствие
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        
        //стек в конце пуст - все скобки закрылись правильно
        return stack.isEmpty();
    }
}