/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-24
 * Time:19:28
 **/
public class TestSort {

    //堆排序

    public void heapSort(int[] array){
        // 1. 建大堆
        createHeap(array, array.length);

        // 2. 进行选择的过程，一共需要 array.length - 1 组
        for (int i = 0; i < array.length - 1; i++) {
            // 无序：[0, array.length - i)
            swap(array, 0, array.length - i - 1);
            // 无序：[0, array.length - i - 1)
            adjustDown(array, array.length - i - 1, 0);
        }

    }
    public void createHeap(int[] array,int size){
        for (int i = (size - 2) / 2; i >= 0; i--) {
            adjustDown(array, size, i);
        }


    }
    private void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public void adjustDown(int[] array,int size,int index){
        while (2 * index + 1 < size) {
            int maxIndex = 2 * index + 1;
            if (maxIndex + 1 < size && array[maxIndex + 1] > array[maxIndex]) {
                maxIndex++;
            }

            if (array[index] >= array[maxIndex]) {
                break;
            }

            swap(array, index, maxIndex);

            index = maxIndex;
        }


    }

    //选择排序

    public void selectSort(int[] array){
        for (int bound = 0; bound < array.length-1; bound++) {
            for (int cur = bound+1; cur < array.length-1; cur++) {
                if (array[cur] < array[bound]){
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

   //希尔排序

    public void insertSortWithGap(int[] array,int gap){

        for (int bound = gap; bound < array.length; bound++) {
            int key = array[bound];
            int cur ;
            for ( cur = bound-gap; cur >= 0 ; cur -= gap) {
                if (key < array[cur]){
                    array[cur+gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur+gap] = key;
        }
    }
    public void shellSort(int[] array,int gap){
        while(gap > 1){
            insertSortWithGap(array,gap);
            gap = gap/2;
        }
        insertSortWithGap(array,1);
    }

    //冒泡排序

    public void bubbleSort(int[] array){
        //表示循环比较趟数
        for (int i = 0; i < array.length-1; i++) {
            //定义flg是对冒泡排序的一个优化，如果当前数组已经有序，可以直接从循环中break
            boolean flg = false;
            //表示每次需要比较的次数
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if (!flg){
                break;
            }
        }
    }
    //插入排序
    public void insertSort(int[] array){
        //1、划分区间，将整个数组分为待排序区间和已排序区间
        //已排序区间：[0,bound),待排序区间:[bound,array.length-1)
        for (int bound = 0; bound < array.length-1; bound++) {
            //定义变量保存bound+1处的值
            int key = array[bound+1];
            //定义cur当前待排序位置下标
            int cur;
            for ( cur = bound; cur >= 0 ; cur--) {
                //判断待排序区间的值和已排序区间的最后一个值的大小关系
                //如果待排序区间的值大于已排序区间的最后一个值，那么将二者位置交换
                if (key < array[cur]){
                    array[cur+1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur+1] = key;
        }
    }
}
