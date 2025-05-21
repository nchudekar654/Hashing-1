//Problem1: Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//TC: n * klogk + k 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){ //TC: n
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr); //TC: klogk
            String sorted = new String(charArr);
            if(!map.containsKey(sorted)){   //k
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

//2nd Solution: Using prime product
//TC: nk

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double, List<String>> map = new HashMap<>();
        for(String str : strs){
            double primeProduct = primeProduct(str);
            
            if(!map.containsKey(primeProduct)){
                map.put(primeProduct, new ArrayList<>());
            }
            map.get(primeProduct).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private double primeProduct(String s){
        int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,67,71,73,79,83,89,97,101,103};
        double result = 1.0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            result = result*(primes[c - 'a']);
        }
        return result;
    }
}

