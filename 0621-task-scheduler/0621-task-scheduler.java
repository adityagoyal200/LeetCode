class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0){
            return 0;
        }

        int[] freq = new int[26];
        for(char c: tasks){
            freq[c-'A']++;
        }

        Arrays.sort(freq);
        int ideals = (freq[25]-1)*n;

        for(int j = 24; j >= 0; j--){
            ideals -= Math.min(freq[25]-1,freq[j]);
        }

        return tasks.length +Math.max(0,ideals);
    }
}