class Solution {
    boolean solution(String s) {
        
        int pNum = 0;
        int yNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            
            if (temp == 'p' || temp == 'P') {
                pNum++;
            } else if (temp == 'y' || temp == 'Y') {
                yNum++;
            }
        }

        return pNum == yNum ? true : false;
    }
}