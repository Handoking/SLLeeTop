package sort;

/**
 * @program: SLLeeTop
 * @description: 查找数组中第K个最大的元素
 * @author: shileilei
 * @date: 2023-06-28 09:38
 * 核心思想：大顶堆，堆排序 复杂度klogn
 * 1.怎么初始化堆？从最后一个非叶子结点的计算是关键 n/2-1，然后循环向上，第一次初始化堆，符合堆得特性
 * 2.怎么调整堆？左孩子是2n+1,右孩子是2n+2，比较根节点和子节点的最大值，交换并循环向上继续完成整个树的排序
 * 3.怎么取走最大值，且继续堆排序？要么交换到尾部，要么直接用尾部覆盖最大值k-1次，最后查询数组第0个数，更关键的是排序的大小要逐次递减
 **/
public class MaxNumK_215 {

    public static int findKthLargest(int[] nums, int k){
        int heapSize = nums.length;
        //构建大顶堆
        buildHeap(nums, heapSize);
        //剔除k-1个根节点
        for (int i =0; i<k-1;i++){
            nums[0] =nums[heapSize-1];
            --heapSize;
            adjustHeap(nums,0, heapSize);
        }
        //返回第k个最大元素
        return nums[0];
    }

    private static void buildHeap(int[] nums,int n){
        for (int i = n/2-1;i>=0;i--){
            adjustHeap(nums, i,n);
        }
    }

    private static void adjustHeap(int[] nums,int root,int heapSize){
        int maxIndex = root;
        int lChild = root * 2 + 1;
        int rChild = root * 2 + 2;
        if (lChild<heapSize && nums[lChild]>nums[maxIndex]){
            maxIndex = lChild;
        }
        if (rChild<heapSize && nums[rChild]>nums[maxIndex]){
            maxIndex = rChild;
        }
        if (maxIndex != root){
            swapValue(nums,root, maxIndex);
            adjustHeap(nums, maxIndex,heapSize);
        }

    }

    private static void swapValue(int[] nums, int indexA, int indexB){
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }



    public static void main(String[] args) {
        int[] nums = {-1,2,0,5,4,6,5,6,9};
        int k = 3;
        int kthLargest = findKthLargest(nums, k);
        System.out.println("第" + k + "最大的数是：" + kthLargest);
    }






    //    public static int findKthLargest(int[] nums, int k) {
//        // 构建最大堆
//        buildMaxHeap(nums);
//
//        // 从最大堆中依次取出前K-1个最大元素
//        for (int i = 0; i < k - 1; i++) {
//            removeMax(nums);
//        }
//
//        // 堆顶元素即为第K最大的数
//        return getMax(nums);
//    }
//
//    private static void buildMaxHeap(int[] nums) {
//        int n = nums.length;
//
//        // 从最后一个非叶子节点开始，依次向上调整节点，使其符合最大堆的性质
//        for (int i = n / 2 - 1; i >= 0; i--) {
//            heapify(nums, n, i);
//        }
//    }
//
//    private static void heapify(int[] nums, int heapSize, int root) {
//        int largest = root; // 假设根节点最大
//        int leftChild = 2 * root + 1; // 左子节点索引
//        int rightChild = 2 * root + 2; // 右子节点索引
//
//        // 判断左子节点是否大于根节点
//        if (leftChild < heapSize && nums[leftChild] > nums[largest]) {
//            largest = leftChild;
//        }
//
//        // 判断右子节点是否大于根节点
//        if (rightChild < heapSize && nums[rightChild] > nums[largest]) {
//            largest = rightChild;
//        }
//
//        // 如果根节点不是最大值，则交换根节点和最大节点的位置，并继续调整子树
//        if (largest != root) {
//            int temp = nums[root];
//            nums[root] = nums[largest];
//            nums[largest] = temp;
//
//            // 递归调整交换后的子树
//            heapify(nums, heapSize, largest);
//        }
//    }
//
//    private static int getMax(int[] nums) {
//        return nums[0];
//    }
//
//    private static void removeMax(int[] nums) {
//        int n = nums.length;
//        nums[0] = nums[n - 1]; // 将最后一个元素放到堆顶
//        heapify(nums, n - 1, 0); // 调整堆顶元素使其符合最大堆的性质
//    }

}
