class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        /* This hash map gonna store the key as the frequencey value
           ex: "abc" ,"bac" "ab"
           key for "abc" -> "111 rest of the characters 0 or any other things"
           it first add this
           <"111", abc>
           then step 2
           key for "bac" -> "111 rest of the characters 0 or any other things"
           The point here , It have a same key as the previous one
           so we can added it like this below one
           <"111", ["abc", "bac"]>
           key for "ab" => "11 remaining contains 0"
           |<"110", ["ab"]>        |
           |<"111", ["abc", "bac"]>| 
           =========================
            all values are our answer. oooohh this is a broad  explanation for a hash map storing key as freq😂😂🥴
        */
        
        for(String str: strs){
            int[] freq = new int[26];
            for(int ch : str.toCharArray()){
                freq[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                sb.append(freq[i]);
                sb.append("#");
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
