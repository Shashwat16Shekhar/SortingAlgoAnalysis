/* This File will create 4 input files and read it and sort it and write into 4 files where entries are ordered by sum.
 */
package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InsertionSort {

	public void sort(int[][] sums) {
		int length = sums.length;
		for (int i = 1; i < length; i++) {
			int key = sums[i][3];		// this is the key value which will be get compared
			int num1 = sums[i][0];
			int num2 = sums[i][1];
			int num3 = sums[i][2];
			int j = i - 1;
			while (j >= 0 && sums[j][3] > key) {
				// if the jth element is greater than key then copy its data into j+1 element.
				sums[j + 1][3] = sums[j][3];
				sums[j + 1][2] = sums[j][2];
				sums[j + 1][1] = sums[j][1];
				sums[j + 1][0] = sums[j][0];
				j = j - 1;
			}
			//copy the key values into (j+1)th element.
			sums[j + 1][3] = key;
			sums[j + 1][0] = num1;
			sums[j + 1][1] = num2;
			sums[j + 1][2] = num3;
		}
	}
    
	public static void main(String[] args) {

		InsertionSort ins = new InsertionSort();
		ins.generateInputFiles();
		//read and sort the input files entries.
		String readInsertion20Output = ins.insertionSort20txt(ins);
		String readInsertion100Output = ins.insertionSort100txt(ins);
		String readInsertion1000Output = ins.insertionSort1000txt(ins);
		String readInsertion4000Output = ins.insertionSort4000txt(ins);

		try {
			// creating output files and wirting the output into file.
			BufferedWriter writer = new BufferedWriter(new FileWriter("/D://arrIS_O_20.txt"));
			writer.write(readInsertion20Output);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arrIS_O_100.txt"));
			writer.write(readInsertion100Output);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arrIS_O_1000.txt"));
			writer.write(readInsertion1000Output);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arrIS_O_4000.txt"));
			writer.write(readInsertion4000Output);
			writer.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// This method will create 4 input files haviing  20,100,1000 and 4000 rows each having 3 numbers seperated by space.
	public void generateInputFiles() {

		int low = 0;
		int high = 99;
		String generate20 = "", generate100 = "", generate1000 = "", generate4000 = "";

		generate20 = create20LineNumbers(low, high, generate20);
		generate100 = create100LineNumbers(low, high, generate100);
		generate1000 = create1000LineNumbers(low, high, generate1000);
		generate4000 = create4000LineNumbers(low, high, generate4000);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("/D://arr20.txt"));
			writer.write(generate20);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arr100.txt"));
			writer.write(generate100);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arr1000.txt"));
			writer.write(generate1000);
			writer.close();

			writer = new BufferedWriter(new FileWriter("/D://arr4000.txt"));
			writer.write(generate4000);
			writer.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	
	// create a string having 4000 entries as row and in each row have 3 numbers.
	private String create4000LineNumbers(int low, int high, String read4000) {
		int j;
		j = 0;
		for (int i = 0; i < 12000; i++) {
			int random = (int) (Math.random() * (high - low)) + low;
			if (j < 3) {
				if (read4000.isEmpty()) {
					read4000 = read4000 + random;
				} else {
					read4000 = read4000 + " " + random;
				}
				j++;
			} else {
				read4000 = read4000 + "\n" + random;
				j = 1;
			}
		}
		return read4000;
	}

	// create a string having 1000 entries as row and in each row have 3 numbers.
	private String create1000LineNumbers(int low, int high, String read1000) {
		int j;
		j = 0;
		for (int i = 0; i < 3000; i++) {
			int random = (int) (Math.random() * (high - low)) + low;
			if (j < 3) {
				if (read1000.isEmpty()) {
					read1000 = read1000 + random;
				} else {
					read1000 = read1000 + " " + random;
				}
				j++;
			} else {
				read1000 = read1000 + "\n" + random;
				j = 1;
			}
		}
		return read1000;
	}

	// create a string having 100 entries as row and in each row have 3 numbers.
	private String create100LineNumbers(int low, int high, String read100) {
		int j;
		j = 0;
		for (int i = 0; i < 300; i++) {
			int random = (int) (Math.random() * (high - low)) + low;
			if (j < 3) {
				if (read100.isEmpty()) {
					read100 = read100 + random;
				} else {
					read100 = read100 + " " + random;
				}
				j++;
			} else {
				read100 = read100 + "\n" + random;
				j = 1;
			}
		}
		return read100;
	}

	// create a string having 20 entries as row and in each row have 3 numbers.
	private String create20LineNumbers(int low, int high, String read20) {
		int j = 0;
		for (int i = 0; i < 60; i++) {
			int random = (int) (Math.random() * (high - low)) + low;
			if (j < 3) {
				if (read20.isEmpty()) {
					read20 = read20 + random;
				} else {
					read20 = read20 + " " + random;
				}
				j++;
			} else {
				read20 = read20 + "\n" + random;
				j = 1;
			}
		}
		return read20;
	}

	// This method will read , calculate time for sort and return the output string which contains data sorted by sum for 20 rows.
	private String insertionSort20txt(InsertionSort ins) {
		int[][] read20Arr = read20Txt();
		long start1 = System.nanoTime(); // start time
		ins.sort(read20Arr);
		long end1 = System.nanoTime(); // time after completion of sorting
		String read20Output = "";
		read20Output = outputInsertSorttxt(read20Arr, start1, end1, read20Output, 20);
		return read20Output;
	}

	// This method will read , calculate time for sort and return the output string which contains data sorted by sum for 100 rows.
	private String insertionSort100txt(InsertionSort ins) {

		int[][] read100Arr = read100Txt();
		long start1 = System.nanoTime(); // start time
		ins.sort(read100Arr);
		long end1 = System.nanoTime(); // time after completion of sorting
		String read100Output = "";
		read100Output = outputInsertSorttxt(read100Arr, start1, end1, read100Output, 100);
		return read100Output;
	}

	// This method will read , calculate time for sort and return the output string which contains data sorted by sum for 1000 rows.
	private String insertionSort1000txt(InsertionSort ins) {

		int[][] read1000Arr = read1000Txt();
		long start1 = System.nanoTime(); // start time
		ins.sort(read1000Arr);
		long end1 = System.nanoTime(); // time after completion of sorting
		String read1000Output = "";
		read1000Output = outputInsertSorttxt(read1000Arr, start1, end1, read1000Output, 1000);
		return read1000Output;
	}

	// This method will read , sort , calculate time for sort and return the output string which contains data sorted by sum for 4000 rows.
	public String insertionSort4000txt(InsertionSort ins) {

		int[][] read20Arr = read4000Txt();
		long start1 = System.nanoTime(); // start time
		ins.sort(read20Arr);
		long end1 = System.nanoTime(); // time after completion of sorting
		String read20Output = "";
		read20Output = outputInsertSorttxt(read20Arr, start1, end1, read20Output, 4000);
		return read20Output;
	}

	private String outputInsertSorttxt(int[][] readArr, long start1, long end1, String read20Output, int n) {
		for (int i = 0; i < n; i++) {
			read20Output = read20Output + readArr[i][0] + " " + readArr[i][1] + " " + readArr[i][2] + " "
					+ readArr[i][3] + "\n";
		}
		read20Output = read20Output + "Total Time Elapsed during Insertion sort in nanoseconds :" + (end1 - start1);
		return read20Output;
	}

	// This method will read the 20 entry text file into array
	public int[][] read20Txt() {

		File file = new File("/D://arr20.txt");
		BufferedReader br;
		String[] text20 = new String[20];
		int[][] read20Int = new int[20][4];
		try {

			br = new BufferedReader(new FileReader(file));
			int i = 0;
			String input;
			while ((input = br.readLine()) != null) {
				text20[i] = input;
				i++;
			}
			for (int j = 0; j < 20; j++) {
				String[] temp = text20[j].split(" ");
				int sum = 0;
				for (String s : temp) {
					sum = sum + Integer.valueOf(s);
				}
				read20Int[j][0] = Integer.valueOf(temp[0]);
				read20Int[j][1] = Integer.valueOf(temp[1]);
				read20Int[j][2] = Integer.valueOf(temp[2]);
				read20Int[j][3] = sum;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return read20Int;
	}

	// This method will read the 100 entry text file into array
	public int[][] read100Txt() {

		File file = new File("/D://arr100.txt");
		BufferedReader br;
		String[] text100 = new String[100];
		int[][] read100Int = new int[100][4];
		try {

			br = new BufferedReader(new FileReader(file));
			int i = 0;
			String input;
			while ((input = br.readLine()) != null) {
				text100[i] = input;
				i++;
			}
			for (int j = 0; j < 100; j++) {
				String[] temp = text100[j].split(" ");
				int sum = 0;
				for (String s : temp) {
					sum = sum + Integer.valueOf(s);
				}
				read100Int[j][0] = Integer.valueOf(temp[0]);
				read100Int[j][1] = Integer.valueOf(temp[1]);
				read100Int[j][2] = Integer.valueOf(temp[2]);
				read100Int[j][3] = sum;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return read100Int;
	}

	// This method will read the 1000 entry text file into array
	public int[][] read1000Txt() {

		File file = new File("/D://arr1000.txt");
		BufferedReader br;
		String[] text1000 = new String[1000];
		int[][] read1000Int = new int[1000][4];
		try {

			br = new BufferedReader(new FileReader(file));
			int i = 0;
			String input;
			while ((input = br.readLine()) != null) {
				text1000[i] = input;
				i++;
			}
			for (int j = 0; j < 1000; j++) {
				String[] temp = text1000[j].split(" ");
				int sum = 0;
				for (String s : temp) {
					sum = sum + Integer.valueOf(s);
				}
				read1000Int[j][0] = Integer.valueOf(temp[0]);
				read1000Int[j][1] = Integer.valueOf(temp[1]);
				read1000Int[j][2] = Integer.valueOf(temp[2]);
				read1000Int[j][3] = sum;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return read1000Int;
	}

	// This method will read the 4000 entry text file into array
	public int[][] read4000Txt() {

		File file = new File("/D://arr4000.txt");
		BufferedReader br;
		String[] text4000 = new String[4000];
		int[][] read4000Int = new int[4000][4];
		try {

			br = new BufferedReader(new FileReader(file));
			int i = 0;
			String input;
			while ((input = br.readLine()) != null) {
				text4000[i] = input;
				i++;
			}
			for (int j = 0; j < 4000; j++) {
				String[] temp = text4000[j].split(" ");
				int sum = 0;
				for (String s : temp) {
					sum = sum + Integer.valueOf(s);
				}
				read4000Int[j][0] = Integer.valueOf(temp[0]);
				read4000Int[j][1] = Integer.valueOf(temp[1]);
				read4000Int[j][2] = Integer.valueOf(temp[2]);
				read4000Int[j][3] = sum;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return read4000Int;
	}
}
