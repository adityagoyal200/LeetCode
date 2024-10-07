class Solution {
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0){
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        helper(num,target,0,0,0,new StringBuilder(),list);

        return list;
    }
    private void helper(String num, int target,long soFar,long prev, int index,StringBuilder sb,List<String> list){
        if(index == num.length()){
            if(soFar == target){
                list.add(sb.toString());
            } 
            return;
        }

        //logic 
        //+ - *
        for(int i = index; i < num.length(); i++){
            if(num.charAt(index) == '0' && i != index){
                continue;
            }
            long curr = Long.parseLong(num.substring(index,i+1));
            int len = sb.length();

            if(index == 0){
                sb.append(curr);
                helper(num,target,curr,curr,i+1,sb,list);
                sb.setLength(len);
            } else {
                sb.append("+").append(curr);
                helper(num,target,soFar+curr,curr,i+1,sb,list);
                sb.setLength(len);

                sb.append("-").append(curr);
                helper(num,target,soFar-curr,curr,i+1,sb,list);
                sb.setLength(len);
                
                sb.append("*").append(curr);
                helper(num,target,soFar - prev + (prev * curr),curr,i+1,sb,list);
                sb.setLength(len); 
            }
        } 
    }
}