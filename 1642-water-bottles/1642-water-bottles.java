class Solution {
    public int numWaterBottles(int bottles, int exchange) {
        
        int totalBottles = bottles;
        int empty = bottles;

        while (empty >= exchange) {
            int newBottles = empty / exchange;
            totalBottles += newBottles;
            empty = newBottles + (empty % exchange);
        }

        return totalBottles;
    }
}
