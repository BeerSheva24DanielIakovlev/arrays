package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer arg0, Integer arg1) {
        return (arg0 % 2 != 0) ? ((arg1 % 2 == 0) ? 1 : arg1 - arg0) : ((arg1 % 2 == 0) ? arg0 - arg1 : 0);
    }

    /*@Override
    public int compare(Integer arg0, Integer arg1) {
        int a = 0;
        if(arg0 % 2 != 0) {
            if (arg1 % 2 == 0) {
                a = 1;
            }
            else {
                a = arg1 - arg0;
            }
        }
        else {
            if (arg1 % 2 == 0) {
                a = arg0 - arg1;
            }
        }
        return a;
    }*/

}
