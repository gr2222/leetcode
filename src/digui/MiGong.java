package digui;

public class MiGong {
    static int sun = 0;
    static int qidian_x = 1;
    static int qidian_y = 1;
    public static void main(String[] args) {
        int[][] arr = new int[8][7];
        for (int i = 0; i < 8; i++) {
            if (i < 7) {
                arr[0][i] = 1;
                arr[7][i] = 1;
            }
            arr[i][0] = 1;
            arr[i][6] = 1;
        }
        arr[5][1] = 1;
        arr[5][2] = 1;
        arr[4][2] = 1;
        arr[3][2] = 1;
        arr[2][2] = 1;
        show(arr);
        minxunlu(arr);

    }
    public static void minxunlu(int[][] arr){

        int[] jishu = {2, 6, 8, 4};
        int[] z = new int[4];
        int sumnun = 100000;
        int[][] arrsun = null;
        int[][] arrc;


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        if (jishu[i] == jishu[j] || jishu[i] == jishu[k] || jishu[i] == jishu[l] || jishu[j] == jishu[k] || jishu[j] == jishu[l] || jishu[k] == jishu[l]) {
                        } else {
                            z[0] = jishu[i];
                            z[1] = jishu[j];
                            z[2] = jishu[k];
                            z[3] = jishu[l];
                            arrc = clne(arr);
                            sun = 0;
                            xunlu(arrc, qidian_x, qidian_y, z);
                            System.out.println("--------------------");
                            System.out.println(z[0] + " " + z[1] + " " + z[2] + " " + z[3]);
                            System.out.println(sun);
                            show(arrc);
                            System.out.println("*********************");
                            if (sumnun > sun) {
                                sumnun = sun;
                                arrsun = clne(arrc);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("######################");
        System.out.println("最短路径");
        System.out.println(sumnun);
        show(arrsun);
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

    public static boolean xunlu(int[][] arr, int x, int y, int[] z) {
        if (arr[6][5] == 2) {
            return true;
        } else {
            if (arr[x][y] == 1 || arr[x][y] == 2 || arr[x][y] == 3) {
                return false;
            } else {
                arr[x][y] = 2;
                sun++;
                if (xunlu(arr, fangshiX(x, z[0]), fangshiY(y, z[0]), z)) {
                    return true;
                } else if (xunlu(arr, fangshiX(x, z[1]), fangshiY(y, z[1]), z)) {
                    return true;
                } else if (xunlu(arr, fangshiX(x, z[2]), fangshiY(y, z[2]), z)) {
                    return true;
                } else if (xunlu(arr, fangshiX(x, z[3]), fangshiY(y, z[3]), z)) {
                    return true;
                } else {
                    arr[x][y] = 3;
                    sun--;
                    return false;
                }
            }
        }
    }

    public static int fangshiX(int x, int z) {
        switch (z) {
            case 8:
                return x - 1;
            case 2:
                return x + 1;
            case 4:
                return x;
            case 6:
                return x;
            default:
                return 0;
        }
    }

    public static int fangshiY(int y, int z) {
        switch (z) {
            case 4:
                return y - 1;
            case 6:
                return y + 1;
            case 8:
                return y;
            case 2:
                return y;
            default:
                return 0;
        }
    }

    public static void show(int[][] arr) {
        System.out.println("地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
