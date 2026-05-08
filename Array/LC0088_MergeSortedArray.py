from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        index1 = m - 1
        index2 = n - 1
        for k in range(m + n -1, -1 , -1):
            if index1 < 0:  # nums1已经取完，直接把nums2的剩余值加入到nums1中
                nums1[k] = nums2[index2]
                index2 -= 1
            elif index2 < 0: # nums2取完，全部取nums1
                break
            elif nums1[index1] > nums2[index2]: # nums1的元素值 > nums2的，则把nums1的值移到后面
                nums1[k] = nums1[index1]
                index1 -= 1
            elif nums1[index1] <= nums2[index2]:# nums1的元素值 < nums2的，把nums2的值添加到nums1后面
                nums1[k] = nums2[index2]
                index2 -= 1



def main():
    solution = Solution()
    # 这题中0是占位符
    num1 = [1,2,3,0,0,0]
    m = 3
    num2 = [2,5,6]
    n = 3
    solution.merge(num1,m,num2,n)
    print(num1)

if __name__ == "__main__":
    main()
