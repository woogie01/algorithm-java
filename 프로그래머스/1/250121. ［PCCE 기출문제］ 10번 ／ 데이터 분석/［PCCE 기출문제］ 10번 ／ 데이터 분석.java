import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> columns = new HashMap<>();
        columns.put("code", 0);
        columns.put("date", 1);
        columns.put("maximum", 2);
        columns.put("remain", 3);
        
        List<int[]> extractList = new ArrayList<>();
        for (int[] cur : data) {
            if (cur[columns.get(ext)] < val_ext) {
                extractList.add(cur);
            }
        }
        
        extractList.sort(Comparator.comparingInt(arr -> arr[columns.get(sort_by)]));
        
        return extractList.toArray(new int[0][]);
        
    }
}