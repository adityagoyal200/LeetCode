class Solution {
    public long dividePlayers(int[] skill) {
        if(skill == null || skill.length == 0){
            return -1;
        }

        Arrays.sort(skill);
        int len = skill.length;
        if(len % 2 != 0) return -1;
        long currVal = skill[0] + skill[skill.length-1];
        int i = 1;
        int j = skill.length-2;

        while(i < j){
            if(skill[i]+ skill[j] != currVal){
                return -1;
            }
            i++;
            j--;
        }

        i = 0;
        j = len-1;
        long result = 0;

        while(i < j){
            result += skill[i] * skill[j];
            i++;
            j--;
        }

        return result;
    }
}