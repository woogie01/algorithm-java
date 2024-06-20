import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> columns = new HashMap<>();
        columns.put("code", 0);
        columns.put("date", 1);
        columns.put("maximum", 2);
        columns.put("remain", 3);
        
        int[][] extractData = Arrays.stream(data).filter(x -> x[columns.get(ext)] < val_ext).toArray(int[][]::new);
        Arrays.sort(extractData, (o1, o2) -> o1[columns.get(sort_by)] - o2[columns.get(sort_by)]);
        
        return extractData;
    }
}