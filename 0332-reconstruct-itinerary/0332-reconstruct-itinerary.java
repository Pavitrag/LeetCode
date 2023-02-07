import java.util.Optional;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> toFrom = new HashMap<>();
        toFrom.put("JFK", new ArrayList<>());

        Map<String, Integer> edgeCount = new HashMap<>();
        for(List<String> dests: tickets){
            edgeCount.put(dests.get(0), edgeCount.computeIfAbsent(dests.get(0), k -> 0) + 1);
            toFrom.computeIfAbsent(dests.get(0), e -> new ArrayList<>()).add(dests.get(1));
        }
        toFrom.keySet().forEach(k -> toFrom.get(k).sort(Comparator.reverseOrder()));

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        LinkedList<String> result = new LinkedList<>();
        while(!stack.isEmpty()){
            String src = stack.peek();

            if(Optional.ofNullable(edgeCount.get(src)).orElseGet(() -> 0) == 0){
                result.addFirst(src);
                stack.pop();
            }else{
                List<String> neighbors = Optional.ofNullable(toFrom.get(src)).orElseGet(ArrayList::new);
                String next = neighbors.get(edgeCount.get(src)-1);
                stack.push(next);
                edgeCount.put(src, edgeCount.get(src)-1);
            }
        }
        return result;
    }
} 