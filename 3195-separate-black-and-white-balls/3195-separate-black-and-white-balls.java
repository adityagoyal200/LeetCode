class Solution {
    public long minimumSteps(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] balls = s.toCharArray();
        int i = 0;
        int j =  balls.length-1;
        long count = 0;

        while(i < j){
            if(balls[i] == '0'){
                i++;
                continue;
            }
            if(balls[j] == '1'){
                j--;
                continue;
            }
            if(balls[i] == '1' && balls[j] == '0'){
                balls[i] = '0';
                balls[j] = '1';
                count+= (j-i);
                i++;
                j--;
            }
        }

        return count;
    }
}