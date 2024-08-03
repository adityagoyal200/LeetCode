class Solution {
    public String countOfAtoms(String formula) {
        if(formula == null || formula.length() == 0){
            return "";
        }

        Stack<TreeMap<String,Integer>> st = new Stack<>();
        st.push(new TreeMap<>());
        int i = 0;

        while(i < formula.length()){
            if(formula.charAt(i) == '('){
                st.push(new TreeMap<>());
                i++;
            } else if(formula.charAt(i) == ')'){
                TreeMap<String,Integer> top = st.pop();
                i++;
                int start = i;
                while(i < formula.length() && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                int multiply = (start < i) ? Integer.parseInt(formula.substring(start,i)) : 1;
                for(String key: top.keySet()){
                    int cnt = top.get(key);
                    st.peek().put(key,st.peek().getOrDefault(key,0) + cnt * multiply);
                }
            } else {
                int start = i;
                i++;
                while(i < formula.length() && Character.isLowerCase(formula.charAt(i))){
                    i++;
                }
                String name = formula.substring(start,i);
                start = i;
                while(i < formula.length() && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                int num = start < i ? Integer.parseInt(formula.substring(start,i)):1;
                st.peek().put(name,st.peek().getOrDefault(name,0)+num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String name: st.peek().keySet()){
            sb.append(name);
            int cnt = st.peek().get(name);
            if(cnt > 1){
                sb.append(cnt);
            }
        }

        return sb.toString();
    }
}