class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> st = new Stack<>();

        for (String dir : dirs) {
            if (dir.equals(".") || dir.isEmpty()) {
                continue;
            } else if (dir.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(dir);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
            sb.insert(0, "/");
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

}