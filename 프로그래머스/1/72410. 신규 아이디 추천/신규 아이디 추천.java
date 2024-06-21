class Solution {
    public String solution(String new_id) {
        
        StringBuilder result = new StringBuilder();
        String allowed = "0123456789-_.abcdefghijklmnopqrstuvwxyz";
        
        // 모든 대문자를 소문자로 변환
        new_id = new_id.toLowerCase();
        
         // 다른 문자 제거
        for (char cur : new_id.toCharArray()) {
            if (allowed.indexOf(cur) != -1) {
                result.append(cur);
            }
        }
        new_id = result.toString();

        // 연속되는 "." 치환
        while (new_id.contains("..")) {
            
            new_id = new_id.replace("..", ".");
        }
        
        // 시작과 끝의 "." 치환
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() -1);
        }
        
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() -1);
            }
        }

        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        return new_id;
    }
}