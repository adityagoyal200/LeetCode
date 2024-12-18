class Solution {
    public int[] finalPrices(int[] prices) {
        if(prices == null || prices.length == 0){
            return new int[]{};
        }

        int[] result = new int[prices.length];
        result = findNse(prices);

        for(int i = 0; i < result.length; i++){
            result[i] = (result[i] == -1) ? prices[i] : prices[i] - prices[result[i]];
        }

        return result;        
    }
    private int[] findNse(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = arr.length-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            result[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }
}