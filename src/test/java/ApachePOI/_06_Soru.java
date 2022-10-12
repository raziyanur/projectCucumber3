package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _06_Soru {
    /**
     * Bir önceki yapılan soruda, Kullanıcıya 1.sütundaki tüm değer bir liste halinde kullanıcıya
     * yanlarında bi numara olarak sunalım. Kullanıcı hangi numararyı girerese o satırın
     * yanındaki tüm bilgiler gösterilsin.
     * Username için 1
     * Password için 2
     * ....
     * ...
     * giririniz = 2
     */
    public static void main(String[] args) {
        System.out.print("sutun sayisina girin=");
        Scanner oku = new Scanner(System.in);
        String arananKelime = oku.next();

        String donenSonuc = bul(arananKelime);
        System.out.println("donenSonuc = " + donenSonuc);
    }

    public static String bul(String arananKelime) {
        String donecek = "";

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";

        Workbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0); // .getSheet("Login");

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);

            if (cell.toString().equalsIgnoreCase(arananKelime))
                for (int j = 1; j < row.getPhysicalNumberOfCells(); j++)
                    donecek += row.getCell(j) + " ";
        }

        return donecek;
    }
}
