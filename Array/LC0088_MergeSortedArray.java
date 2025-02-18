package Array;

import java.util.Arrays;

public class LC0088_MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
//        addAndSort(nums1,m,nums2,n);
        mergewithPoints(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }


    public static void addAndSort(int[] nums1, int m, int[] nums2, int n) { //O((m+n)log(m+n))
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void mergewithPoints(int[] nums1, int m, int[] nums2, int n) {    //O(m+n)
        int k = m + n;
        int[] temp = new int[k];
        for(int index = 0,nums1Index = 0,nums2Index = 0;index < k;index++){
            if(nums1Index >=m){ //nums1数组已经取完，后续把nums2的值直接加到temp中
                temp[index] = nums2[nums2Index++];
            } else if(nums2Index >= n){ //nums2数组已经取完，后续把nums1的值直接加到temp中
                temp[index] = nums1[nums1Index++];
            } else if (nums1[nums1Index] < nums2[nums2Index]) { //nums1元素的值小于nums2的，把nums1的值加到temp中
                temp[index] = nums1[nums1Index++];
            } else {    //nums2元素的值小于nums1的，把nums2的值加到temp中
                temp[index] = nums2[nums2Index++];
            }
        }
        for(int i = 0; i < k; i++){
            nums1[i] = temp[i];
        }
    }

    public static void mergewithPointsInverse(int[] nums1, int m, int[] nums2, int n) { //此题中默认了nums1的总长度=m+n，从后往前移动指针可以不用声明新temp数组
        int k = m + n;
        for(int index = k-1,nums1Index = m-1, nums2Index = n-1; index>=0; index--){
            if(nums1Index < 0){ //  nums1已经取完，直接把nums2的剩余值加入到nums1中
                nums1[index] = nums2[nums2Index--];
            } else if (nums2Index<0) {  //nums2取完，全部取nums1
                break;
            } else if (nums1[nums1Index] > nums2[nums2Index]) { //nums1的元素值 > nums2的，则把nums1的值移到后面
                nums1[index] = nums1[nums1Index--];
            }else { //nums1的元素值 < nums2的，把nums2的值添加到nums1后面
                nums1[index] = nums2[nums2Index--];
            }
        }
    }

}
