class Solution {
    public String solution(String s) {
        
        boolean isFirst = true;
        char[] strArr = s.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            char ch = strArr[i];
            if (isFirst && ch != ' ') { // 첫 글자O
                isFirst = false;
                strArr[i] = Character.toUpperCase(ch);
            } else { // 첫 글자X
                if (ch == ' ') {
                    isFirst = true;
                } else {
                    strArr[i] = Character.toLowerCase(ch);
                }
            }
        }
        return String.valueOf(strArr);
    }
}