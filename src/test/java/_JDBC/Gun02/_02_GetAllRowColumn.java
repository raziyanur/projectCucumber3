package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBCParent {
    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
// ResultSet icerisinde data+meta var, meta  o data disindaki diger cilgiler kolon sayisi vs..

        ResultSetMetaData rsmd = rs.getMetaData();
//sonuslari haricindeki diger bilgiler: colon sayisi, isimleri, tipler

        int columnCount = rsmd.getColumnCount();// kolon sayisi
        System.out.println("columnCount = " + columnCount);
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rsmd.getColumnName(i);
            String columnType = rsmd.getColumnTypeName(i);

            System.out.println(columnType + " " + columnName);
            System.out.println("columnType = " + columnType);
            System.out.println("columnName = " + columnName);


        }

    }

    @Test
    public void test2() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s", rsmd.getColumnName(i));
        //%-20s 向右对齐 隔20字符写下一个
        // % : değişkenin değerini işaret eder
        // - : sola dayalı yazdırır, default sağa dayalı
        // 20: kaç hane kullanılacak herzaman onun bilgisi
        // s : string değerler içis , sayısal değerler için d kullanılır
        // "%5.2d" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s", rs.getString(i));
            System.out.println();
        }
    }

    @Test
    public void test3() throws SQLException {
// actor tablosundaki tüm satırları ve tüm sütunları yazdırınız, aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.
        getTable("select * from actor");

    }
        public  void getTable(String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s", rsmd.getColumnName(i));
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s", rs.getString(i));
            System.out.println();
        }

    }
}