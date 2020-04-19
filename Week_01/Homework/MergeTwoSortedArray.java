class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) {
            nums1[m] = nums2[n-1];
            n--;
            m++;
        }
        Arrays.sort(nums1);
    }
}