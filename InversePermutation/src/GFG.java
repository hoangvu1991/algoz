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

    public static int[] inversr(int[] a) {
        int N = a.length;
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[a[i] - 1] = i + 1;
        }
        return b;
    }

    // Driver program to test above function 


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 0, 1, 8, 7, 5, 6};
        int size = arr.length;
        int[] b = inversePermutation(arr, size);
        for (int x : b) {
            System.out.print(x + " ");
        }

        System.out.println();

        int[] a = {8, 1, 3, 7, 6, 2, 9, 4, 5};
        int[] inversr = inversr(a);
        for (int x : inversr) {
            System.out.print(x + " ");
        }
    }
}

/*
2, 3, 4, 0, 1  |  a[b[0]] = a[3] = 0, a[b[1]] = a[4] = 1
3, 4, 0, 1, 2  |  b[a[0]] = b[2] = 0, b[a[1]] = b[3] = 1
* */
/*
8, 1, 3, 7, 6, 2, 9, 4, 5 | a[b[1]] = a[2] = 1, a[b[2]] = a[6] = 2
2, 6, 3, 8, 9, 5, 4, 1, 7
* */