/* This File will  read the input files and sort it and write into 4 files where entries are ordered by sum.
 */

package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class QuickSort {

	public void sort(int[][] sums) {
		quickSort(sums, 0, sums.length - 1);
	}

	public void quickSort(int[][] sums, int p, int r) {
		if (p < r) {
			int q = partition(sums, p, r);
			quickSort(sums, p, q - 1);
			quickSort(sums, q + 1, r);
		}
	}

	public int partition(int[][] sums, int p, int r) {
		int x = sums[r][3];     // select the last element as partition
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (sums[j][3] <= x) {
				i++;
				// if pivot is greater than element then swap the row data's of i and j
				int temp = sums[i][3];
				sums[i][3] = sums[j][3];
				sums[j][3] = temp;

				temp = sums[i][0];
				sums[i][0] = sums[j][0];
				sums[j][0] = temp;

				temp = sums[i][1];
				sums[i][1] = sums[j][1];
				sums[j][1] = temp;

				temp = sums[i][2];
				sums[i][2] = sums[j][2];
				sums[j][2] = temp;
			}
		}
		// After complete iteration swap the pivot to its place from where left side elements are smaller and right side is larger.
		int temp = sums[r][3];
		sums[r][3] = sums[i + 1][3];
		sums[i + 1][3] = temp;

		temp = sums[r][0];
		sums[r][0] = sums[i + 1][0];
		sums[i + 1][0] = temp;

		temp = sums[r][1];
		sums[r][1] = sums[i + 1][1];
		sums[i + 1][1] = temp;

		temp = sums[r][2];
		sums[r][2] = sums[i + 1][2];
		sums[i + 1][2] = temp;
		return i + 1;
	}

	public static void main(String[] args) {

		QuickSort qs = new QuickSort();
		//read and sort the input files entries.
		String readQuickSort20Output = qs.quickSort20txt(qs);
		String readQuickSort100Output = qs.quickSort100txt(qs);
		String readQuickSort1000Output = qs.quickSort1000txt(qs);
		String readQuickSort4000Output = qs.quickSort4000txt(qs);

		try {
			// creating output files and wirting the output into file.
			BufferedWriter writer = new BufferedWriter(new FileWriter("/D://arrQK_O_20.txt"));
			writer.write(readQuickSort20Output);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arrQK_O_100.txt"));
			writer.write(readQuickSort100Output);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arrQK_O_1000.txt"));
			writer.write(readQuickSort1000Output);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arrQK_O_4000.txt"));
			writer.write(readQuickSort4000Output);
			writer.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// This method will read , sort , calculate time for sort and return the output string which contains data sorted by sum for 20 rows.
	private String quickSort20txt(QuickSort qs) {
		InsertionSort ins = new InsertionSort();
		int[][] read20Arr = ins.read20Txt(); // read the file into array
		long start1 = System.nanoTime(); // start time 
		qs.sort(read20Arr);
		long end1 = System.nanoTime(); // time after completion of sorting
		String read20Output = "";
		read20Output = outputQuickSorttxt(read20Arr, start1, end1, read20Output, 20);
		return read20Output;
	}

	// This method will read , sort , calculate time for sort and return the output string which contains data sorted by sum for 100 rows.
	private String quickSort100txt(QuickSort qs) {
		InsertionSort ins = new InsertionSort();
		int[][] read100Arr = ins.read100Txt();
		long start1 = System.nanoTime(); // start time
		qs.sort(read100Arr);
		long end1 = System.nanoTime(); // time after completion of sorting
		String read100Output = "";
		read100Output = outputQuickSorttxt(read100Arr, start1, end1, read100Output, 100);
		return read100Output;
	}

	// This method will read , sort , calculate time for sort and return the output string which contains data sorted by sum for 1000 rows.
	private String quickSort1000txt(QuickSort qs) {
		InsertionSort ins = new InsertionSort();
		int[][] read1000Arr = ins.read1000Txt();
		long start1 = System.nanoTime(); // start time
		qs.sort(read1000Arr);
		long end1 = System.nanoTime(); // end time
		String read1000Output = "";
		read1000Output = outputQuickSorttxt(read1000Arr, start1, end1, read1000Output, 1000);
		return read1000Output;
	}

	// This method will read , sort , calculate time for sort and return the output string which contains data sorted by sum for 4000 rows.
	private String quickSort4000txt(QuickSort qs) {
		InsertionSort ins = new InsertionSort();
		int[][] read4000Arr = ins.read4000Txt();
		long start1 = System.nanoTime(); // start time
		qs.sort(read4000Arr);
		long end1 = System.nanoTime(); // end time
		String read4000Output = "";
		read4000Output = outputQuickSorttxt(read4000Arr, start1, end1, read4000Output, 4000);
		return read4000Output;
	}

	private String outputQuickSorttxt(int[][] readArr, long start1, long end1, String read20Output, int n) {
		for (int i = 0; i < n; i++) {
			read20Output = read20Output + readArr[i][0] + " " + readArr[i][1] + " " + readArr[i][2] + " "
					+ readArr[i][3] + "\n";
		}
		read20Output = read20Output + "Total Time Elapsed during Quick sort in nanoseconds :" + (end1 - start1);
		return read20Output;
	}
}
