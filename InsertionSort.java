import java.io.IOException;
import java.util.Arrays;


public class InsertionSort {
	
	public static int[] insertionSort(int arr[], int n){
		int i,key = 0;
		for(int j=1;j<n;j++){
			key = arr[j];
			i = j-1;
			while(i>=0 && arr[i]>key){
				arr[i+1] = arr[i];
				i--;
			}
		arr[i+1] = key;			
		}
		return arr;
	}
	
	public static void performSortingForDiffInputs(String[] arryData, String inputType){
		try {
			int[] arry = new int[arryData.length];
			int[] insSorted;
			for(int i=0; i<arryData.length;i++){
				arry[i] = Integer.parseInt(arryData[i]);
			}
			long startTime = System.currentTimeMillis();
			insSorted = insertionSort(arry, arry.length);
			long endTime = System.currentTimeMillis() - startTime;
			System.out.println("Insertion sort took "+endTime+ " milli seconds to run for "+inputType+ " data set");
			System.out.println("Sorted array is: "+Arrays.toString(insSorted));
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
