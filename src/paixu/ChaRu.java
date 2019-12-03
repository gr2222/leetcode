package paixu;

public class ChaRu {
    public static void main(String[] args) {
//        int[] arr = Util.getnuns();
//        long showtime = Util.showtime();
//        charu(arr);
//        long showtime1 = Util.showtime();
//        System.out.println(showtime1 - showtime);
//        showtime = Util.showtime();
//        shell(arr);
//        showtime1 = Util.showtime();
//        System.out.println(showtime1 - showtime);

        int[] arr = {8, 4, 2, 3, 7, 9, 10, 4};
        shell(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }

    public static int[] charu(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] shell(int[] arr) {
        int lens = arr.length;
        int temp = 0;
        for (int j = lens / 2; j > 1; j = j / 2) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + j]) {
                    temp = arr[i + j];
                    arr[i + j] = arr[i];
                    arr[i] = temp;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

        return arr;
    }
}
