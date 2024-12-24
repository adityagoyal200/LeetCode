class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        helper(s,0,new ArrayList<>());

        return result;
    }
    private void helper(String s,int start, List<String> list){
        if(start == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < s.length(); i++){
            String sub = s.substring(start,i+1);
            if(isPalindrone(sub)){
                list.add(sub);
                helper(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalindrone(String s){
        if(s.length() == 1){
            return true;
        }
        
        int i = 0 ; 
        int j = s.length()-1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}