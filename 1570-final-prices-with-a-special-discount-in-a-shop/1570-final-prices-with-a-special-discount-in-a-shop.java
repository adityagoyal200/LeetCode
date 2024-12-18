class Solution {
    public int[] finalPrices(int[] prices) {
        if(prices == null || prices.length == 0){
            return new int[]{};
        }

        int[] result = new int[prices.length];
        Stack<Integer> st = new Stack<>();

        for(int i = prices.length-1; i >= 0; i--){
            while(!st.isEmpty() && prices[st.peek()] > prices[i]){
                st.pop();
            }
            result[i] = (st.isEmpty()) ? prices[i] : prices[i] - prices[st.peek()];
            st.push(i);
        }

        return result;        
    }
}