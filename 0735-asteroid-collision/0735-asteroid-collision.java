class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0){
            return new int[]{};
        }

        Stack<Integer> st = new Stack<>();
        for(int ast: asteroids){
            if(st.isEmpty() ||ast > 0){
                st.push(ast);
            } else {
                if(ast > 0){
                    st.push(ast);
                } else {
                    while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(ast)){
                        st.pop();
                    }
                    if(st.isEmpty() || st.peek() < 0){
                        st.push(ast);
                    } else if(st.peek() == Math.abs(ast)){
                        st.pop();
                    }
                }
            }
        }

        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        
        return result;
    }
}