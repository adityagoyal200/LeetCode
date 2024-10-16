class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums  == null || nums.length == 0){
            return new int[]{};
        }

        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        for(int i = nums.length-1; i >= 0 ; i--){
            st.push(nums[i]);
        }

        int i = nums.length-1;

        while(i >= 0){ //
            if(st.isEmpty()){
                nge[i] = -1;
            } else {
                if(st.peek() <= nums[i]){ 
                    while(!st.isEmpty() && st.peek() <= nums[i]){
                        st.pop();
                    }
                    nge[i] = (st.isEmpty()) ? -1: st.peek();
                } else {
                    nge[i] = st.peek();
                }
            }
            st.push(nums[i]); //2/3/4
            i--;
        }
        
        return nge;
    }
}