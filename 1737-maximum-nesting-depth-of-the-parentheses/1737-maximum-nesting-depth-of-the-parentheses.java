class Solution {
    public int maxDepth(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int len = Integer.MIN_VALUE;
        int currLen = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                currLen++;
                len = Math.max(currLen,len);
            } else if(s.charAt(i) == ')'){
                currLen--;
            }
        }

        return (len == Integer.MIN_VALUE) ? 0 : len;
    }
}