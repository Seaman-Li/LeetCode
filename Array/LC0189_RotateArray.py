from typing import List


class Solution:

    def reverse(self, nums: List[int], start: int, end: int):
        while (start < end):
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start += 1
            end -= 1


    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n
        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, n - 1)

def main():
    solution = Solution()
    nums = [1, 2, 3, 4, 5, 6]
    solution.rotate(nums, 3)
    print(nums)

if __name__ == '__main__':
    main()
