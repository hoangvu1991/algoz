// Naive java Program to find inverse permutation.
// https://www.geeksforgeeks.org/inverse-permutation/

class GFG {

    // java function to find inverse permutations 
    static int[] inversePermutation(int[] arr, int size) {
        int i, j;
        int[] b = new int[size];
        // Loop to select Elements one by one 
        for (i = 0; i < size; i++) {
            // Loop to print position of element 
            // where we find an element 
            for (j = 0; j < size; j++) {
                // checking the element in  
                // increasing order 
                if (arr[j] == i) {
                    // print position of element 
                    // where element is in inverse 
                    // permutation
                    b[i] = j;
                    break;
                }
            }
        }
        return b;
    }

    // Driver program to test above function 


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 0, 1};
        int size = arr.length;
        int[] b = inversePermutation(arr, size);
        for (int x : b) {
            System.out.print(x + " ");
        }
    }
}

/*
2, 3, 4, 0, 1  |  a[b[0]] = a[3] = 0, a[b[1]] = a[4] = 1
3, 4, 0, 1, 2  |  b[a[0]] = b[2] = 0, b[a[1]] = b[3] = 1
* */