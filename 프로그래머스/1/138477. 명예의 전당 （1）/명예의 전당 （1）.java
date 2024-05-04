import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] rank = new int[k];
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < score.length; i++) {
            
            if (i < k) {
                if (score[i] < min) {
                    min = score[i];
                } 
                answer[i] = min;
                rank[i] = score[i];
                
                if (i == k - 1) {
                    Arrays.sort(rank);
                }
            } else {
                if (score[i] > rank[0]) {
                    rank[0] = score[i];
                    Arrays.sort(rank);
                }
                answer[i] = rank[0];
            }
        }
        
        return answer;
    }
}