import java.lang.instrument.ClassDefinition;
import java.util.Arrays;

public class RecursiveHeapSort {
    public static void main(String[] args)
    {
            int[] array = {1,51,7,12312,1,23,2};
            int[] array2 = {7,4,5,6,8,9,10,1};
            RecursiveHeapSort rh = new RecursiveHeapSort();
            rh.heapSort(array);
            System.out.println(Arrays.toString(array));
    }
    public void heapSort(int[] array) {
        createHeap(array, array.length / 2);
        heapSortRecursion(array,array.length-1);
    }
    private void heapSortRecursion(int[] array, int begin)
    {
        if (begin <= 1)
            return;
        else {
            swapAtIndex(array,0,begin);
            sink(array,0,begin-1);
            heapSortRecursion(array,--begin);
        }
    }
    private void createHeap(int[] array, int begin)
    {
        if (begin < 0)
            return;
        else {
            sink(array, begin, array.length-1);
            createHeap(array, --begin);
        }

    }
    private void sink(int[] array, int nodeId, int lastId)
    {
        if ((leftChildOf(nodeId) > lastId) || (rightChildOf(nodeId) > lastId))
        {
            return;
        }
        else {
            int maxId = leftChildOf(nodeId);
            if (rightChildOf(nodeId) <= lastId && array[leftChildOf(nodeId)] < array[rightChildOf(nodeId)])
            {
                maxId = rightChildOf(nodeId);
            }
            if (array[nodeId] < array[maxId])
            {
                swapAtIndex(array,maxId,nodeId);
                sink(array,maxId,lastId);
            }
            else return;

        }
    }
    private void swapAtIndex(int[] array, int one, int two)
    {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
    private int rightChildOf(int nodeId) {
        return nodeId * 2 + 2;
    }
    private int leftChildOf(int nodeId)
    {
        return nodeId*2+1;
    }
}
