class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        HashMap<Integer,List<String>> map = new HashMap<>();

        map.put(2, Arrays.asList("a", "b", "c"));
    	map.put(3, Arrays.asList("d", "e", "f"));
    	map.put(4, Arrays.asList("g", "h", "i"));
    	map.put(5, Arrays.asList("j", "k", "l"));
    	map.put(6, Arrays.asList("m", "n", "o"));
    	map.put(7, Arrays.asList("p", "q", "r", "s"));
    	map.put(8, Arrays.asList("t", "u", "v"));
    	map.put(9, Arrays.asList("w", "x", "y", "z"));

        helper(digits,0,new StringBuilder(),result,map);

        return result;
    }
    private void helper(String digits,int index,StringBuilder sb,List<String> list,Map<Integer,List<String>> map){

        //base
        if(index == digits.length()){
            list.add(sb.toString());
            return;
        }

        //logic
        List<String> temp = map.get(digits.charAt(index)-'0');
        for(String s: temp){
            sb.append(s);
            helper(digits,index+1,sb,list,map);
            sb.deleteCharAt(sb.length()-1);
        } 
        
    }
}