class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        if(nums1.length > nums2.length){
           return getElements(nums1,nums2,map);
        } else {
           return getElements(nums2,nums1,map);
        }
    }
    private int[] getElements(int[] arr1, int[] arr2, HashMap<Integer,Integer> map){
        for(int num: arr1 ){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> List = new ArrayList<>();

        for(int num: arr2){
            if(map.containsKey(num) && map.get(num) > 0){
                List.add(num);
                map.put(num,map.get(num)-1);
            }
        }
        
        int[] result = new int[List.size()];
        Iterator<Integer> itr = List.iterator(); 
        int i = 0;

        while(itr.hasNext()){
            result[i++] = itr.next();
        }

        return result;
    }
}