class Trie {
    boolean isEnd;
    HashMap<String, Trie> children;

    public Trie() {
        isEnd = false;
        children = new HashMap<>();
    }
}

class Solution {
    Trie root;

    public Solution() {
        root = new Trie();
    }

    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        for (String str : folder) {
            String a[] = str.split("/");
            Trie curr = root;
            boolean isSubFolder = false;
            for (String s : a) {
                if (s.equals("")){
                    continue;
                }
                if (!curr.children.containsKey(s)){
                    curr.children.put(s, new Trie());
                }
                curr = curr.children.get(s);
            }
            curr.isEnd = true;
        }

        for (String str : folder) {
            String a[] = str.split("/");
            Trie curr = root;
            boolean isSubFolder = false;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == ""){
                    continue;
                }

                if (curr.isEnd && i != str.length() - 1){
                    isSubFolder = true;
                }
                curr = curr.children.get(a[i]);
            }

            if (!isSubFolder){
                ans.add(str);
            }
        }

        return ans;

    }
}