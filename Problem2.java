//Problem: Given two strings s and t, determine if they are isomorphic.
//Time Complexity: O(n). Each operation of HashMap is average time: O(1)
//Space Complexity: O(n)

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if(slen != tlen)
            return false;

        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for(int i=0; i<slen; i++){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            if(sMap.containsKey(schar)){
                if(sMap.get(schar) != tchar){
                    return false;
                }
            }
            else{
                    sMap.put(schar, tchar);
                }

            if(tMap.containsKey(tchar)){
                if(tMap.get(tchar) != schar){
                    return false;
                }
            }else{
                    tMap.put(tchar, schar);
                }
            }
        return true;
    }
}