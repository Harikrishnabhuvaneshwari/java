package org.learn;

class GFG {
	
	static int subarray(int arr[], int n, int sum)  
    {  
		int currentsum = arr[0], begin = 0, i;

		// Always start with the initial index of an array
		for (i = 1; i <= n; i++) {
			// If currentsum exceeds the sum,
			// then remove the starting elements
			while (currentsum > sum && begin < i - 1) {
				currentsum = currentsum - arr[begin];
				begin++;
			}

			// If currentsum becomes equal to sum,
			// then return true
			if (currentsum == sum) {
				int p = i - 1;
				System.out.println("Sum found between indexes " + begin + " and " + p);
				return 1;
			}

			// Add this element to currentsum
			if (i < n)
				currentsum = currentsum + arr[i];
		}

		System.out.println("No subarray found");
		return 0;
	}

	public static void main(String args[]) {
		
		System.out.println(1>1);
		
	}
}
