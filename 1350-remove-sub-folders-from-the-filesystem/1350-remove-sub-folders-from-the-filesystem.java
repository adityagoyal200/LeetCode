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
        Arrays.sort(folder);

        for (String str : folder) {
            String[] parts = str.split("/");
            Trie curr = root;
            boolean isSubFolder = false;

            for (String part : parts) {
                if (part.isEmpty()) continue;
                if (curr.isEnd) {
                    isSubFolder = true;
                    break;
                }
                curr.children.putIfAbsent(part, new Trie());
                curr = curr.children.get(part);
            }

            if (!isSubFolder) {
                curr.isEnd = true;
                ans.add(str);
            }
        }

        return ans;
    }
}
