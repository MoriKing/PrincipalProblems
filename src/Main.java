import java.util.*;

/**
 * 
 */

/**
 * @author cpt2mon
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		

		//Matrix question food category and preference
//		String[][] foodCategory={{"Pizza","Italian"},{"Pasta","Italian"},{"Nachos","Mexican"}};
//		String[][] memberCategory={{"Nicolas","Italian"},{"Raul","Mexican"},{"Henri","*"}};
//
//		for(String[] outprint :matrixReverseMix(foodCategory,memberCategory))
//		{
//			System.out.println(Arrays.toString(outprint));
//		}


	}

	

	

	//Matrix reverse mix
	public static String[][] matrixReverseMix(String[][] menu,String[][] members) {

		HashMap<String,ArrayList<String>> HashedMenu =new HashMap<String,ArrayList<String>>();

		//Add the total category as *
		ArrayList<String> overallItem = new ArrayList<String>();
		HashedMenu.put("*", overallItem);

		//Hash the menu in reverse of Meal-->Category
		for(String[] MealInfo : menu)
		{
			if(HashedMenu.containsKey(MealInfo[1]))
			{
				HashedMenu.get(MealInfo[1]).add(MealInfo[0]);
				HashedMenu.get("*").add(MealInfo[0]);
			}
			else
			{
				ArrayList<String> newItem = new ArrayList<String>();
				newItem.add(MealInfo[0]);
				HashedMenu.put(MealInfo[1], newItem);
				HashedMenu.get("*").add(MealInfo[0]);
			}
		}

		//Generate the output from Member-->Category to Member-->Meal
		ArrayList<String[]> outputList=new ArrayList<String[]>();
		for(String[] preference : members)
		{
			for(String foodItem : HashedMenu.get(preference[1]))
			{
				outputList.add(new String[]{preference[0],foodItem});
			}
		}

		String[][] output = outputList.toArray(new String[0][0]);

		return output;
	}


	

}
