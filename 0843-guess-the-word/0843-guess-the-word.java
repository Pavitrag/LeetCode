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
        int last = words.length;
        while(true){
            int guess = master.guess(words[0]);
            if(guess == 6){
                System.out.println(words[0]);
                return;
            }
            for(int i = 1; i < last;){
                if(guess != match(words[0], words[i])){
                    swap(words, i, --last);
                }else{
                    i++;
                }
            }
            swap(words, 0, --last);
        }
    }

    private void swap(String[] words, int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
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