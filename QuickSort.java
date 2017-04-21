import java.io.IOException;
import java.util.Arrays;


public class QuickSort {
 
	public static int partition(int[] arr, int p, int r){
		int pivot,i,j;
		pivot = arr[p];
		i = p;
		for(j= p+1; j<r; j++){
			if(arr[j] <= pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		arr[p] = arr[i]; 
		arr[i] = pivot;		
		return i;
	}
	
	public static int[] quickSort(int[] arr, int p, int r){
		int q = 0;
		if(p < r){
			q = partition(arr, p, r);
			quickSort(arr, p, q-1);
			quickSort(arr, q+1, r);
		}
		return arr;
		
	}
	public static void performSortingForDiffInputs(String[] arryData, String inputType){
		try {
			int[] arry = new int[arryData.length];
			int[] quickSorted;
			for(int i=0; i<arryData.length;i++){
				arry[i] = Integer.parseInt(arryData[i]);
			}
			long startTime = System.currentTimeMillis();
			quickSorted = quickSort(arry, 0, arry.length-1);
			long endTime = System.currentTimeMillis() - startTime;
			System.out.println("Quick sort took "+endTime+ " milli seconds to run "+inputType+ " data set");
			System.out.println("Sorted Array is: "+Arrays.toString(quickSorted));
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileRead obj = new FileRead();
		try {
			String[] randData = obj.OpenRandomFile();
			performSortingForDiffInputs(randData,"Random");
			String[] revData = obj.OpenReverseFile();
			performSortingForDiffInputs(revData,"Reverse");
			String[] sortedData = obj.OpenSortedFile();
			performSortingForDiffInputs(sortedData,"Sorted");
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
