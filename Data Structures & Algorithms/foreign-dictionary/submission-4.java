class Solution {
	public String foreignDictionary(String[] words) {
		//1. Create a Graph (Adjacency List)
		HashMap<Character, List<Character>> graph = new HashMap<>();
		
		for(String word : words) {
			for(char c : word.toCharArray()) {
				graph.put(c, new ArrayList<>());
			}
		}
		
		for(int i = 0; i < words.length - 1; i++) {
			String w1 = words[i];
			String w2 = words[i + 1];
			for(int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
				if(w1.charAt(j) != w2.charAt(j)) {
				//creating edges
					graph.get(w1.charAt(j)).add(w2.charAt(j));
					break;
				}
				//breaks the rule
				if(w1.length() > w2.length()) return "";
			}
		}
		
		//2. TopoLogical Sort
		HashSet<Character> processed = new HashSet<>();
		HashSet<Character> recursionStack = new HashSet<>();
		StringBuilder result = new StringBuilder();
		
		for(Character node : graph.keySet()) {
			if(!traverseNDetectCycle(node, processed, recursionStack, graph, result)) {
				//false if cycle present, cycle shows no valid ordering could be found
				return "";
			}
		}
		
		return result.reverse().toString();
	}
	
	public boolean traverseNDetectCycle(Character node, HashSet<Character> processed, HashSet<Character> recursionStack, HashMap<Character, List<Character>> graph, StringBuilder result) {
		//if already visited, cycle
		if(recursionStack.contains(node)) return false;
		
		//if already processed, then already part of result
		if(processed.contains(node)) return true;
		
		recursionStack.add(node);	
		for(Character neighbor : graph.get(node)) {
			if(!traverseNDetectCycle(neighbor, processed, recursionStack, graph, result)) {
				return false;
			}
		}
		recursionStack.remove(node);
		processed.add(node);
		result.append(node);
		
		return true;
	}

}