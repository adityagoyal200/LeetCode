class Solution {
    public int minOperations(String[] logs) {
        if(logs == null || logs.length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < logs.length; i++){
            if(count < 0){
                count = 0;
            }
            if(logs[i].equals("../")){
                count--;
            } else if(logs[i].equals("./")){
                continue;
            } else {
                count++;
            }
        }

        return (count < 0) ? 0 : count;
    }
}