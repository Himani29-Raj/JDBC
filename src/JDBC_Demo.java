
import java.sql.*;

public class JDBC_Demo {
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sys";
        String uname = "root";
        String password = "Himani@2911";
        ResultSet resultSet = null;
        Connection con = null;
        String query = "select * from employee";
        String insertQuery = ("insert into employee(id,name,address)" + "values('12','Vaibhavi','Delhi')," +
                "('13','Vertika','Bombay'),('14','Saksham','Banglore')");
        String insertQuery1 = "UPDATE employee " +
                "SET name='Ritu',address='Noida' WHERE id = 2";
        try {
            con = DriverManager.getConnection(url, uname, password);
            Statement st = con.createStatement();
//            int count = st.executeUpdate("insert into employee(id,name,address) " +
//                    "values('10','Akansha','China'),('11','Rupali','America')");
//            int count = st.executeUpdate(insertQuery);
//            System.out.println("No.of rows affected = " + count);
            int numRows = st.executeUpdate(insertQuery1);
            System.out.println("No of rows affected = " + numRows);
//            resultSet = st.executeQuery(query);
//            while (resultSet.next()){
//                System.out.println("Employee Id : " + resultSet.getInt(1));
//                System.out.println("Employee Naame : " + resultSet.getString(2));
//                System.out.println("Employee Address : " + resultSet.getString(3));
//            boolean execute = st.execute(query);
//            if (execute) {
//                ResultSet resultSet1 = st.getResultSet();
//                while (resultSet1.next()) {
//                    System.out.println(resultSet1.getString(2));
//                }
//            }
//            }
        }
        finally {
            if(resultSet != null)
                resultSet.close();
            if(con != null)
                con.close();
        }
    }
}
