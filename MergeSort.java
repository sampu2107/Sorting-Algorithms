import java.io.IOException;
import java.util.Arrays;


public class MergeSort {

	public static void merge(int[] leftArr, int[] rightArr, int arr[]){
		int nl,nr,i=0,j=0,k=0;
		nl = leftArr.length;
		nr = rightArr.length;
		while(i<nl && j<nr){
			if(leftArr[i] <= rightArr[j]){
				arr[k] = leftArr[i];
				i++;
				k++;
			}else{
				arr[k] = rightArr[j];
				j++;
				k++;
			}
		}
		while(i<nl){
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while(j<nr){
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}
	
	
	
	public static int[] mergeSort(int arr[]){
		int n = arr.length;
		if(n < 2){
			return arr;
		}else{
			int mid = n/2;
			int[] leftArr = new int[mid];
			int[] rightArr = new int[n-mid];
			for(int i = 0; i< mid; i++){
				leftArr[i] = arr[i];
			}
			for(int i = mid; i< n; i++){
				rightArr[i-mid] = arr[i];
			}
			mergeSort(leftArr);
			mergeSort(rightArr);
			merge(leftArr,rightArr,arr);
		}
		return arr;
	}
	
	public static void performSortingForDiffInputs(String[] arryData, String inputType){
		try {
			int[] arry = new int[arryData.length];
			int[] mergeSorted;
			for(int i=0; i<arryData.length;i++){
				arry[i] = Integer.parseInt(arryData[i]);
			}
			long startTime = System.currentTimeMillis();
			mergeSorted = mergeSort(arry);
			long endTime = System.currentTimeMillis() - startTime;
			System.out.println("Merge sort took "+endTime+ " milli seconds to run for "+inputType+ " data set");
			System.out.println("Sorted array is: "+Arrays.toString(mergeSorted));
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
