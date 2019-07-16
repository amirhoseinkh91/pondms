package ir.viratech.pond_ms.core.db.cli.get_all_customrs_data;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.logic.CustomerMgr;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class GetAllCustomersData {
    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        try {
            List<Customer> customers = CustomerMgr.getInstance().list();
            String filename = "/opt/PondMS/Users_Information.xls";
            FileOutputStream fileOut = new FileOutputStream(filename);

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Users_Information");

            HSSFRow rowHead = sheet.createRow((short) 0);
            rowHead.createCell(0).setCellValue("No.");
            rowHead.createCell(1).setCellValue("Name");
            rowHead.createCell(2).setCellValue("Gender");
            rowHead.createCell(3).setCellValue("Email");
            rowHead.createCell(4).setCellValue("Phone Number");

            int rowNumber = 1;
            for (Customer customer : customers) {
                try {
                    HSSFRow row = sheet.createRow(rowNumber);
                    row.createCell(0).setCellValue(rowNumber);
                    row.createCell(1).setCellValue(customer.getName());
                    row.createCell(2).setCellValue(customer.getGender());
                    row.createCell(3).setCellValue(customer.getEmail());
                    row.createCell(4).setCellValue(customer.getPhoneNumber());
                    rowNumber++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            workbook.write(fileOut);
            workbook.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
