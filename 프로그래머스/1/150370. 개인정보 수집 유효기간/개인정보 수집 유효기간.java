import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        int todayVal = getDate(today);
        HashMap<String, Integer> validMap = new HashMap<>();
        for (String term : terms) {
            String[] termArr = term.split(" ");
            validMap.put(termArr[0], Integer.valueOf(termArr[1]));
        }
        
        List<Integer> toDelete = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int tmpVal = getDate(privacy[0]) + validMap.get(privacy[1]) * 28;
            
            if (todayVal >= tmpVal) {
                toDelete.add(i + 1);
            }
        }
        
        return toDelete.stream()
                       .mapToInt(Integer::intValue)
                       .toArray();
    }
    
    int getDate(String date) {
        String[] arr = date.split("\\.");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        return (year * 12 * 28) + (month * 28) + (day);
    }
}