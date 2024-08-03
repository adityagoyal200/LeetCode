class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int bLen = beginWord.length();
        int eLen = endWord.length();
        int shortestPath = 0;
       
        Set<String> set = new HashSet<>();
        for(String s: wordList){
                set.add(s);
        }
        if(bLen != eLen || !set.contains(endWord)){
            return 0;
        }
        Queue <String> q = new LinkedList<>();
        q.offer(beginWord); //hot
        q.offer(null);
        while(!q.isEmpty()){
            String s = q.poll();
            System.out.println("fgvgvghv");
            if(s!=null && s.equals(endWord)){
                return shortestPath+1;
            }
            if(s !=  null){
                int j =0;
                while(j < s.length()){ //s= 
                    for(char i = 'a';i <='z' ;i++){
                        char[] word = s.toCharArray();
                        word[j] = i;
                        String newWord = new String(word);//hot
                        if(set.contains(newWord) && !s.equals(newWord)){
                            System.out.println("rdghg");
                            q.offer(newWord); // lot dog  
                            set.remove(newWord);
                        } 
                    }
                    
                    j++;
                }   
            } else {
                System.out.println("dshfygfyg");
                shortestPath++;
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
        }
        
        return q.isEmpty() ? 0 : shortestPath;  
    }   
}