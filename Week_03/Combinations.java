class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int n, int k, int start, List<Integer> track, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k - 1, i + 1, track, result);
            track.remove(track.size() - 1);
        }
    }
}