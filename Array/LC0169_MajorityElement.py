from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = 0
        candidate = 0
        for num in nums:
            if count == 0:
                candidate = num
            if num == candidate:
                count += 1
            else:
                count -= 1
        return candidate

    def majorityElement2(self, nums: List[int]) -> int:
        nums.sort()
        return nums[len(nums) // 2]

def main():
    so = Solution()
    nums = [1,1,1,2,2,3]
    print(so.majorityElement(nums))

if __name__ == '__main__':
    main()

