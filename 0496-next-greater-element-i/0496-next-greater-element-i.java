class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return new int[] {};
        }
        int[] nge = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i); // 4,0/ 1,1 /2,2
        }
        Stack<Integer> st = new Stack<>();
        int i = nums2.length - 1;

        while (i >= 0) { // 4
            if (map.containsKey(nums2[i])) { //
                if (st.isEmpty()) {
                    nge[map.get(nums2[i])] = -1;// [-1,,-1]
                } else {
                    if (st.peek() < nums2[i]) {
                        while (!st.isEmpty() && st.peek() < nums2[i]) {
                            st.pop();
                        }
                        nge[map.get(nums2[i])] = (st.isEmpty()) ? -1 : st.peek();
                    } else {
                        nge[map.get(nums2[i])] = st.peek();
                    }
                }
            }

            st.push(nums2[i]);

            i--;
        }

        return nge;
    }
}