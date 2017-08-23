import java.util.HashMap;
import java.util.HashSet;

public class ArraySumX {

	// Given array of n integers and given a number X,
	// find all the unique pairs of elements (a,b), whose summation is equal to
	// X

	// int[] testArray = new int[]{1,9,4,2,7,0,3,4};

	// calculateWithHashset(testArray, 5);

	// calculateWithHashMap(testArray, 5);

	// HashSet
	static void calculateWithHashset(int[] A, int s) {
		HashSet<Integer> h = new HashSet<Integer>();
		int i = 0;
		while (i < A.length) {
			if (h.contains(s - A[i])) {
				System.out.println(A[i] + "," + (s - A[i]));
			}
			h.add(A[i++]);
		}
	}

	// HashMap
	static void calculateWithHashMap(int[] A, int s) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		int i = 0;
		while (i < A.length) {
			if (h.containsKey(s - A[i])) {
				System.out.println(A[i] + "," + (s - A[i]) + " index pair:" + i + "," + h.get(s - A[i]));
			}
			h.put(A[i], i);
			i++;
		}
	}

}
