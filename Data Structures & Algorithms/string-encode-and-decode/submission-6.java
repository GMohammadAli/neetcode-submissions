class Solution {
    List<String> actualStringList = new ArrayList<>();
    String delimiter = "0xC0";

    public String encode(List<String> strs) {
        String encodedString  = "";
        for(String str : strs) {
            encodedString += str+delimiter;
        }
        for(String s : strs) {
            actualStringList.add(s);
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        return actualStringList;
    }
}
