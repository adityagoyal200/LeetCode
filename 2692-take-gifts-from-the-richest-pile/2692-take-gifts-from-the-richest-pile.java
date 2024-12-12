class Solution {
    
    public long pickGifts(int[] gifts, int k) {
        if(gifts == null || gifts.length == 0){
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i = 0; i < gifts.length; i++){
            pq.add(new int[]{i,gifts[i]});
        }

        for(int i = 0; i < k; i++){
            int[] currGift = pq.poll();
            int val = (int)(Math.sqrt(currGift[1]));
            int index = currGift[0];
            gifts[index] = val;
            pq.offer(new int[]{index,val}); 
        }

        long sum = 0;
        for(int gift: gifts){
            sum += gift;
        }

        return sum;
    }
}