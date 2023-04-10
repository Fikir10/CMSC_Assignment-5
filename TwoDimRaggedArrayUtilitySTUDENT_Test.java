import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
		private double[][] dataSetSTUDENT = {{1,2,3,4},{5,6,7,8,9},{10,9,8,7},{6,5,4,3,2,1}};
		
		private File inputFile,outputFile;

		@Before
		public void setUp() throws Exception {
			outputFile = new File("TestOut.txt");
		}

		@After
		public void tearDown() throws Exception {
			dataSetSTUDENT = null;
			inputFile = outputFile = null;
		}

		/**
		 * Student Test getTotal method
		 * Return the total of all the elements in the two dimensional array
		 */
		@Test
		public void testGetTotal() {
			double total=TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT);
			assertEquals(100.0,total,0.001);
		}

		/**
		 * Student Test getAverage method
		 * Return the average of all the elements in the two dimensional array
		 */
		@Test
		public void testGetAverage() {
			double average=TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT);
			assertEquals(5.263,average,0.001);
		}

		/**
		 * Student Test getRowTotal method
		 * Return the total of all the elements of the row.
		 * Row 0 refers to the first row in the two dimensional array
		 */
		@Test
		public void testGetRowTotal() {
			double row0=TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 0);
			assertEquals(10.0,row0,0.001);
			double row1=TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 1);
			assertEquals(35.0,row1,0.001);
			double row2=TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 2);
			assertEquals(34.0,row2,0.001);
			double row3=TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 3);
			assertEquals(21.0,row3,0.001);
		}


		/**
		 * Student Test getColumnTotal method
		 * Return the total of all the elements in the column. If a row in the two dimensional array
		 * doesn't have this column index, it is not an error, it doesn't participate in this method.
		 * Column 0 refers to the first column in the two dimensional array
		 */
		@Test
		public void testGetColumnTotal() {
			double col0=TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 0);
			assertEquals(22.0,col0,0.001);
			double col1=TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 1);
			assertEquals(22.0,col1,0.001);
			double col2=TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 2);
			assertEquals(22.0,col2,0.001);
			double col3=TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 3);
			assertEquals(22.0,col3,0.001);
			double col4=TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 4);
			assertEquals(11.0,col4,0.001);
			double col5=TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 5);
			assertEquals(1.0,col5,0.001);
		}


		/**
		 * Student Test getHighestInArray method
		 * Return the largest of all the elements in the two dimensional array.
		 */
		@Test
		public void testGetHighestInArray() {
			double highestArray=TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT);
			assertEquals(10.0,highestArray,0.001);
		}
		

		/**
		 * Test the writeToFile method
		 * write the array to the outputFile File
		 * then read it back to make sure formatted correctly to read
		 * @throws FileNotFoundException 
		 * 
		 */
		@Test
		public void testWriteToFile() throws FileNotFoundException {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
			double[][] array=TwoDimRaggedArrayUtility.readFile(outputFile);
			assertEquals(dataSetSTUDENT[0][0], array[0][0], 0.001);
			assertEquals(dataSetSTUDENT[0][1], array[0][1], 0.001);
			assertEquals(dataSetSTUDENT[0][2], array[0][2], 0.001);
			assertEquals(dataSetSTUDENT[0][3], array[0][3], 0.001);

			assertEquals(dataSetSTUDENT[1][0], array[1][0], 0.001);
			assertEquals(dataSetSTUDENT[1][1], array[1][1], 0.001);
			assertEquals(dataSetSTUDENT[1][2], array[1][2], 0.001);
			assertEquals(dataSetSTUDENT[1][3], array[1][3], 0.001);
			assertEquals(dataSetSTUDENT[1][4], array[1][4], 0.001);

			assertEquals(dataSetSTUDENT[2][0], array[2][0], 0.001);
			assertEquals(dataSetSTUDENT[2][1], array[2][1], 0.001);
			assertEquals(dataSetSTUDENT[2][2], array[2][2], 0.001);
			assertEquals(dataSetSTUDENT[2][3], array[2][3], 0.001);

			assertEquals(dataSetSTUDENT[3][0], array[3][0], 0.001);
			assertEquals(dataSetSTUDENT[3][1], array[3][1], 0.001);
			assertEquals(dataSetSTUDENT[3][2], array[3][2], 0.001);
			assertEquals(dataSetSTUDENT[3][3], array[3][3], 0.001);
			assertEquals(dataSetSTUDENT[3][4], array[3][4], 0.001);
			assertEquals(dataSetSTUDENT[3][5], array[3][5], 0.001);
		}

}
