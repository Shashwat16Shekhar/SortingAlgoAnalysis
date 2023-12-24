/* This File will  read the input files and sort it and write into 4 files where entries are ordered by sum.
 */
package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MergeSort {

	public void sort(int[][] sums) {
		mergeSort(sums, 0, sums.length - 1);
	}

	public void mergeSort(int[][] sums, int p, int r) {
		if (p < r) {
			int mid = (p + r) / 2;
			mergeSort(sums, p, mid); 		//divide the array with index from p to mid
			mergeSort(sums, mid + 1, r); 	//divide the array with index from mid+1 to r
			merge(sums, p, mid, r); 		// merge the two arrays into one in sorted form
		}
	}

	public void merge(int[][] sums, int p, int mid, int r) {
		int n1 = mid - p + 1;
		int n2 = r - mid;
		int[][] left = new int[n1][4];
		int[][] right = new int[n2][4];
		//copy the part of original array from p to mid into left array
		for (int i = 0; i < n1; i++) {
			left[i][0] = sums[p + i][0];
			left[i][1] = sums[p + i][1];
			left[i][2] = sums[p + i][2];
			left[i][3] = sums[p + i][3];
		}
		//copy the part of original array from p to mid into left array
		for (int j = 0; j < n2; j++) {
			right[j] = sums[mid + j + 1];
		}

		int i = 0, j = 0, k = p;
		// compare the entries of left and right array and copy it into sums array
		while (j < n2 && i < n1) {
			if (left[i][3] >= right[j][3]) {
				sums[k][3] = right[j][3];
				sums[k][0] = right[j][0];
				sums[k][1] = right[j][1];
				sums[k][2] = right[j][2];
				j++;
			} else {
				sums[k][3] = left[i][3];
				sums[k][0] = left[i][0];
				sums[k][1] = left[i][1];
				sums[k][2] = left[i][2];
				i++;
			}
			k++;
		}
		// if left array get emptied , copy all the right arrays entries to sums array
		while (j < n2) {
			sums[k][3] = right[j][3];
			sums[k][0] = right[j][0];
			sums[k][1] = right[j][1];
			sums[k][2] = right[j][2];
			k++;
			j++;
		}
		// if left right get emptied , copy all the left arrays entries to sums array
		while (i < n1) {
			sums[k][3] = left[i][3];
			sums[k][0] = left[i][0];
			sums[k][1] = left[i][1];
			sums[k][2] = left[i][2];
			k++;
			i++;
		}

	}

	public static void main(String[] args) {

		MergeSort ms = new MergeSort();
		//read and sort the input files entries.
		String readMergeSort20Output = ms.mergeSort20txt(ms);
		String readMergeSort100Output = ms.mergeSort100txt(ms);
		String readMergeSort1000Output = ms.mergeSort1000txt(ms);
		String readMergeSort4000Output = ms.mergeSort4000txt(ms);

		try {
			// creating output files and wirting the output into file.
			BufferedWriter writer = new BufferedWriter(new FileWriter("/D://arrMR_O_20.txt"));
			writer.write(readMergeSort20Output);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arrMR_O_100.txt"));
			writer.write(readMergeSort100Output);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arrMR_O_1000.txt"));
			writer.write(readMergeSort1000Output);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arrMR_O_4000.txt"));
			writer.write(readMergeSort4000Output);
			writer.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// This method will read , sort , calculate time for sort and return the output string which contains data sorted by sum for 20 rows.
	private String mergeSort20txt(MergeSort ms) {
		InsertionSort ins = new InsertionSort();
		int[][] read20Arr = ins.read20Txt();
		long start1 = System.nanoTime(); // start time
		ms.sort(read20Arr);
		long end1 = System.nanoTime(); // time after completion of sorting
		String read20Output = "";
		read20Output = outputMergeSorttxt(read20Arr, start1, end1, read20Output, 20);
		return read20Output;
	}

	// This method will read , sort , calculate time for sort and return the output string which contains data sorted by sum for 100 rows.
	private String mergeSort100txt(MergeSort ms) {
		InsertionSort ins = new InsertionSort();
		int[][] read100Arr = ins.read100Txt();
		long start1 = System.nanoTime(); // start time
		ms.sort(read100Arr);
		long end1 = System.nanoTime(); // time after completion of sorting
		String read100Output = "";
		read100Output = outputMergeSorttxt(read100Arr, start1, end1, read100Output, 100);
		return read100Output;
	}

	// This method will read , sort , calculate time for sort and return the output string which contains data sorted by sum for 1000 rows.
	private String mergeSort1000txt(MergeSort ms) {
		InsertionSort ins = new InsertionSort();
		int[][] read1000Arr = ins.read1000Txt();
		long start1 = System.nanoTime(); // start time
		ms.sort(read1000Arr);
		long end1 = System.nanoTime(); // time after completion of sorting
		String read1000Output = "";
		read1000Output = outputMergeSorttxt(read1000Arr, start1, end1, read1000Output, 1000);
		return read1000Output;
	}

	// This method will read , sort , calculate time for sort and return the output string which contains data sorted by sum for 4000 rows.
	private String mergeSort4000txt(MergeSort ms) {
		InsertionSort ins = new InsertionSort();
		int[][] read4000Arr = ins.read4000Txt();
		long start1 = System.nanoTime(); // start time
		ms.sort(read4000Arr);
		long end1 = System.nanoTime(); // time after completion of sorting
		String read4000Output = "";
		read4000Output = outputMergeSorttxt(read4000Arr, start1, end1, read4000Output, 4000);
		return read4000Output;
	}

	private String outputMergeSorttxt(int[][] readArr, long start1, long end1, String read20Output, int n) {
		for (int i = 0; i < n; i++) {
			read20Output = read20Output + readArr[i][0] + " " + readArr[i][1] + " " + readArr[i][2] + " "
					+ readArr[i][3] + "\n";
		}
		read20Output = read20Output + "Total Time Elapsed during Merge sort in nanoseconds :" + (end1 - start1);
		return read20Output;
	}

}
