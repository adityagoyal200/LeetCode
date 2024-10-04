class Solution {
    public long dividePlayers(int[] skill) {
        if(skill == null || skill.length == 0){
            return -1;
        }

        Arrays.sort(skill);
        int len = skill.length;

        if(len % 2 != 0) return -1;

        long currVal = skill[0] + skill[len-1];
        
        int i = 1;
        int j = skill.length-2;

        long result = skill[0] * skill[len-1];

        while(i < j){
            if(skill[i]+ skill[j] != currVal){
                return -1;
            } else {
                result += skill[i]*skill[j];
            }
            i++;
            j--;
        }

        return result;
    }
}