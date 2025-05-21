//Problem3: Word Pattern: Given a pattern and a string s, find if s follows the same pattern.
//Time Complexity: O(m+n), here m=number of characters in input string and n=length of pattern
//Space Cokmplexity: O(n)

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(pattern.length() != words.length)
            return false;

        HashMap<Character, String> chartoWord = new HashMap<>();
        HashMap<String, Character> wordtoChar= new HashMap<>();

        for(int i=0; i<pattern.length(); i++){
            char pchar = pattern.charAt(i);
            String word = words[i];

            if(chartoWord.containsKey(pchar)){
                if(!chartoWord.get(pchar).equals(word))
                    return false;
            }
            else{
                chartoWord.put(pchar, word);
            }

            if(wordtoChar.containsKey(word)){
               if(wordtoChar.get(word) != pchar)
                return false; 
            }
            else{
                wordtoChar.put(word, pchar);
            }
        }
        return true;
    }
}