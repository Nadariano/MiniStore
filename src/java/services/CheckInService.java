/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.CheckIn;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repositories.CheckInRepository;
import static services.Utilities.sdfDateTime;

/**
 *
 * @author DELL
 */
public class CheckInService {

//    public static final String EXCEL_FILE_PATH = "D:\\FPT\\1.xlsx";
//    public static int s = 0;
    public static List<CheckIn> readExcel1() throws FileNotFoundException, IOException, ParseException, SQLException {

        String EXCEL_FILE_PATH = "C:\\Users\\Pc\\Downloads\\1.xlsx";
        FileInputStream file = new FileInputStream(new File(EXCEL_FILE_PATH));

        List<CheckIn> list = new ArrayList<>();
        int userID = 0;
        Date time = null;

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);

        FormulaEvaluator fmEval = wb.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet) {
            for (Cell cell : row) {

                switch (fmEval.evaluateInCell(cell).getCellTypeEnum()) {
                    case NUMERIC: {
                        if (DateUtil.isCellDateFormatted(cell)) {
                            String dateTime = sdfDateTime.format(cell.getDateCellValue());
                            time = sdfDateTime.parse(dateTime);

                        }
                        if (!DateUtil.isCellDateFormatted(cell)) {
                            userID = (int) cell.getNumericCellValue();
                        }
                        break;
                    }
                    default: {
                        System.out.println("");
                        break;
                    }
                }
            }
            CheckIn checkIn = new CheckIn(time, userID);
            list.add(checkIn);

        }

        return list;
    }

    public static void readExcel() throws FileNotFoundException, IOException, ParseException, SQLException {
        String EXCEL_FILE_PATH = "C:\\Users\\Pc\\Downloads\\1.xlsx";
        FileInputStream file = new FileInputStream(new File(EXCEL_FILE_PATH));
        CheckInRepository cir = new CheckInRepository();
        Date time = null;
        int userID = 0;
        List<CheckIn> list = new ArrayList<>();

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);

        FormulaEvaluator fmEval = wb.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet) {
//            CheckIn CheckIn = new CheckIn();
            for (Cell cell : row) {

                switch (fmEval.evaluateInCell(cell).getCellTypeEnum()) {
                    case NUMERIC: {
                        if (DateUtil.isCellDateFormatted(cell)) {
                            String dateTime = sdfDateTime.format(cell.getDateCellValue());
                            time = sdfDateTime.parse(dateTime);
//                            CheckIn.setCheckInTime(time);

                        }
                        if (!DateUtil.isCellDateFormatted(cell)) {
                            userID = (int) cell.getNumericCellValue();
//                            CheckIn.setUserID(userID);
                        }
                        break;
                    }
                    default: {
                        System.out.println("");
                        break;
                    }
                }
            }

            CheckIn CheckIn = new CheckIn(time, userID);
            list.add(CheckIn);
//            cir.create(CheckIn);

        }
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException, SQLException {
//        CheckInRepository cir = new CheckInRepository();
        CheckInService cis = new CheckInService();
        cis.readExcel1();
    }
}
