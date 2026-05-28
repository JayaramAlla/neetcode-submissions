class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int maxLength = 0,j=0;
        for(int i : nums){
           if(!set.contains(i-1)){
                j = 1;
                while(set.contains(i + j)){
                    j++;
                }
                maxLength = Math.max(maxLength, j);
           } 
           
        }
        return maxLength;
    }
}
