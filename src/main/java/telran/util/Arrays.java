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
}
