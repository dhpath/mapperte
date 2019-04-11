package com.dh.mapperte.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;

public class ExelWriteUtils {
    private Workbook getWriteWorkBoolType(String filePath){
        if (filePath.toLowerCase().endsWith("xlsx")) {
            return new XSSFWorkbook();
        } else if (filePath.toLowerCase().endsWith("xls")) {
            return new HSSFWorkbook();
        } else {
            System.out.println("文件格式错误");
            return null;
        }
    }
    public void writeExcel(String targetFilePath) {
        Workbook workbook = null;
        FileOutputStream fos = null;

        workbook = getWriteWorkBoolType(targetFilePath);

        //创建sheet
        Sheet sheet = workbook.createSheet("门店入件状态");
        //在sheet第一行写出表单的各个字段名
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("租户id");
        titleRow.createCell(1).setCellValue("门店id");
        titleRow.createCell(2).setCellValue("入件状态");

        //每行的单元格一次写入
//        Integer rowIndex = contents.size();
//        for (int i = 0; i < rowIndex; i++) {
            //第1行作为表格列名，所以从第2行开始读取
            Row row = sheet.createRow(1+ 1);
            Cell cellTenantId = row.createCell(0);
            cellTenantId.setCellValue("dsdsd");
//        }
        //写入到文件流中
        try {
            fos = new FileOutputStream(targetFilePath);
            workbook.write(fos);
        } catch (Exception e) {
            System.out.println("错误："+e.getMessage());
        } finally {
            IOUtils.closeQuietly(workbook);
        }
    }
    @Test
    public void writeXls() {
        String path = "../crm-onlinepay-web/PoiStatus.xls";
        writeExcel("E:\\e.xls");
    }
}
