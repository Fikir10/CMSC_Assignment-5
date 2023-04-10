/**
 * @author Fikir Seifu
 */
public class HolidayBonus {
	public static double[] calculateHolidayBonus(double[][] data,double high,double low,double other) {
		double[] holidayBonus = new double[data.length];
        // find max # of columns
        int maxColNum = 0;
        for (int i = 0; i < data.length; i++) {
            if (maxColNum < data[i].length) {
                maxColNum = data[i].length;
           }
        }
        for (int j = 0; j < maxColNum; j++) {
            // add bonus to high or low in each column
            int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
            int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);

            // if sales is positive, add bonus to high 
            if (TwoDimRaggedArrayUtility.getHighestInColumn(data, j) > 0) {
            	holidayBonus[highIndex] += high;
            }

            // if sales doesn't equal high and is positive, add bonus to low 
            if (highIndex != lowIndex && TwoDimRaggedArrayUtility.getLowestInColumn(data, j) > 0 ) {
            	holidayBonus[lowIndex] += low;
            }

            // add the other bonuses to the other stores if sales are positive
            for (int i = 0; i < data.length; i++) {
                if (i == highIndex || i == lowIndex || j >= data[i].length || data[i][j] <= 0) {
                    continue;
                } else {
                	holidayBonus[i] += other;
                }
            }
        }
        return holidayBonus;		
	}
	public static double calculateTotalHolidayBonus(double[][] data,double high,double low,double other) {
		double total=0;
		double[] holidayBonus=HolidayBonus.calculateHolidayBonus(data,high,low,other);
		for(int i=0;i<holidayBonus.length;i++) {
			total+=holidayBonus[i];
		}
		return total;
	}
	
}
