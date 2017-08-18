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

		//int[] testArray = new int[]{1,9,4,2,7,0,3,4};

		//twoSumProblemHashSet(testArray, 5);

		//twoSumProblemHashMap(testArray, 5);

		//String s = "ba";
		//System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));


		//Matrix question food category and preference
		String[][] foodCategory={{"Pizza","Italian"},{"Pasta","Italian"},{"Nachos","Mexican"}};
		String[][] memberCategory={{"Nicolas","Italian"},{"Raul","Mexican"},{"Henri","*"}};

		for(String[] outprint :matrixReverseMix(foodCategory,memberCategory))
		{
			System.out.println(Arrays.toString(outprint));
		}


	}

	//HashSet
	static void twoSumProblemHashSet(int[] A, int s) {
		HashSet<Integer> h = new HashSet<Integer>();
		int i = 0;
		while(i < A.length) {
			if(h.contains(s-A[i])) {
				System.out.println(A[i]+","+(s-A[i]));
			}
			h.add(A[i++]);
		}
	}

	//HashMap
	static void twoSumProblemHashMap(int[] A, int s) {
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		int i = 0;
		while(i < A.length) {
			if(h.containsKey(s-A[i])) {
				System.out.println(A[i]+","+(s-A[i])+" index pair:"+ i +","+ h.get(s-A[i]));
			}
			h.put(A[i],i);
			i++;
		}
	}


	//Permutation algorithm
	public static Set<String> permutationFinder(String str) {
		Set<String> perm = new HashSet<String>();

		//Recursion exit condition
		if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // rest of the string
		Set<String> words = permutationFinder(rem);
		for (String strNew : words) {
			perm.add( initial + strNew );
			perm.add( strNew + initial );
		}
		return perm;
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
