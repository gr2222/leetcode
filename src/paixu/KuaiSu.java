package paixu;

import java.time.Year;
import java.util.Arrays;

public class KuaiSu {
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        int r = arr.length - 1;
        long showtime = Util.showtime();
        kuaisu(arr, 0, r);
        long showtime1 = Util.showtime();
        System.out.println(showtime1 - showtime);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] kuaisu(int[] arr, int l, int r) {
        int zj = 0;
        zj = arr[(l+r)/2];
        int temp;
        while (r > l) {
            while (arr[l] < zj) {
                l++;
            }
            while (arr[r] > zj) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (l > 0){
                System.out.println(l);
                kuaisu(arr, 0, l);
            }
            if (r<arr.length-1){
                System.out.println(r);
                kuaisu(arr,r,arr.length-1);
            }
        }


        return arr;
    }
}
