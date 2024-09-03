class Solution {
    public int getLucky(String s, int k) {
        if(s == null || s.length() == 0){
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            sb.append(Integer.toString(c-'a'+1));
        }

        int count = 0;
        while(count < k){
            int i = 0;
            int total = 0;
            while(i < sb.length()){
                total += sb.charAt(i) - '0';
                i++;
            }
            count++;
            sb = new StringBuilder();
            sb.append(String.valueOf(total));
        }
        
        
        return Integer.parseInt(sb.toString());
    }
}