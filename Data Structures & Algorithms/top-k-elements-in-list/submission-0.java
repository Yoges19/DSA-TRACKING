class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //we have to return most frequent elements.Elements count should be k
        //ex: k=2 you have to return 2 element. that element should be have most frequency

        //step 1: store the element with frequency as a key, value pair in map
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        //Use MinHeap to get the most frequent value
        // the will be store k elements if the size of pq > k we need remove smallest element so just use poll method to remove it.
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                    new PriorityQueue<>(
                        Comparator.comparingInt(Map.Entry::getValue) // pq compare the value here we are storing the map entry so we need to mentain which value should be compared here
                        //Here we need compare the values inorder to get the highest frequency
                    );

         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
         }
         int[] ans = new int[k];
         int i = 0;
        // Then finally store it in array return it
         while(!pq.isEmpty()){
             Map.Entry<Integer, Integer> entry = pq.poll();
             ans[i++] = entry.getKey();
         }
         return ans;
    }
}
