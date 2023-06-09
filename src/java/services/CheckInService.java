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
import models.Report;
import models.ShiftTime;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repositories.CheckInRepository;
import repositories.ReportRepository;
import repositories.ShiftTimeRepository;
import static services.Utilities.sdfDateTime;

/**
 *
 * @author DELL
 */
public class CheckInService {

//    public static final String EXCEL_FILE_PATH = "D:\\FPT\\1.xlsx";
//    public static int s = 0;
    public static List<CheckIn> readExcel(String EXCEL_FILE_PATH) throws FileNotFoundException, IOException, ParseException, SQLException {

//        String EXCEL_FILE_PATH = "C:\\Users\\acer\\Downloads\\1.xlsx";
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

    public static Date minInTime(ShiftTime st, Date date) throws ParseException {
        String strDate = Utilities.sdfDate.format(date);
        String strStartTime = Utilities.sdfTime.format(st.getTimeStart());
        Date startTime = Utilities.sdfDateTime.parse(strDate + " " + strStartTime);
        System.out.println("lofi");
        long min = startTime.getTime() - Utilities.limit30m();
        Date minTime = new Date(min);
        return minTime;
    }

    public static Date maxInTime(ShiftTime st, Report report, Date date) throws ParseException {
        String strDate = Utilities.sdfDate.format(date);
        String strStartTime = Utilities.sdfTime.format(st.getTimeStart());
        Date startTime = Utilities.sdfDateTime.parse(strDate + " " + strStartTime);
        System.out.println("StartTime" + startTime);
        long requestLate = 0;
        if (report != null) {
            System.out.println("report" + report.toString());
            if (report.getRequestLateTime() != null) {
                
                System.out.println("LateTime" + report.getRequestLateTime().getTime());
                requestLate = report.getRequestLateTime().getTime() - Utilities.correctTime().getTime();
                
            }
            System.out.println("12345");
        }
        System.out.println("I love Mint so much");
        long limit = startTime.getTime() + requestLate + Utilities.limit1h();
        System.out.println("Limit" + limit);
        Date limitTime = new Date(limit);
        System.out.println("Limit Time" + limitTime);
        return limitTime;
    }

    public static Report requestTime(Date date, int userID, int shiftID) throws SQLException {
        ReportRepository rr = new ReportRepository();
        Report report = null;
        if (rr.readDate(date, userID, shiftID) != null) {
            report = rr.readDate(date, userID, shiftID);
        }
        return report;
    }

    public static CheckIn inTime(int userID, int shiftID, Date date) throws ParseException, SQLException {
        ShiftTimeRepository str = new ShiftTimeRepository();
        CheckInRepository cir = new CheckInRepository();
        ShiftTime st = str.read(shiftID);
        System.out.println("789");
        Report report = requestTime(date, userID, shiftID);

        System.out.println("91011");
        Date minInTime = minInTime(st, date);
        System.out.println("minInTime" + minInTime);
        Date maxInTime = maxInTime(st, report, date);

        System.out.println("maInTime" + maxInTime);

        List<CheckIn> ciList = cir.search(minInTime, maxInTime, userID);
        CheckIn ci = null;

        if (ciList.isEmpty()) {
            ci = new CheckIn();
        } else {
            ci = ciList.get(0);
        }
        System.out.println("ci" + ci.toString());
        return ci;
    }
}
