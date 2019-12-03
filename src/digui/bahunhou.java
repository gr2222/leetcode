package digui;

public class bahunhou {
    static int[][] arrc = new int[8][8];
    static int sunnun = 0;
    static int[] rult = new int[8];

    public static void main(String[] args) {

            bahunhou(0, 1, clne(arrc));
    }

    public static boolean bahunhou(int x, int y, int[][] arr) {
        if (arr[x][y] == 1) {
            return false;
        } else {
            rult[x] = y;
            if (x == 7) {
                sunnun++;
                int[][] arrcs = clne(arr);
                System.out.println("-----------------");
                System.out.println(sunnun);
                for (int i = 0; i < 8; i++) {
                    System.out.print(rult[i]);
//                    arrcs[i][rult[i]] = 3;
                }
//                System.out.println();
//                show(arrcs);
//                System.out.println();
                System.out.println("*************");
                return false;
            }
            arr = err(x, y, arr);
            show(arr);
            if (bahunhou(x + 1, 0, arr)) {
                return true;
            } else if (bahunhou(x + 1, 1, clne(arr))) {
                return true;
            } else if (bahunhou(x + 1, 2, clne(arr))) {
                return true;
            } else if (bahunhou(x + 1, 3, clne(arr))) {
                return true;
            } else if (bahunhou(x + 1, 4, clne(arr))) {
                return true;
            } else if (bahunhou(x + 1, 5, clne(arr))) {
                return true;
            } else if (bahunhou(x + 1, 6, clne(arr))) {
                return true;
            } else if (bahunhou(x + 1, 7, clne(arr))) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static int[][] err(int x, int y, int[][] arr) {
        for (int i = 0; i < 8; i++) {
            arr[i][y] = 1;
        }
        int i = x;
        int n = y;
        int m = y;
        while (true) {
            if (i < 0) {
                break;
            } else if (n >= 0) {
                arr[i][n] = 1;
                n--;
            }
            if (m < 8) {
                arr[i][m] = 1;
                m++;
            }
            i--;
        }
        i = x;
        n = y;
        m = y;
        while (true) {
            if (i > 7) {
                break;
            } else if (n >= 0) {
                arr[i][n] = 1;
                n--;
            }
            if (m < 8) {
                arr[i][m] = 1;
                m++;
            }
            i++;
        }
        return arr;
    }

    public static int[][] clne(int[][] arr) {
        int[][] arrc = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arrc[i][j] = arr[i][j];
            }
        }
        return arrc;
    }

    public static void show(int[][] arr) {
        System.out.println("_________________");
        for (int i = 7; i > -1; i--) {
            for (int j = 0; j < 8; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
