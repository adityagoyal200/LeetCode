class MyCalendar {

    class TreeNode {
        int start;
        int end;
        TreeNode left,right;

        public TreeNode(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    TreeNode root;

    public MyCalendar() {
        root = null;
    }
    
    public boolean book(int start, int end) {
        if(root == null){
            root = new TreeNode(start,end);
            return true;
        }
        
        TreeNode temp = root;

        while(temp != null){
            if(end <= temp.start){
                if(temp.left == null){
                    temp.left = new TreeNode(start,end);
                    return true;
                }
                temp = temp.left;
            }
            else if(start >= temp.end){
                if(temp.right == null){
                    temp.right = new TreeNode(start,end);
                    return true;
                }
                temp = temp.right;
            }
            else {
                return false;
            }
        }
        return false;
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */