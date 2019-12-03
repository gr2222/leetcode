import java.sql.*;
import java.util.Date;

class Bingfa {
    private static final String DRIBER =  "jdbc:mysql://127.0.0.1:3306/seckill";
    private static final String USER =  "root";
    private static final String PASSWORD =  "123456";
    private static Connection connection;
    private static Connection connection2;
    private static Connection connection3;

    static {
//加载MySql驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DRIBER, USER, PASSWORD);
            connection2 = DriverManager.getConnection(DRIBER, USER, PASSWORD);
            connection3 = DriverManager.getConnection(DRIBER, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Bingfa bingfa = new Bingfa();
        bingfa.diao();
    }
    public void diao() throws InterruptedException {
        Tin1 tin1 = new Tin1();
        Tin2 tin2 = new Tin2();
        Tin3 tin3 = new Tin3();
        long showtime1a = showtime();
        tin1.start();
        tin2.start();
        tin3.start();
        tin1.join();
        tin2.join();
        tin3.join();
        long showtime2b = showtime();

        System.out.println("开始-结束:" + (showtime2b - showtime1a));
    }
    class Tin1 extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 2000; i++) {
                count(connection);
            }
        }
    }
    class Tin2 extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 2000; i++) {
                count(connection2);
            }
        }
    }
    class Tin3 extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 2000; i++) {
                count(connection3);
            }
        }
    }

    public void count(Connection connection){
        String sql ="update seckill set number = number - 1 where seckill_id = ? and start_time <= ? and end_time >= ? and number >0";
        PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
            ptmt.setInt(1, 1009);
            Date date1 = new Date();
            java.sql.Date date = new java.sql.Date(date1.getTime());
            ptmt.setDate(2, date);
            ptmt.setDate(3, date);
            boolean execute = ptmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                ptmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static long showtime(){
        //获取当前系统时间
        long l = System.currentTimeMillis();
        return l;
    }

}

