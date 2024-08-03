class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return list;
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String curr = new String(charArr);
            if(!map.containsKey(curr)){
                map.put(curr, new ArrayList<String>());
            }
            map.get(curr).add(s);
        }
        
        for(String s : map.keySet()){
            list.add(map.get(s));
        }
        
        return list;
    }
}