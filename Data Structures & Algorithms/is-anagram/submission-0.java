class Solution {
    public boolean isAnagram(String s, String t) {
        /* 1.you can sort it and then compare it equal or not
           2.you can put it in the hashmap used as a frequency map or
           you can use the array that have size 26
        */
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int cnt : freq){
            if(cnt != 0 ){
                return false;
            }
        }
        return true;
    }
}
