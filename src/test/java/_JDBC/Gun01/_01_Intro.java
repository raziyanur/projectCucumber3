package _JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void test1() throws SQLException {
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; //hotstname,port,db adını (user db)
        String username="root"; //username
        String password="'\"-LhCB'.%k[4S]z"; // password

        Connection connection= DriverManager.getConnection(url,username,password); //Connection

        Statement statement= connection.createStatement();// sorgulari calistirmak icin pageacildi

        ResultSet rs = statement.executeQuery("select *  from actor");
        rs.next();

        String firstName= rs.getNString("first_name");
        String lastName= rs.getNString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        // 2.satir
        rs.next();

        firstName= rs.getNString("first_name");
        lastName= rs.getNString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        connection.close();
    }


}
