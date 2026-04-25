class Solution {

    public String encode(List<String> strs) {

        StringBuilder res = new StringBuilder();
        for(String str : strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int delimiter = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, delimiter));
            i = delimiter + 1;
            list.add(str.substring(i, i + len));
            i += len;
        }
        return list;
    }
}
