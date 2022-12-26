import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict = new HashSet<>();

        for (String word : words) {
            dict.add(word);
        }
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            dict.remove(word);
            if(test(dict, word)){
                answer.add(word);
            }
            dict.add(word);

        }
        return answer;
    }
    private boolean test(Set<String> set, String word){
        //ensure word is removed from the set before continuing
        if(set.contains(word)){
            return true;
        }
        for(int i = 1; i < word.length(); i++){
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, word.length());
            if(set.contains(prefix) && (set.contains(suffix) || test(set, suffix))){
                return true;
            }
        }
        return false;
    }
}