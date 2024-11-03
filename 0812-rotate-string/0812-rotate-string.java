class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }

        if(s.concat(s).contains(goal)){
            return true;
        }

        return false;
    }   
}