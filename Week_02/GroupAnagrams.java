class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> result = new HashMap<>();
        for (String s: strs) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String keyStr = String.valueOf(a);
            if (!result.containsKey(keyStr)) {
                result.put(keyStr, new ArrayList<>());
            }
            result.get(keyStr).add(s);
        }
        return new ArrayList<>(result.values());
    }
}