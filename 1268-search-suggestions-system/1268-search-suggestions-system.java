class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);
            List<List<String>> suggestions = new ArrayList<>();
            int leftBoundry = 0, rightBoundry = products.length - 1;
            for (int i = 0; i < searchWord.length(); i++) {
                leftBoundry = searchFromLeft(products, leftBoundry, rightBoundry, i, searchWord);
                if (leftBoundry < products.length) {
                    rightBoundry = searchFromRight(products, leftBoundry, rightBoundry, i, searchWord);
                }
                if (leftBoundry <= rightBoundry) {
                    suggestions.add(Arrays.asList(products).subList(leftBoundry, Math.min(Math.min(rightBoundry + 1, leftBoundry + 3), products.length)));
                }else{
                    suggestions.add(new ArrayList());
                }
            }
            return suggestions;
        }

        private int searchFromLeft(String[] products, int leftBoundry, int rightBoundry, int i, String searchWord) {
            for (int j = leftBoundry; j <= rightBoundry; j++) {
                if (i < products[j].length() && searchWord.charAt(i) == products[j].charAt(i)) {
                    return j;
                }
            }
            return products.length;
        }

        private int searchFromRight(String[] products, int leftBoundry, int rightBoundry, int i, String searchWord) {
            for (int j = rightBoundry; j >= leftBoundry; --j) {
                if (i < products[j].length() && searchWord.charAt(i) == products[j].charAt(i)) {
                    return j;
                }
            }
            return -1;
        }
}