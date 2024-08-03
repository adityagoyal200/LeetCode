class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length){
            return false;
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num: target){
            map.put(num , map.getOrDefault(num,0)+1);
        }

        for (int num : arr) {
            if (!map.containsKey(num) || map.get(num) == 0) {
                return false;
            }
            map.put(num, map.get(num) - 1);
        }

        return true;

    }
}
