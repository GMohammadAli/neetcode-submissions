class Solution {
    char delimiter = '#';

    public String encode(List<String> strs) {
        String encodedString  = "";
        for(String str : strs) {
            encodedString += str.length()+""+delimiter+str;
        }
        System.out.println("encode "+encodedString);
        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> listArr = new ArrayList<String>();

        int i = 0;
        while(i < str.length()) {
            String length = "";
            while(str.charAt(i) != delimiter) {
                length += str.charAt(i);
                i++;
            }
            System.out.println(length);
            int sizeOfString = Integer.parseInt(length);
            System.out.println(sizeOfString);
            String ele = str.substring(i+1, i+sizeOfString+1);
            listArr.add(ele);
            System.out.println("ele "+ele);
            i+=sizeOfString+1;
        }

        return listArr;
    }
}
