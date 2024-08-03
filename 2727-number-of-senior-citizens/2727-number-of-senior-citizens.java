class Solution {
    public int countSeniors(String[] details) {
        if(details == null || details.length == 0){
            return 0;
        }
        int count = 0;
        for(String s: details){
            if(Integer.parseInt(s.substring(11,13)) > 60){
                count++;
            }
        }

        return count;
    }
}