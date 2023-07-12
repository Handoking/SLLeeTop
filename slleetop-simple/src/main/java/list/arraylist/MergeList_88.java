package list.arraylist;

/**
 * @program: SLLeeTop
 * @description: 合并两个有序数组
 * @author: shileilei
 * @date: 2023-07-12 23:02
 **/
public class MergeList_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] result =  new int[m+n];
        while(i<m || j<n){
            int cur=0;
            if(i == m){
                cur = nums2[j];
                j++;
            }else if(j== n){
                cur = nums1[i];
                i++;
            }else if(nums1[i]<= nums2[j]){
                cur = nums1[i];
                i++;
            }else {
                cur = nums2[j];
                j++;
            }
            result[i+j-1] = cur;
        }
        for(int k =0; k<m+n; k++){
            nums1[k] =  result[k];
        }
    }

    public static void main(String[] args) {
        int[] nums1 ={1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(nums1);
    }

}
