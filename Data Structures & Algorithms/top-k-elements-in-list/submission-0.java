class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //we have to return most frequent elements.Elements count should be k
        //ex: k=2 you have return 2 element that element should be have most frequency

        // //step 1: store the element with frequency as a key, value pair in map
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                    new PriorityQueue<>(
                        Comparator.comparingInt(Map.Entry::getValue)
                    );

         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
         }
         int[] ans = new int[k];
         int i = 0;
         while(!pq.isEmpty()){
             Map.Entry<Integer, Integer> entry = pq.poll();
             ans[i++] = entry.getKey();
         }
         return ans;
    }
}
