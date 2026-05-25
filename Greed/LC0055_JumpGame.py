from typing import List

#不断维护目前最远能到哪里。只要某个位置 i 已经超过了 max_reach，说明这个位置根本到不了，直接返回 False
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_reach = 0

        for i in range(len(nums)):
            if i > max_reach:
                return False

            max_reach = max(max_reach, i + nums[i])

        return True

def main():
    sol = Solution()
    nums = [3,2,1,0,4]
    ans = sol.canJump(nums)
    print(ans)

if __name__ == '__main__':
    main()