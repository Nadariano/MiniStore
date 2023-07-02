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
import models.Report;
import models.ShiftTime;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repositories.CheckOutRepository;
import repositories.ReportRepository;
import repositories.ShiftTimeRepository;
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

    public static Date minOutTime(ShiftTime st, Report report, Date date) throws ParseException {
        String strDate = Utilities.sdfDate.format(date);
        String strEndTime = Utilities.sdfTime.format(st.getTimeEnd());
        Date endTime = Utilities.sdfDateTime.parse(strDate + " " + strEndTime);

        long requestSoon = 0;
        if (report != null) {
            requestSoon = report.getRequestSoonTime().getTime() - Utilities.correctTime().getTime();
        }

        long limit = endTime.getTime() - requestSoon - Utilities.limit1h();
        Date limitTime = new Date(limit);
        System.out.println(limitTime);
        return limitTime;
    }

    public static Date maxOutTime(ShiftTime st, Date date) throws ParseException {
        String strDate = Utilities.sdfDate.format(date);
        String strEndTime = Utilities.sdfTime.format(st.getTimeEnd());
        Date endTime = Utilities.sdfDateTime.parse(strDate + " " + strEndTime);

        long max = endTime.getTime() + Utilities.limit30m();
        Date maxTime = new Date(max);
        return maxTime;
    }

    public static Date maxOutTimeNight(ShiftTime st, Date date) throws ParseException {
        String strDate = Utilities.sdfDate.format(date);
        String strEndTime = Utilities.sdfTime.format(st.getTimeEnd());
        Date endTime = Utilities.sdfDateTime.parse(strDate + " " + strEndTime);

        long max = endTime.getTime() + Utilities.limit24h() + Utilities.limit30m();
        Date maxTime = new Date(max);
        return maxTime;
    }

    public static Report requestTime(Date date, int userID) throws SQLException {
        ReportRepository rr = new ReportRepository();
        Report report = null;
        if (rr.readDate(date, userID) != null) {
            report = rr.readDate(date, userID);
        }
        return report;
    }

    public static CheckOut outTime(int userID, int shiftID, Date date) throws ParseException, SQLException {

        ShiftTimeRepository str = new ShiftTimeRepository();
        CheckOutRepository cor = new CheckOutRepository();
        ShiftTime st = str.read(shiftID);
        Report report = requestTime(date, userID);

        Date minOutTime = minOutTime(st, report, date);
        Date maxOutTime = null;

        if (st.getShiftName().equalsIgnoreCase("Night Shift")) {
            maxOutTime = maxOutTimeNight(st, date);
        } else {
            maxOutTime = maxOutTime(st, date);
        }

        List<CheckOut> coList = cor.search(minOutTime, maxOutTime, userID);
        CheckOut co = null;

        if (coList.isEmpty()) {
            co = new CheckOut();
        } else {
            co = coList.get(0);
        }
        return co;
    }

}
