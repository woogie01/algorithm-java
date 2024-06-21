class Solution {
    public String solution01(String new_id) {
        
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

        // 빈 문자열 예외처리
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 길이가 너무 긴 경우 예외처리
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() -1);
            }
        }

        // 길이가 너무 짧은 경우 예외처리
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        return new_id;
    }

    // 정규 표현식의 활용
    public String solution02(String new_id) {
        
        // 1단계: 모든 대문자를 소문자로 치환
        new_id = new_id.toLowerCase();

        // 2단계: 소문자, 숫자, '-', '_', '.'를 제외한 모든 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3단계: 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");

        // 4단계: 마침표가 처음이나 끝에 위치한다면 제거
        new_id = new_id.replaceAll("^\\.|\\.$", "");

        // 5단계: 빈 문자열이라면, "a"를 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6단계: 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            // 제거 후 마침표가 끝에 위치한다면 끝 마침표 제거
            new_id = new_id.replaceAll("\\.$", "");
        }

        // 7단계: 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}
