class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char i : s.toCharArray()){
            if(!map.containsKey(i)){
                map.put(i, 1);
            } 
            else {
                map.put(i, map.get(i) + 1);
            }
        }
        for(char i : t.toCharArray()){
            if(!map.containsKey(i) || map.get(i) == 0){
                return false;
            } 
            else{
                map.put(i, map.get(i) - 1);
            }
        }
        for(int count : map.values()){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
