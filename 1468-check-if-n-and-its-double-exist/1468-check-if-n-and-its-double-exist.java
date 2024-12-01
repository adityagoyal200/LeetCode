class Solution {
    public boolean checkIfExist(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
