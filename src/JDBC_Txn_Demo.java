import java.sql.*;
import java.util.Scanner;

public class JDBC_Txn_Demo {
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sys";
        String uname = "root";
        String password = "Himani@2911";
        Connection con = DriverManager.getConnection(url,uname,password);
        Statement st = con.createStatement();
        System.out.println("Data before transaction");
        System.out.println("----------------------------------------");
        ResultSet rs = st.executeQuery("select * from accounts");
        while (rs.next()){
            System.out.println(rs.getString(1)+ "..." + rs.getInt(2));
        }
        System.out.println("Transaction Begin");
        System.out.println("----------------------------------------");
        con.setAutoCommit(false);
        st.executeUpdate("update accounts set balance = balance-2000 where user = 'Milan'");
        st.executeUpdate("update accounts set balance = balance+2000 where user = 'Anushka'");
        System.out.println("Can you please confirm this transaction of 2000...[Yes|No]");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if(option.equalsIgnoreCase("yes")){
            con.commit();
            System.out.println("Transaction committed");
        }
        else {
            con.rollback();
            System.out.println("Transaction rollback");
        }
        System.out.println("Data After Transaction");
        ResultSet rs1 = st.executeQuery("select * from accounts");
        while (rs1.next()){
            System.out.println(rs1.getString(1) +"..." +rs1.getInt(2));
        }
        con.close();
    }
}
