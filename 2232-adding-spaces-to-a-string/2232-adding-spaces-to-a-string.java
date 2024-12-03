class Solution {
    public String addSpaces(String s, int[] spaces) {
        if(s == null ||s.length() == 0){
            return "";
        }
        StringBuilder sb  = new StringBuilder();
        Arrays.sort(spaces);
        int initial = 0;

        for(int space: spaces){
            sb.append(s.substring(initial,space));
            sb.append(" ");
            initial = space;
        }
        
        sb.append(s.substring(initial,s.length()));

        return sb.toString();
    }
}