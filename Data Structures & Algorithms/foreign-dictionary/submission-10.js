class Solution {
    /**
     * @param {string[]} words
     * @returns {string}
     */
    foreignDictionary(words) {
        const graph = new Map();
        const indegree = new Map();

        for (const word of words) {
            for (const c of word) {
                graph.set(c, []);
                indegree.set(c, 0);
            }
        }

        for (let i = 0; i < words.length - 1; i++) {
            const w1 = words[i];
            const w2 = words[i + 1];
            const minLen = Math.min(w1.length, w2.length);

            if (w1.length > minLen && w1.substring(0, minLen) === w2.substring(0, minLen))
                return "";

            let j = 0;
            while (j < minLen && w1.charAt(j) === w2.charAt(j)) {
                j++;
            }

            if (j < minLen && !!!graph.get(w1.charAt(j)).includes(w2.charAt(j))) {
                graph.get(w1.charAt(j)).push(w2.charAt(j));
                indegree.set(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
            }
        }


        //Kahn's Algorithm
        const bfsQueue = [];
        for (const [key, value] of indegree) {
            if(value === 0) {
                bfsQueue.push(key);
            }
        }

        let result = "";
        while(bfsQueue.length != 0) {
            const node = bfsQueue.shift();
            result += node;
            for(const neighbor of graph.get(node)) {
                indegree.set(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) === 0) {
                    bfsQueue.push(neighbor);
                }
            }
        }

        if(indegree.size != result.length) return "";

        return result;
    }
}
