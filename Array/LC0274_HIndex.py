
# Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
# return the researcher's h-index.
# According to the definition of h-index on Wikipedia:
# The h-index is defined as the maximum value of h such that
# the given researcher has published at least h papers that have each been cited at least h times.
#
# Example 1:
#
# Input: citations = [3,0,6,1,5]
# Output: 3
# Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
# Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
# Example 2:
#
# Input: citations = [1,3,1]
# Output: 1
#
#
# Constraints:
#
# n == citations.length
# 1 <= n <= 5000
# 0 <= citations[i] <= 1000
from typing import List



class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort(reverse=True)
        h = 0
        for i in range(len(citations)):
            if citations[i] >= i + 1:
                h = i + 1
            else:
                break
        return h


# citations = [6, 5, 3, 1, 0]
#
# You compare each citation count with its rank:
#
# citation: 6   5   3   1   0
# rank:     1   2   3   4   5
#
# Then check:
#
# 6 >= 1   yes
# 5 >= 2   yes
# 3 >= 3   yes
# 1 >= 4   no
# 0 >= 5   no

def main():
    sol = Solution()
    a = [6, 5, 3, 1, 0]
    print(sol.hIndex(a))

if __name__ == "__main__":
    main()
