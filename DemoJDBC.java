import java.sql.*;
public class DemoJDBC {
  public  static  void main(String[] args) throws Exception{
    /* 7 steps for JDBC
    1) IMPORT PACKAGE
    2) LOAD AND REGISTER THE DRIVER
    3) CREATE CONNECTION
    4) CREATE STATEMENT
    5) EXECUTE STATEMENT
    6) PROCESS THE RESULTS
    7) CLOSE THE CONNECTION
     */
    //DB credentials
    String url="jdbc:postgresql://localhost:5432/school_db";
    String uname="postgres";
    String pass="G258@g258";
    //String sql="select * from student_table";
    //String sql2="insert into student_table values (5,'John',48)";
   //String sql3="update student_table set sname='mark' where sid=1";
     // String sql4="delete from student_table where sid=5";
      String sql="insert into student_table values(?,?,?)";
      int sid=4;
      String sname="Mukul";
      int marks=100;
    try{
     //Load and register the driver
     Class.forName("org.postgresql.Driver");
     Connection con= DriverManager.getConnection(url,uname,pass);
    // Statement st=con.createStatement();
        //instead of statement PreparedStatement is being used which is actually interface taking the statement as main interface or parentclass/interface

     //ResultSet rs=st.executeQuery(sql2);

        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,sid);
        st.setString(2,sname);
        st.setInt(3,marks);

    boolean status=st.execute();


       /* while(rs.next()){
            System.out.print(rs.getInt(1)+"-");
            System.out.print(rs.getString(2)+"-");
            System.out.println(rs.getInt(3)+"-");
        */

     System.out.println("Connection established");
     System.out.println(status);
      /*  ResultSet rs=st.executeQuery(sql);
        rs.next();
        while(rs.next()){
            System.out.print(rs.getInt(1)+"-");
            System.out.print(rs.getString(2)+"-");
            System.out.println(rs.getInt(3)+"-");
        }
        */
     con.close();
    }catch(Exception e){
    //  System.out.println(e);
        System.err.println("❌ Connection failed!");
        e.printStackTrace();
    }
  }
}
