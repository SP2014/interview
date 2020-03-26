import java.util.Stack;

class ValidParenthesis {

    static boolean isValid(String str){
        if(str.length()%2==1) return false;

        Stack<Character> cstack = new Stack<>();
       for(int i=0; i<str.length();i++){
           char c = str.charAt(i);
           if(c=='{' || c == '(' || c == '['){
               cstack.add(c);
           }
           else if(c==')' && !cstack.isEmpty() && cstack.peek() == '('){
               cstack.pop();
           }
           else if(c=='}' && !cstack.isEmpty() && cstack.peek() == '{'){
               cstack.pop();
           }
           else if(c==']' && !cstack.isEmpty() && cstack.peek() == '['){
               cstack.pop();
           }
           else{
               return false;
           }
       }

       return cstack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[]"));
    }
}