import java.util.Arrays;

/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-24
 * Time:19:41
 **/
public class TestDemo {

    public static void main(String[] args) {
        int[] array = {9,4,6,7,2,3};
        TestSort testSort = new TestSort();
        testSort.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
