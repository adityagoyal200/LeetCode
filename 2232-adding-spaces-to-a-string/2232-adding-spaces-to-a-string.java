class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb  = new StringBuilder(s.length() + spaces.length);
        int initial = 0;

        for(int space: spaces){
            sb.append(s,initial,space);
            sb.append(" ");
            initial = space;
        }
        
        sb.append(s.substring(initial));

        return sb.toString();
    }
}