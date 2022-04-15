package com.xiaozheng.common.utils.excel;

import com.xiaozheng.model.annotation.ExcelAttribute;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class ExcelExportUtil<T> {

    private int rowIndex;
    private int styleIndex;
    private String templatePath;
    private Class clazz;
    // private Field fields[];
     private List<Field> fieldList = new ArrayList<>() ;

    public ExcelExportUtil(Class clazz,int rowIndex,int styleIndex) {
        this.clazz = clazz;
        this.rowIndex = rowIndex;
        this.styleIndex = styleIndex;
        while (clazz != null && !"com.baomidou.mybatisplus.extension.activerecord.Model".equals(clazz.getName().toLowerCase())) {//当父类为null的时候说明到达了最上层的父类(Object类).
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass(); //得到父类,然后赋给自己
        }
        // fields = clazz.getDeclaredFields();
    }

    /**
     * 基于注解导出
     */
    public void export(HttpServletResponse response, InputStream is, List<T> objs, String fileName) throws Exception {

        SXSSFWorkbook workbook = new SXSSFWorkbook(new XSSFWorkbook(is));
        Sheet sheet = workbook.getSheetAt(0);

        CellStyle[] styles = getTemplateStyles(sheet.getRow(styleIndex));

        AtomicInteger datasAi = new AtomicInteger(rowIndex);
        for (T t : objs) {
            Row row = sheet.createRow(datasAi.getAndIncrement());
            for(int i=0;i<styles.length;i++) {
                Cell cell = row.createCell(i);
                cell.setCellStyle(styles[i]);
                for (Field field : fieldList) {
                    if(field.isAnnotationPresent(ExcelAttribute.class)){
                        field.setAccessible(true);
                        ExcelAttribute ea = field.getAnnotation(ExcelAttribute.class);
                        if(i == ea.sort()) {
                            cell.setCellValue(Objects.isNull(field.get(t)) ? null : field.get(t).toString());
                        }
                    }
                }
            }
        }
        fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
        response.setCharacterEncoding("UTF-8");
        // response.setContentType("application/vnd.ms-excel");
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.addHeader("charset", "utf-8");
        response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.addHeader("Pragma", "no-cache");
        // response.setHeader("content-disposition", "attachment;filename=\"" + new String(fileName.getBytes(), "ISO-8859-1") + "\"");
        response.setHeader("filename", fileName);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"; filename*=utf-8''" + fileName);

        workbook.write(response.getOutputStream());
    }

    public CellStyle[] getTemplateStyles(Row row) {
        CellStyle [] styles = new CellStyle[row.getLastCellNum()];
        for(int i=0;i<row.getLastCellNum();i++) {
            styles[i] = row.getCell(i).getCellStyle();
        }
        return styles;
    }
}
