package IC07_QuickSort;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public static void swap(int[] array, int pos1, int pos2) {
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;}
	/**
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot.
	 * 
	 * @param array The array of data to sort
	 * @param first The first index of the array
	 * @param last  The last index of the array
	 * @return The index at which the pivot is placed
	 */
	public static int partition(int[] array, int first, int last) {
		// Initialize the pivot as the last element in the array		
		//pivot=20; last=99
		int pivot=array[last];
		// Initialize i to start out as one less than first
		int i=first-1; //i=-1
		// Loop through array from first to last-1
		for(int j=first;j<last;j++)
			if(array[j]<pivot)
				swap(array,++i,j);
		// If current element is smaller than the pivot
		// a) Increment i
		// b) Swap array[i] and array[j]
		// Else, do nothing

		// After loop, swap array[i+1] and array[last] (or pivot)
		swap(array,i+1,last); //swap(array,last element)
		// Return the index of where the pivot was placed (i+1)
		return i+1;}

	public static void quickSort(int[] array, int first, int last) {
		// If first >= last, return (done!)
		//base case:
		if (first >= last) {
			return;}
		//recursive case:
		// Otherwise, call partition to find the pivot
		int pivot = partition(array, first, last);
		// Call quickSort on left part of array (less than pivot)
		// Call quickSort on right part of array (greater than pivot
		quickSort(array, first, pivot - 1);
		quickSort(array, pivot + 1, last);}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[1000000];
		Random rng = new Random();
        //Fill the array with random values:

		for(int i=0;i<array.length;i++){
			array[i]=rng.nextInt(100);}


		long startingTime=System.currentTimeMillis();
		System.out.println("UNSORTED");
		System.out.println(Arrays.toString(array));
        quickSort(array,0,array.length-1);
		System.out.println("SORTED");
		System.out.println(Arrays.toString(array));
		long endTime=System.currentTimeMillis();
		System.out.println("\nSorting time: "+(endTime-startingTime)+"ms");
		// Capture system clock time before
		// Call quickSort 1,000,000 times, each on a randomly generated array
		// Capture system clock time after
		// Display the milliseconds elapsed

	}

}
