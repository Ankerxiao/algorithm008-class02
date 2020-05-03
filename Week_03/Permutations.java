class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), list);
        return list;
    }
    
    private void backtrack(int[] nums, ArrayList<Integer> track, List<List<Integer>> list) {
        if (track.size() == nums.length) {
            list.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track, list);
            track.remove(track.size() - 1);
        }
    }
}