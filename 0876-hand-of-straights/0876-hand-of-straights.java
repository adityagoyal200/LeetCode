class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand == null || hand.length == 0 || hand.length < groupSize){
            return false;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        Arrays.sort(hand);
        for(int num: hand){
            if(map.get(num) == 0) continue;

            for(int i = 0; i < groupSize; i++){
                int currNum = num+i;
                if(map.getOrDefault(currNum,0) == 0){
                    return false;
                }
                map.put(currNum,map.get(currNum)-1); 
            }
        }

        return true;
    }
}
