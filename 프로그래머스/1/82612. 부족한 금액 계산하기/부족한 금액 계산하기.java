class Solution {
    public long solution(long price, long money, long count) {
      
      // 등차수열의 합 + max() 메서드  
      return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
}