class Solution {
    class Node{
            Node[] nodes = new Node[26];
            boolean end;
        }

        public void insert(Node root, String word){
            Node itr = root;
            for(char c: word.toCharArray()){
               if(itr.nodes[c - 'a'] == null){
                   itr.nodes[c-'a'] = new Node();
               }
               itr = itr.nodes[c-'a'];
            }
            itr.end = true;
        }

        public List<String> prefixSearch(Node root, String prefix){
            List<String> matchedProducts = new ArrayList<>();
            boolean prefixFound = true;
            Node iterator = root;
            for(char c: prefix.toCharArray()){
                int offset =  c - 'a';
                if(iterator.nodes[offset] == null){
                    prefixFound = false;
                    break;
                }
                iterator = iterator.nodes[offset];
            }//:~ end for

            if(!prefixFound){
                return matchedProducts;
            }
            if(iterator.end){
                matchedProducts.add(prefix);
            }
            for(int i = 0; i < iterator.nodes.length; i++){
                if(iterator.nodes[i] != null){
                    List<String> suffixes = getSuffixes(iterator.nodes[i], prefix + (char)('a' + i));
                    if(suffixes != null) {
                        matchedProducts.addAll(suffixes);
                    }
                }
            }
            return matchedProducts;
        }

        private List<String> getSuffixes(Node node, String prefix) {
            List<String> gather = new ArrayList<>();
            if(node.end){
                gather.add(prefix);
            }
            Node[] itr = node.nodes;
            for(int i = 0; i < itr.length; i++){
                if(itr[i] != null){
                        var nexts = getSuffixes(itr[i], prefix + (char)(i + 'a'));
                        nexts.stream().forEach(w -> gather.add(w));
                }
            }
            return gather;
        }

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            
            Node root = new Node();
            
            for(String word: products){
                insert(root, word);
            }
            var result = new ArrayList<List<String>>();
            List<String> masterMatchedWords = prefixSearch(root, searchWord.substring(0, 1));
            result.add(masterMatchedWords.size() <= 3 ? masterMatchedWords : masterMatchedWords.subList(0, 3));
            if(searchWord.length() > 1){
                for(final AtomicInteger ai = new AtomicInteger(1) ; ai.get() < searchWord.length(); ai.incrementAndGet()){
                    List<String> matchedWords = new ArrayList<>();
                    masterMatchedWords.forEach(w ->
                    {
                        if(w.length() >= searchWord.substring(0, ai.get() + 1).length()) {
                            if (w.substring(0, ai.get() + 1).equals(searchWord.substring(0, ai.get() + 1))) {
                                matchedWords.add(w);
                            }
                        }
                    });
                    result.add(matchedWords.size() <= 3 ? matchedWords : matchedWords.subList(0, 3));
                }
            }
            return result;
        }
}