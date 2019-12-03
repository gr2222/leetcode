package paixu;

public class XuanZe {
    public static void main(String[] args) {
        int[] arr = Util.getnuns();
        long showtime = Util.showtime();
        xuanze(arr);
        long showtime1 = Util.showtime();
        System.out.println(showtime1-showtime);
    }

    public static int[] xuanze(int[] arr) {
        int minnun;
        int min;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            minnun = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minnun = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minnun];
            arr[minnun] = temp;
        }
        return arr;
    }
}
