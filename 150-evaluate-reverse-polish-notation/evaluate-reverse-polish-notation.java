class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals ("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if(token.equals ("-")){
                int operator2 = stack.pop();
                int operator1 = stack.pop();
                stack.push(operator1 - operator2);
            }
            else if(token.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
             else if(token.equals ("/")){
                int operator2 = stack.pop();
                int operator1 = stack.pop();
                stack.push(operator1/operator2);
            }else{
                stack.push(Integer.parseInt(token));
            }

        }
        return stack.peek();
    }
}