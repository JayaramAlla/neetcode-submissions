class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        int[][] cal = new int[strs.length][26];
        int count = 0;
        for(String s : strs){
            int[] arry = getCharArray(s);
            boolean found = false;
            
            //iterate over the current list for matches
            for(int i = 0;i < groups.size()  ; i++ ){
                if( compareAnagram(arry, cal[i])){
                    groups.get(i).add(s);
                    found = true;
                    break;
                }
            }

            //if not found add it to the main list.
            if(!found){
                List<String> newList = new ArrayList<>();
                newList.add(s);
                cal[groups.size()] = arry; 
                groups.add(newList);
            }

        }
        return groups;
    }

    public boolean compareAnagram(int[] current, int[] existing){
        for( int i =0;i< 26;i++){
            if(current[i] != existing[i]){
                return false;
            }
        }
        return true;
    }

    public int[] getCharArray(String s){
        int[] charArry = new int[26];

        for(char c : s.toCharArray()){
            charArry[c-'a']++;
        }

        return charArry;
    }
}
