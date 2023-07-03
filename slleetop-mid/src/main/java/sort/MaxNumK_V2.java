package sort;

/**
 * @program: SLLeeTop
 * @description: 第K个最大的数
 * @author: shileilei
 * @date: 2023-06-29 00:24
 * 小顶堆 复杂度 nlogk
 * 核心思想
 **/
public class MaxNumK_V2 {

    public static int findKthLargest(int[] nums, int k){
        int len = nums.length;
        //构建小顶堆
        buildMinHeap(nums, k);
        //加入后续参数调整堆
        for (int i = k;i<len;i++){
            if (nums[i]>nums[0]){
                nums[0] = nums[i];
                adjustMinHeap(nums, k,0);
            }
        }
        return nums[0];
    }

    private static void buildMinHeap(int[] nums, int heapSize){
        for (int i = heapSize/2-1;i>=0;i--){
            adjustMinHeap(nums,heapSize, i);
        }
    }

    private static void adjustMinHeap(int[]nums, int heapSize,int root){
        int min = root;
        int lChild = root *2+1;
        int rChild = root *2+2;
        if (lChild<heapSize && nums[lChild]<nums[min]){
            min= lChild;
        }
        if (rChild<heapSize && nums[rChild]<nums[min]){
            min = rChild;
        }
        if (min != root){
            swapValue(nums, min, root);
            adjustMinHeap(nums, heapSize,min);
        }
    }

    private static void swapValue(int[] nums, int indexA, int indexB){
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 3;
        int kthLargest = findKthLargest(nums, k);
        System.out.println("第" + k + "最大的数是：" + kthLargest);
    }

//    public int findKthLargest(int[] nums, int k) {
//        //前K个元素原地建堆
//        buildHeap(nums,k);
//        //遍历余下的元素
//        for(int i = k; i < nums.length; i++){
//            //比堆顶小，就跳过
//            if(nums[i] < nums[0]) {
//                continue;
//            }
//            //比堆顶大，交换后重新堆化
//            swap(nums,i,0);
//            heapify(nums,k,0);
//        }
//        //K个元素的小堆顶的堆顶就是第K大元素
//        return nums[0];
//    }
//
//    /**
//     建堆函数
//     从最后一个非叶子节点开始堆化，其下标为节点数n/2 - 1
//
//     */
//    private void buildHeap(int[] nums,int len){
//        for(int i = len/2 - 1; i >= 0; i--){
//            heapify(nums,len,i);
//        }
//    }
//    /**
//     堆化函数。建立小顶堆
//     父节点的下标为i，左右孩子的下标分别为2i+1 和 2i+2
//     */
//    private void heapify(int[] nums,int len, int i){
//        //临时变量minPos用于存储最小值的下标。先假设父节点最小
//        int minPos = i;
//        while(true){
//            //和左节点比较
//            if(2 * i + 1 < len && nums[2 * i + 1] < nums[i]){
//                minPos = 2 * i + 1;
//            }
//            //和右节点比较
//            if(2 * i + 2 < len && nums[2 * i + 2] < nums[minPos]){
//                minPos = 2 * i + 2;
//            }
//            //如果minpos没有变化，说明父节点已经是最小了，直接跳出
//            if(minPos == i) {
//                break;
//            }
//
//            //否则交换节点
//            swap(nums,i,minPos);
//            //更新父节点，继续堆化
//            i = minPos;
//        }
//    }
//
//    private void swap(int[] nums, int index1,int index2){
//        int temp = nums[index1];
//        nums[index1] = nums[index2];
//        nums[index2] = temp;
//    }
}
