/**
 * @author Fikir Seifu
 */
import static org.junit.Assert.*;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class HolidayBonusTestSTUDENT {
	private double[][] testArray = {{-42.5,78,55,6,89},{50,10,45.5,-2,12,66},{17,7.2,3,89,102,65},
									{21.1,-76,11,7,90},{19.8,44,54,32,59,23}};

	@Before
	public void setUp() throws Exception {
	} 

	@After
	public void tearDown() throws Exception {
	}
		/**
		 * Test calculateHolidayBonus method with a high of 5000, low of 1000 and 2000 as other
		 */

		@Test
		public void testCalculateHolidayBonus() {
			double[] holidayBonus = HolidayBonus.calculateHolidayBonus(testArray,5000,1000,2000);
			assertEquals(14000.0,holidayBonus[0],.001);
			assertEquals(15000.0,holidayBonus[1],.001);
			assertEquals(17000.0,holidayBonus[2],.001);
			assertEquals(8000.0,holidayBonus[3],.001);
			assertEquals(11000.0,holidayBonus[4],.001);
		}

		/**
		 * Test calculateTotalHolidayBonus method with a high of 5000, low of 1000 and 2000 as other
		 */
	@Test
	public void testCalculateTotalHolidayBonus() {
		assertEquals(65000.0,HolidayBonus.calculateTotalHolidayBonus(testArray, 5000, 1000, 2000),.001);

	}
}