class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = (int)1e9 + 7;
        long sum = 0;
        int n = arr.length;

        int[] left = new int[n];
        int [] right = new int[n];

        Stack<Integer> stack = new Stack<>();
        //left
        for(int i =0; i < n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty()? i+1:i-stack.peek();
            stack.push(i);

        }
        stack.clear();
        //right
        for(int i =n-1; i >= 0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty()? n-i:stack.peek() -i;
            stack.push(i);

        }


        
        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i]* left[i] *right[i];
            
                sum = (sum + contribution) % MOD;
            }

        
        return (int) sum;
    }
}