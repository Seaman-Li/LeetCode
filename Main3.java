import java.util.*;



public class Main3 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param nums1 int整型 ArrayList
     * @param nums2 int整型 ArrayList
     * @param k int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> maxNumber(ArrayList<Integer> nums1, ArrayList<Integer> nums2, int k) {
        // write code here

        ArrayList<Integer> merged = new ArrayList<>();
        merged.addAll(nums1);
        merged.addAll(nums2);

        List<Integer> sorted = new ArrayList<>(merged);
        sorted.sort((a,b)-> b-a);
        List<Integer> topK = sorted.subList(0,k);
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num: topK){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int num: nums1){
            if(countMap.getOrDefault(num,0)>0){
                res.add(num);
                countMap.put(num, countMap.get(num)-1);
                if(res.size()==k)
                    return res;
            }
        }
        for(int num: nums2){
            if(countMap.getOrDefault(num,0)>0){
                res.add(num);
                countMap.put(num, countMap.get(num)-1);
                if(res.size()==k)
                    return res;
            }
        }
        return res;
    }
}
