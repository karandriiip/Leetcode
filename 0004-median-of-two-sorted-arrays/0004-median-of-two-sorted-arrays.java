class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n = nums1.length, m = nums2.length, tot = n + m, half = tot / 2, l = 0, r = m;
        while(l <= r) {
            int i = (r + l) / 2, j = half - i;
            int rightB = i == m ? Integer.MAX_VALUE : nums2[i], leftB = i == 0 ? Integer.MIN_VALUE : nums2[i - 1];
            int rightA = j == n ? Integer.MAX_VALUE : nums1[j], leftA = j == 0 ? Integer.MIN_VALUE : nums1[j - 1];
            if(leftB <= rightA && leftA <= rightB) 
                return tot % 2 == 0 ? (double)(Math.min(rightA, rightB) + Math.max(leftA, leftB)) / 2.0 : (double)Math.min(rightA, rightB);
            if(leftA > rightB) l = i + 1; else r = i - 1;
        }
        return -1;
    }
}