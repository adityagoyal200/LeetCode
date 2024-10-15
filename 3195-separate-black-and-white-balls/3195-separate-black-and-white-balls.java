class Solution {
    public long minimumSteps(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int i = 0;
        int j =  s.length()-1;
        long count = 0;

        while(i < j){
            if(s.charAt(i) == '0'){
                i++;
                continue;
            }
            if(s.charAt(j) == '1'){
                j--;
                continue;
            }
            if(s.charAt(i) == '1' && s.charAt(j) == '0'){
                count+= (j-i);
                i++;
                j--;
            }
        }

        return count;
    }
}