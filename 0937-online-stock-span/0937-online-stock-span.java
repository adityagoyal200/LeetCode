class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        if(st.isEmpty()){
            st.push(new int[]{price,1});
            return count;
        } else {
            while(!st.isEmpty() && st.peek()[0] <= price){
                count += st.pop()[1];
            }
            st.push(new int[]{price,count});
        }

        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */