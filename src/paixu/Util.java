package paixu;

public class Util {
    public static long showtime(){
        //获取当前系统时间
        long l = System.currentTimeMillis();
        return l;
    }
    public static int[] getnuns(){
        int[] arr = new int[80];
        for (int i = 0; i <80 ; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        return arr;
    }
    public static int[] cloe(int[] arr){
        int[] arrc = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            arrc[i] = arr[i];
        }
        return arrc;
    }
}
