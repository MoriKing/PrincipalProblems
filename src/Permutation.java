import java.util.HashSet;
import java.util.Set;

public class Permutation {

	// String s = "abcd";
	// Set myset=Permutation.permutate(s);
	// System.out.println("\nPermutations for " + s + " are: \n" + myset);
	// System.out.println(myset.size());

	// Permutation algorithm
	public static Set<String> permutate(String str) {

		Set<String> perm = new HashSet<String>();

		// Recursion exit condition
		if (str.length() == 1) {
			perm.add(str);
			return perm;
		} else {
			for (int i = 0; i < str.length(); i++) {

				// first character
				char fixedCharacter = str.charAt(i); 
				// rest of the string to be permuted
				String rem = str.substring(0, i) + str.substring(i + 1); 
				Set<String> words = permutate(rem);
				for (String strNew : words) {
					perm.add(fixedCharacter + strNew);
					perm.add(strNew + fixedCharacter);
				}
			}
		}

		return perm;
	}

}
