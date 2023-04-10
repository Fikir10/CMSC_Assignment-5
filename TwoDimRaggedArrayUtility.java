/**
 * @author Fikir Seifu
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *A utility class that will calculate holiday bonuses given a ragged array of doubles representing
 * the sales for each store in each category. 
 */
public class TwoDimRaggedArrayUtility {
	/**
	 * Gets a file filled with data/numbers, puts the numbers into an array
	 * @param file
	 * @return array
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException{
		int row=0;
		Scanner scan=new Scanner(file);
		while(scan.hasNextLine()) {
			row++;
			scan.nextLine();
		}
		scan.close();
		double[][] array=new double[row][];
		Scanner scan2=new Scanner(file);
		for(int i=0;i<array.length;i++) {
			String str=scan2.nextLine();
			String[] split =str.split(" ");
			array[i]=new double[split.length];
			for(int j=0;j<array[i].length;j++) {
				array[i][j]=Double.valueOf(split[j]);
			}
		}
		scan2.close();
		return array;
	}
	/**
	 * Gets the array and writes the numbers to a given file
	 * @param data
	 * @param outputFile
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException{
		PrintWriter write=new PrintWriter(outputFile);
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				write.print(data[i][j]);
				write.print(" ");
			}
			write.print("\n");
		}
		write.close();
	}
	/**
	 * Calculates the total of all the numbers in the ragged array
	 * @param data
	 * @return total
	 */
	public static double getTotal(double[][] data){
		double total=0.0;
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				total+=data[i][j];
			}
	 }
		return total;
	}
	/**
	 * Calculates the average of all the numbers in the ragged array 
	 * @param data
	 * @return average
	 */
	public static double getAverage(double[][] data){
		double tracker=0;
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				tracker++;
			}
		}
		double average=getTotal(data)/tracker;
		return average;
	}
	/**
	 * Calculates the total for a row in the ragged array
	 * @param data
	 * @param row
	 * @return rowTotal
	 */
	public static double getRowTotal(double[][] data, int row){
		double rowTotal=0;
		for(int i=0;i<data[row].length;i++) {
			rowTotal+=data[row][i];
		}
		return rowTotal;
	}
	/**
	 * Calculates the total for a column in the ragged array
	 * @param data
	 * @param col
	 * @return colTotal
	 */
	public static double getColumnTotal(double[][] data, int col){
		double colTotal=0;
		int i=0;
		while(i<data.length) {
			if(data[i].length>col) {
				colTotal+=data[i][col];
			}
			i++;
		}
		return colTotal;
	}
	/**
	 * Finds the highest value in a given row
	 * @param data
	 * @param row
	 * @return highestInRow
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highestInRow=data[row][0];
		for(int i=1;i<data[row].length;i++) {
			if(data[row][i]>highestInRow) {
				highestInRow=data[row][i];
			}
		}
		return highestInRow;
	}
	/**
	 * Finds the index of the highest value in a given row
	 * @param data
	 * @param row
	 * @return index
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double max=data[row][0];
		int index=0;
		for(int col = 0; col < data[row].length; col++) {
			if (data[row][col] > max) { 
				max = data[row][col];
				index = col; 
			}
		}
		return index;
	}
	/**
	 * Finds the lowest value in a given row
	 * @param data
	 * @param row
	 * @return lowestInRow
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowestInRow=data[row][0];
		for(int i=0;i<data[row].length;i++) {
			if(data[row][i]<lowestInRow) {
				lowestInRow=data[row][i];
			}
		}
		return lowestInRow;
	}
	/**
	 * Finds the index of the lowest value in a given row
	 * @param data
	 * @param row
	 * @return index
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double min=data[row][0];
		int index=0;
		for(int col = 0; col < data[row].length; col++) {
			if (data[row][col] < min) { 
				min = data[row][col];
				index = col; 
			}
		}
		return index;
	}
	/**
	 * Finds the highest value in a given column
	 * @param data
	 * @param col
	 * @return highestInCol
	 */
	public static double getHighestInColumn(double[][] data,int col) {
		double highestInCol=0;
		int i=0;
		while(highestInCol==0) {
			if(data[i].length>col){
				highestInCol=data[i][col];
			}
			i++;
		}
		while(i<data.length) {
			if(data[i].length>col) {
				if(data[i][col]>highestInCol) {
					highestInCol=data[i][col];
				}
			}
			i++;
		}
		return highestInCol;
	}
	/**
	 * Finds the index of the highest value in a given column
	 * @param data
	 * @param col
	 * @return i
	 */
	public static int getHighestInColumnIndex(double [][] data, int col) {
		double highestColIndex=0;
		int i=0,row=0;
		while(highestColIndex==0) {
			if(data[row].length>col) {
				highestColIndex=data[row][col];
				i=row;
			}
			row++;
		}
		while(row<data.length) {
			if(data[row].length>col) {
				if(data[row][col]>highestColIndex) {
					highestColIndex=data[row][col];
					i=row;
				}
			}
			row++;
		}
		return i;
	}
	/**
	 * Finds the lowest value in a given column
	 * @param data
	 * @param col
	 * @return lowestInCol
	 */
	public static double getLowestInColumn(double[][] data,int col) {
		double lowestInCol=0;
		int i=0;
		while(lowestInCol==0) {
			if(data[i].length>col) {
				lowestInCol=data[i][col];
			}
			i++;
		}
		while(i<data.length) {
			if(data[i].length>col) {
			if(data[i][col]<lowestInCol) {
				lowestInCol=data[i][col];
			}
		}
		i++;
	   }
		return lowestInCol;
	}
	/**
	 * Finds the index of the lowest value in a given column
	 * @param data
	 * @param col
	 * @return
	 */
	public static int getLowestInColumnIndex(double[][] data,int col ) {
		double lowestColIndex=0;
		int row=0,i=0;
		while(lowestColIndex==0) {
			if(data[row].length>col) {
				lowestColIndex=data[row][col];
				i=row;
			}
			row++;
		}
		while(row<data.length) {
			if(data[row].length>col) {
				if(data[row][col]<lowestColIndex) {
					lowestColIndex=data[row][col];
					i=row;
				}
			}
			row++;
		}
		return i;
	}
	/**
	 * Finds the highest value in the given array
	 * @param data
	 * @return highestInArray
	 */
	public static double getHighestInArray(double[][] data) {
		double highestInArray=data[0][0];
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				if(data[i][j]>highestInArray) {
					highestInArray=data[i][j];
				}
			}
		}
		return highestInArray;
	}
	/**
	 * Finds the lowest value in the given array
	 * @param data
	 * @return lowestInArray
	 */
	public static double getLowestInArray(double[][] data) {
		double lowestInArray=data[0][0];
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				if(data[i][j]<lowestInArray) {
					lowestInArray=data[i][j];
				}
			}
		}
		return lowestInArray;
	}
}
