package telran.util;

public class Arrays {
    public static int search(int[] ar, int key) {
        int index = 0;
        while(index < ar.length && key != ar[index]) {
            index++;
        }
        return index == ar.length ? -1 : index;
    }

    public static int[] add(int [] ar, int number) {
        int [] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        res[ar.length] = number;
        return res;
    }

    public static int[] insert(int[] ar, int index, int number) {
        int [] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        res[index] = number;
        System.arraycopy (ar, index, res, index + 1, ar.length - index);
        return res; 
    }

    public static int[] remove(int[] numbers, int index) {
        int [] res = java.util.Arrays.copyOf(numbers, numbers.length - 1);
        System.arraycopy(numbers, index + 1, res, index, numbers.length - index - 1);
        return res;
    }

    public static boolean pushMaxAtEnd(int[] ar, int length) {
        boolean res = true;
        for(int i = 0; i < length; i++) {
            if(ar[i] > ar[i + 1]) {
                res = false;
                swap(ar, i, i + 1);
            }
        }
        return res;
    }

        private static void swap(int[] ar, int i, int j) {
            int tmp = ar[i];
            ar[i] = ar[j];
            ar[j] = tmp;
        }

    public static void sort(int [] ar) {
        int length = ar.length;
        boolean flSorted = false;
        while(!flSorted) {
            length--;
            flSorted = pushMaxAtEnd(ar, length);
        } 
    }

    public static int binarySearch(int [] ar, int key) {
        int start = 0;
        int finish = ar.length - 1;
        
        while (start <= finish) {
            int mid = start + (finish - start) / 2;
            
            if (ar[mid] == key) {
                return mid;
            }
            
            else if (ar[mid] > key) {
                finish = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
    

    public static int[] insertSorted(int[] arSorted, int number) {
        int start = 0;
        int finish = arSorted.length - 1;
        
        while (start <= finish) {
            int mid = start + (finish - start) / 2;
            
            if (arSorted[mid] == number) {
                return arSorted;
            }
            
            else if (arSorted[mid] > number) {
                finish = mid - 1;
            }
            
            else {
                start = mid + 1;
            }
        }
        int index = start;
        
        int [] res = java.util.Arrays.copyOf(arSorted, arSorted.length + 1);
        res[index] = number;
        System.arraycopy (arSorted, index, res, index + 1, arSorted.length - index);
        return res;
    }

    public static boolean isOneSwap(int [] array) {
        int length = array.length;
        int counter = 0;
        boolean res = true;
        
        while (res) {
            res = false;
        
            for(int i = 1; i < length; i++) {
                if(array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    counter++;
                }
                
                res = true;
                
            }
            length--;
        }
        return counter == 1;
    }
}

