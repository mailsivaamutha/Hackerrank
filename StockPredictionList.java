package vanhack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StockPredictionList {
	public static void main(String args[]){
		List<Integer> stockData   = new ArrayList<Integer>(Arrays.asList(89214, 26671, 75144, 32445, 13656, 66289, 21951, 10265, 59857, 59133, 63227, 86121, 37411, 54628, 25859, 43510, 63756, 54763, 30852, 53243, 76238, 96885, 33074, 17745, 81814, 43436, 79172, 92819, 30001, 68442, 
				54021, 35566, 95113, 29164, 84362, 25120, 11804, 6313, 51736, 71661, 81797, 14962, 57781, 35560, 85941, 99991, 
				95421, 66048, 54754, 26272, 35642, 47343, 39508, 85068, 65087, 21321, 28503, 60611, 30491, 58503, 29052, 84512, 94069, 40516, 13675, 78430, 65635, 25479, 1094, 17370, 13491, 99243, 48683, 71271, 34802, 34624, 87613, 
				46574, 671, 42366, 89197, 36313, 89708, 28704, 21380, 54795, 66376, 49882, 15405, 96867, 24737, 60808, 81378, 
				35157, 1324, 11404, 29938, 66958, 53234, 47384));
		List<Integer> queries = new ArrayList<Integer>(Arrays.asList(80, 24, 26, 62, 46, 79, 85, 59, 52, 8, 76, 48, 72, 84, 3, 3, 30, 30, 36, 86, 96, 72, 93, 25, 28, 68, 81, 18, 78, 14, 1, 57, 90, 
				26, 18, 87, 56, 55, 97, 59, 62, 73, 58, 85, 8, 60, 87, 89, 89, 22));
		
		List<Integer> predictList = new ArrayList<Integer>();
		int samllestStockPrice = Collections.min(stockData);
		int queryDayStockPrice = 0;
		
		System.out.println("samllestStockPrice:"+samllestStockPrice);
		for(int i=0; i<queries.size(); i++){
			int headMin = 0;
			int tailMin = 0;
			int headMinDay = 0;
			int tailMinDay = 0;
			int day = queries.get(i);
			int nearHeadDay = 0;
			int nearTailDay = 0;
			queryDayStockPrice = stockData.get(day-1);
			if(queryDayStockPrice == samllestStockPrice)
				predictList.add(-1);
			else{
				System.out.println("else"+i);
				for(int j=day-2; j>=0; j--){
					if(stockData.get(j) < queryDayStockPrice){
						headMin = stockData.get(j);
						headMinDay = j+1;
						break;
					}
				}
				for(int j=day; j<stockData.size(); j++){
					if(stockData.get(j) < queryDayStockPrice){
						tailMin = stockData.get(j);
						tailMinDay = j+1;
						break;
					}
				}
				if(headMinDay == 0)
					predictList.add(tailMinDay);
				else if(tailMinDay == 0)
					predictList.add(headMinDay);
				else {
					nearHeadDay = day - headMinDay;
					nearTailDay = tailMinDay - day;
					if(nearHeadDay == nearTailDay)
					{
						if(headMinDay == Math.min(headMinDay, tailMinDay))
						{
							predictList.add(headMinDay);
						}
						else
						{
							predictList.add(tailMinDay);
						}
					}
					else{
						if(nearHeadDay < nearTailDay)
							predictList.add(headMinDay);
						else
							predictList.add(tailMinDay);
					}
				}
			}

		}
	}
}
