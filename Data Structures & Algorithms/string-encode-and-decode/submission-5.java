class Solution {
    List<String> actualStringList = new ArrayList<>();

    public String encode(List<String> strs) {
        // if(strs.size() == 0) return "";
        // if(strs.size() == 1) return strs.get(0);
        String encodedString  = "";
        for(String str : strs) {
            encodedString += str+"0xC0";
        }
        for(String s : strs) {
            actualStringList.add(s);
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        return actualStringList;
        // if(str.length() == 0) return new ArrayList<String>();
        // return Arrays.asList(str.split("0xC0"));
    }
}
