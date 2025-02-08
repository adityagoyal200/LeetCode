class Solution:
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None (modifies nums1 in-place)
        """
        if nums1 is None or nums2 is None:
            return
        
        end = m + n - 1
        left = m - 1
        right = n - 1

        while left >= 0 and right >= 0:
            if nums1[left] > nums2[right]:
                nums1[end] = nums1[left]
                left -= 1
            else:
                nums1[end] = nums2[right]
                right -= 1
            end -= 1

        while right >= 0:
            nums1[end] = nums2[right]
            end -= 1
            right -= 1
