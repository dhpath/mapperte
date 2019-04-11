package com.dh.mapperte.utils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;

public class ExelReadeUtils {
    @Test
    public void TestExcel(){
        String filename = "E:\\成绩.xls";
        readExcel(filename);
    }
    public void readExcel(String sourceFilePath)  {
        Workbook workbook = null;
        try {
            workbook = getReadWorkBookType(sourceFilePath);
            if (workbook == null){
                System.out.println("文件错误");
                return;
            }
            //获取第一个sheet
            Sheet sheet = workbook.getSheetAt(0);
            //第0行是表名，忽略，从第二行开始读取
            for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                Cell cell = row.getCell(0);
                String trim = getCellStringVal(cell).trim();
                System.out.println(trim);
            }
        } finally {
            IOUtils.closeQuietly(workbook);
        }
    }
    private Workbook getReadWorkBookType(String filePath)  {
        //xls-2003, xlsx-2007
        FileInputStream is = null;

        try {
            is = new FileInputStream(filePath);
            if (filePath.toLowerCase().endsWith("xlsx")) {
                return new XSSFWorkbook(is);
            } else if (filePath.toLowerCase().endsWith("xls")) {
                return new HSSFWorkbook(is);
            } else {
                //  抛出自定义的业务异常
                System.out.println("文件格式错误");
                return  null;
            }
        } catch (Exception e) {
            //  抛出自定义的业务异常
            System.out.println("文件格式错误");
            return null;
        }
    }
    private String getCellStringVal(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                cell.setCellType(Cell.CELL_TYPE_STRING);
                return cell.getStringCellValue();
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            case ERROR:
                return String.valueOf(cell.getErrorCellValue());
            default:
                return null;
        }
    }
}
