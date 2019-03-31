/* Longest Plateau.  A plateau is a level stretch _above_ the surrounding environment.  
In an array, find the longest run of the same number that is greater than the numbers 
immediately preceding and following it.  For example, 
in the sequence 3-2-2-2-1-3-4-4-1, 2-2-2 is *not* a plateau, because 2 is less than 3.  
4-4 is the longest plateau in that sequence, because 4 is greater than 3 and greater than 1.*/

public class longestPlateau {
    public static void main(String[] args) {
        int N = 100;    // length of array
        int M = 5;        // range of random numbers
        int counter = 0;
        int highCount = 0;
        int bestStart = 0;

        // create an array of N items from the set of numbers from 1 through M
        // I used a small M to increase the chances of long runs
        int a[] = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = (int) (Math.random() * M) + 1;  // note +1.  we want 1-5, not 0-4.
        }
        int i = 1;  // begin at 1 because you'll be looking back to i-1, so
        // beginning at 0 will give an error
        while (i < (N - 2))  //  you'll be looking ahead to i+2, so stop at N-2
        {
            // note the scope in what follows.  while i is less than N-2, check for a run.  if there's a run, count its
            // length and check if it's a plateau.  if there's no run, reset the counter and increment i.
            // check whether you have a run of the same number
            if (a[i] == a[i + 1]) {
                ++counter;  // if you have a run, increment the counter. the counter counts the
                // length of a run

                // two major tests are here: is this run longer than other runs have been, and
                // is this really a plateau?  each longest run will overwrite highCount, but only if
                // the last member of the run is greater than the number after it, and the first
                // member of the run is greater than the number before it. Because counter is
                // counting the length of the run, I can use it to find the beginning
                // of the run.

                if ((counter > highCount) && (a[i + 1] > a[i + 2]) && (a[i - (counter - 1)] > a[i - counter])) {
                    highCount = counter;
                    bestStart = i - (counter - 1);  // find the beginning of the run.  note that counter
                    // starts at zero, so a run of two 1-2-2-1 will set
                    // the counter to 1.
                }
            } else {
                counter = 0;  // if there's no run, reset the counter
            }
            ++i;  // try the next number in the series
        }
		/* print the array (if you want to check it yourself) and note the longest plateau.
		because of zero-based indexing, add 1 to highCount to match the beginning of 
		the run to the index.
		also note that this program finds the first longest run in the array. */

        for (i = 0; i < N; ++i) {
            System.out.println(i + "\t" + a[i]);
        }
        System.out.println("You have a long plateau of " + (highCount + 1) + " beginning at index " + bestStart);
    }
}