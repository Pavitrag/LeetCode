import java.util.Optional;
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        int guesses = 0;
        while(true){
            Random r = new Random();
            int k = r.nextInt(words.length);
            int guess = master.guess(words[k]);
            if(guess == 6){
                break;
            }else{
                words = filterWords(words, words[k], guess);
            }
            // guesses++;
        }
        // System.out.println("Guesses: " + guesses);
    }

    private String[] filterWords(String[] words, String word, int matchCount) {
        List<String> alist = new ArrayList<>();
        for(String s: words){
            if(match(word, s) == matchCount){
                alist.add(s);
            }
        }
        return alist.toArray(new String[0]);
    }

    public int match(String src, String... targets){
        int count = 0;
        for(int i = 0; i < 6; i++){
            if(src.charAt(i) == targets[0].charAt(i)){
                ++count;
            }
        }
        return count;
    }
}