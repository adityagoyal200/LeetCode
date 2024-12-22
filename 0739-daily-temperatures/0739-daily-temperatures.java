class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0){
            return new int[]{};
        }

        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            result[i] = (st.isEmpty()) ? 0 : st.peek() - i;
            st.push(i);
        }

        return result;
    }
}