package paixu;

public class MaoPao {
    public static void main(String[] args) {
        int[] arr = Util.getnuns();
        long showtime = Util.showtime();
        maopao(arr);
        long showtime1 = Util.showtime();
        System.out.println(showtime1-showtime);
    }
    public static int[] maopao(int[] arr) {
        int len = arr.length;
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
        return arr;
    }
}
