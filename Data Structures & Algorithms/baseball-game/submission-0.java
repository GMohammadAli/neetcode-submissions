class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (String operation : operations) {
            if (operation.equals("C")) {
                result -= stack.pop();
            } else if (operation.equals("D")) {
                int prev = stack.peek();
                stack.push(prev * 2);
                result += stack.peek();
            } else if (operation.equals("+")) {
                int prev1 = stack.pop();
                int prev2 = stack.isEmpty() ? 0 : stack.peek();
                stack.push(prev1);
                stack.push(prev1 + prev2);
                result += stack.peek();
            } else {
                stack.push(Integer.parseInt(operation));
                result += stack.peek();
            }
        }

        return result;
    }
}