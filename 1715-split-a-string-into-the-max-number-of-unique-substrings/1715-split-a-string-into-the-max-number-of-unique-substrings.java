class Solution {
    public int maxUniqueSplit(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int count = helper(s,0, new HashSet<>());
        return count;
    }
    private int helper(String s, int start, Set<String> set){
        if(start == s.length()){
            return 0;
        }

        int maxSplit = 0;

        for(int i = start+1; i <= s.length(); i++){
            String substring = s.substring(start,i);
            if(!set.contains(substring)){
                set.add(substring);
                int splits = 1 + helper(s,i,set);

                maxSplit = Math.max(maxSplit,splits);
                set.remove(substring);
            }
        }

        return maxSplit;
    }
}