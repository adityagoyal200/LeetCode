class Solution {
    public double averageWaitingTime(int[][] customers) {
        if(customers == null || customers.length == 0){
            return 0.0;
        }

        double wait = 0;
        int currTime = -1;

        for(int[] customer : customers) {
            currTime = (currTime <= customer[0]) ? customer[0] : currTime;
            currTime += customer[1];
            wait += currTime - customer[0];
        }
        return wait/customers.length;
    }
}