class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLen = Math.min(word1.length(), word2.length());

            //breaks rule
            if(word1.length() > minLen && word1.substring(0, minLen).equals(word2.substring(0, minLen))) return "";
            int j = 0;
            while(j < minLen && word1.charAt(j) == word2.charAt(j)) {
                //skip matching words
                j++;
            }

            if(j < minLen) {
                if(!graph.get(word1.charAt(j)).contains(word2.charAt(j))) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j), indegree.get(word2.charAt(j)) + 1);
                }
            }
        }

        //Kahn's Algo
        Queue<Character> bfsQueue = new LinkedList<>();
        for(Character c : indegree.keySet()) {
            if(indegree.get(c) == 0) {
                bfsQueue.offer(c);
            }
        }

        while(!bfsQueue.isEmpty()) {
            Character node = bfsQueue.poll();
            result.append(node);
            for(Character c : graph.get(node)) {
                indegree.put(c, indegree.get(c) - 1);
                if(indegree.get(c) == 0) {
                    bfsQueue.offer(c);
                }
            }
        }

        if(result.length() != indegree.size()) return "";

        return result.toString();
    }
}
