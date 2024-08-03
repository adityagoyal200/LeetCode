class Solution {
    public int maximumGroups(int[] grades) {
        return (int)((Math.sqrt(grades.length * 8 + 1) - 1)/2);
    }

    /*
    n = len of grades array
    n x (n+1) / 2 <= n
        n x (n+1) <= 2n
        n2 + n - 2n <= 0;

        use quadratic formula
        n = -1 + sqrt(1+8n)/2;
    */
}