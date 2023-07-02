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
import models.CheckOut;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repositories.CheckOutRepository;
import static services.Utilities.sdfDateTime;

/**
 *
 * @author DELL
 */
public class CheckOutService {

    public static void readExcel(String EXCEL_FILE_PATH) throws FileNotFoundException, IOException, ParseException, SQLException {
//        String EXCEL_FILE_PATH = "C:\\Users\\acer\\Downloads\\1.xlsx";
        FileInputStream file = new FileInputStream(new File(EXCEL_FILE_PATH));
        CheckOutRepository cor = new CheckOutRepository();
        Date time = null;
        int userID = 0;
        List<CheckOut> list = new ArrayList<>();

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);

        FormulaEvaluator fmEval = wb.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet) {
//            CheckOut CheckOut = new CheckOut();
            for (Cell cell : row) {

                switch (fmEval.evaluateInCell(cell).getCellTypeEnum()) {
                    case NUMERIC: {
                        if (DateUtil.isCellDateFormatted(cell)) {
                            String dateTime = sdfDateTime.format(cell.getDateCellValue());
                            time = sdfDateTime.parse(dateTime);
//                            CheckOut.setCheckOutTime(time);

                        }
                        if (!DateUtil.isCellDateFormatted(cell)) {
                            userID = (int) cell.getNumericCellValue();
//                            CheckOut.setUserID(userID);
                        }
                        break;
                    }
                    default: {
                        System.out.println("");
                        break;
                    }
                }
            }

            CheckOut CheckOut = new CheckOut(time, userID);
            list.add(CheckOut);
            cor.create(CheckOut);

            for (CheckOut d : list) {
                System.out.println(d.getUserID() + " - " + d.getCheckOutTime());
            }
        }
    }
}
