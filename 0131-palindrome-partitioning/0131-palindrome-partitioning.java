class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }

        backtrack(s,0,new ArrayList<>());
        
        return result;
    }
    private void backtrack(String s, int start, List<String> temp){
        //base
        if(start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        //logic
        for(int i = start; i < s.length(); i++){
            String sub = s.substring(start,i+1);
            if(isPalindrone(sub)){
                temp.add(sub);
                backtrack(s,i+1,temp);
                temp.remove(temp.size()-1);
                
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
