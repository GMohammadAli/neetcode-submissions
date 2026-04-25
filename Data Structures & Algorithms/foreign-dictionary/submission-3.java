class Solution {
    public String foreignDictionary(String[] words) {
      //1. Create a  graph
      HashMap<Character, List<Character>> graph = new HashMap<>();

      for(int i = 0; i < words.length; i++) {
        for(int j = 0; j < words[i].length(); j++) {
            graph.putIfAbsent(words[i].charAt(j), new ArrayList<>());
        }
      }

      for(int i = 0; i < words.length - 1; i++) {
        String w1 = words[i];
        String w2 = words[i+1];
        for(int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
            if(w1.charAt(j) != w2.charAt(j)) {
                graph.get(w1.charAt(j)).add(w2.charAt(j));
                break;
            }
            if(w1.length() > w2.length()) return "";
        }
      }

      //2. DFS Topological sort
      HashSet<Character> processed = new HashSet<>();
      HashSet<Character> visiting = new HashSet<>();
      StringBuilder result = new StringBuilder();
      for(Character node : graph.keySet()) {
        if(!dfs(node, processed, visiting, graph, result)) {
            return "";
        }
      }

      return result.reverse().toString();
    }

    public boolean dfs(Character node, HashSet<Character> processed, HashSet<Character> visiting, HashMap<Character, List<Character>> graph, StringBuilder result) {
        if(processed.contains(node)) return true;

        if(visiting.contains(node)) return false;

        visiting.add(node);

        //visit all it's adjacent chars
        for(Character c : graph.get(node)) {
            if(!dfs(c, processed, visiting, graph, result)) return false;
        }

        visiting.remove(node);
        processed.add(node);
        result.append(node);

        return true;
    }
}
