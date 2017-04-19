package com.steven.gantt.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Steven on 2017/4/9.
 */
public class ExcelUnit {
    public static <T> void exportExcel(String title, String[] headers,
                                       Collection<T> dataset, HttpServletRequest request, HttpServletResponse response) throws IOException {

        OutputStream os = response.getOutputStream();//取得输出流
        response.setCharacterEncoding("UTF-8");
//            String codedFileName = title;
        // 生成提示信息，
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//			response.setHeader("Content-disposition", "attachment; title="+ ou.encodeChineseDownloadFileName(request, title)+ ".xls");
//			response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-disposition", "attachment; filename="
                + new String(title.getBytes("GB2312"), "ISO8859-1")
                + ".xls");


        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);

        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        // 把字体应用到当前的样式
        style.setFont(font);

        // 生成并设置另一个样式
        HSSFCellStyle style_ = workbook.createCellStyle();
        style_.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style_.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style_.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style_.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style_.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style_.setBorderTop(HSSFCellStyle.BORDER_THIN);

        style_.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style_.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        // 生成另一个字体
        HSSFFont font_ = workbook.createFont();
        // font.setColor(color);
        // font.setFontHeightInPoints(height);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        style_.setFont(font_);

        /*// 生成一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
                0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以添加注释！"));
        // 设置注释作者，当鼠标移到单元格上可以在状态栏中看到该内容
        comment.setAuthor("steven");*/

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {

            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(new HSSFRichTextString(headers[i]));
        }
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx（）方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style_);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[]{});
                    Object value = getMethod.invoke(t, new Object[]{});
                    // 判断值的类型后进行强制类型转换


                    String textValue =  value+"";
                   /*  String textValue = null;
                   if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } else if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);

                    } else if (value instanceof byte[]) {
                        // 有图片时，设置行高为60px
                        row.setHeightInPoints(60);
                        // 设置图片所在列宽度为80px，注意这里单位的一个
                        sheet.setColumnWidth(i, (short) (35.7 * 80));
                        byte[] bsValue = (byte[]) value;
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
                                1023, 255, (short) 6, index, (short) 6, index);
                        anchor.setAnchorType(2);
                        patriarch.createPicture(anchor, workbook.addPicture(
                                bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));

                    }else {
                        // 其他数据类型都当作字符串简单处理
                        textValue = value+"";
//                        textValue = value.toString();
                    } */
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));

                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                            HSSFFont _font = workbook.createFont();
                            _font.setColor(HSSFColor.BLUE.index);
                            richString.applyFont(_font);
                            cell.setCellValue(richString);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            workbook.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            os.flush();
            os.close();
        }

    }


    public static HSSFCellStyle getHeadStyle(HSSFWorkbook workbook) {
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);

        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 14);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        // 把字体应用到当前的样式
        style.setFont(font);
        return style;
    }

    public static HSSFCellStyle getBodyCellStyle(HSSFWorkbook workbook) {
        // 生成并设置另一个样式
        HSSFCellStyle style_ = workbook.createCellStyle();
        style_.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style_.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style_.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style_.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style_.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style_.setBorderTop(HSSFCellStyle.BORDER_THIN);

        style_.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style_.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        // 生成另一个字体
        HSSFFont font_ = workbook.createFont();
        // font.setColor(color);
        font_.setFontHeightInPoints((short) 14);
        // font_.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        style_.setFont(font_);
        return style_;
    }


}
