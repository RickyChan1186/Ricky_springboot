package com.ricky.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ricky
 * @create 2019-10-13 14:22
 */
@RestController
@RequestMapping("/api/vi/excel")
public class createExcel {

    //质效评估EXCEL
    @GetMapping(value = "/ZxpgModel")
    public void ZxpgModel(HttpServletResponse response) throws IOException {


        OutputStream outputStream = response.getOutputStream();

        //清空缓存
        response.reset();
        //定义浏览器响应表头，顺带定义下载名，比如students
        response.setHeader("Content-disposition", "attachment;filename=zxpg.xls");
        //定义下载的类型，标明是excel文件
        response.setContentType("application/vnd.ms-excel");

        //创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表
        HSSFSheet sheet = workbook.createSheet("Sheet1");

        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(0,20*256);
        sheet.setColumnWidth(1,25*256);
        sheet.setColumnWidth(2,25*256);
        sheet.setColumnWidth(3,30*256);
        sheet.setColumnWidth(4,25*256);
        sheet.setColumnWidth(5,30*256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中

        //设置文件表头内容
        //合并第一行单元格
        //参数说明：1：开始行 2：结束行  3：开始列 4：结束列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));

        //表头内容
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;

        cell = row.createCell(0);
        cell.setCellValue("质效评估");
        cell.setCellStyle(style);


        HSSFRow row1 = sheet.createRow(1);
        cell = row1.createCell(0);
        cell.setCellValue("单位");
        cell.setCellStyle(style);

        cell = row1.createCell(1);
        cell.setCellValue("总要情接收数");
        cell.setCellStyle(style);

        cell = row1.createCell(2);
        cell.setCellValue("5分钟内接收数");
        cell.setCellStyle(style);

        cell = row1.createCell(3);
        cell.setCellValue("5分钟内接收比例（%）");
        cell.setCellStyle(style);

        cell = row1.createCell(4);
        cell.setCellValue("30分钟后接收数");
        cell.setCellStyle(style);

        cell = row1.createCell(5);
        cell.setCellValue("30分钟后接收比例（%）");
        cell.setCellStyle(style);


        //设置表单内容,获取数据并依次输出到表格中



        workbook.setActiveSheet(0);//默认打开的工作表
        //这时候把创建好的excel写入到输出流
        workbook.write(outputStream);
        outputStream.close();
    }


    //值班情况统计表EXCEL
    @GetMapping(value = "/ZbqktjbModel")
    public void ZbqktjbModel(HttpServletResponse response) throws IOException {

        OutputStream outputStream = response.getOutputStream();

        //清空缓存
        response.reset();
        //定义浏览器响应表头，顺带定义下载名，比如students
        response.setHeader("Content-disposition", "attachment;filename=zbqktjb.xls");
        //定义下载的类型，标明是excel文件
        response.setContentType("application/vnd.ms-excel");

        //创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表
        HSSFSheet sheet = workbook.createSheet("Sheet1");

        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(0,20*256);
        sheet.setColumnWidth(1,20*256);
        sheet.setColumnWidth(2,20*256);
        sheet.setColumnWidth(3,20*256);
        sheet.setColumnWidth(4,20*256);
        sheet.setColumnWidth(5,20*256);
        sheet.setColumnWidth(6,20*256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中

        //设置文件表头内容
        //合并第一行单元格
        //参数说明：1：开始行 2：结束行  3：开始列 4：结束列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,6));

        //表头内容
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;

        cell = row.createCell(0);
        cell.setCellValue("值班情况统计表");
        cell.setCellStyle(style);


        HSSFRow row1 = sheet.createRow(1);
        cell = row1.createCell(0);
        cell.setCellValue("群组");
        cell.setCellStyle(style);

        cell = row1.createCell(1);
        cell.setCellValue("值班日志");
        cell.setCellStyle(style);

        cell = row1.createCell(2);
        cell.setCellValue("信息快报");
        cell.setCellStyle(style);

        cell = row1.createCell(3);
        cell.setCellValue("警情短信");
        cell.setCellStyle(style);

        cell = row1.createCell(4);
        cell.setCellValue("日志短信");
        cell.setCellStyle(style);

        cell = row1.createCell(5);
        cell.setCellValue("督导信息");
        cell.setCellStyle(style);

        cell = row1.createCell(6);
        cell.setCellValue("接收信息");
        cell.setCellStyle(style);


        //设置表单内容,获取数据并依次输出到表格中



        workbook.setActiveSheet(0);//默认打开的工作表
        //这时候把创建好的excel写入到输出流
        workbook.write(outputStream);
        outputStream.close();
    }

    //各单位报送信息和采用情况统计表
    @GetMapping(value = "/BsxxCyqkTjbModel")
    public void BsxxCyqkTjbModel(HttpServletResponse response) throws IOException {

        OutputStream outputStream = response.getOutputStream();

        //清空缓存
        response.reset();
        //定义浏览器响应表头，顺带定义下载名，比如students
        response.setHeader("Content-disposition", "attachment;filename=bsxxcyqktjb.xls");
        //定义下载的类型，标明是excel文件
        response.setContentType("application/vnd.ms-excel");

        //创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表
        HSSFSheet sheet = workbook.createSheet("Sheet1");

        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        for(int i=0; i<23; i++){
            if(i==0 || i==22){
                sheet.setColumnWidth(i,15*256);
            }else
                if(i==8 || i==9 || i==11 || i==12 || i==13 || i==17 || i==18){
                    sheet.setColumnWidth(i,20*256);
            }else{
                    sheet.setColumnWidth(i,10*256);
                }

        }

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中


        //设置文件表头内容
        //合并第一行单元格
        //参数说明：1：开始行 2：结束行  3：开始列 4：结束列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,22));//各单位报送信息和采用情况统计表
        sheet.addMergedRegion(new CellRangeAddress(1,2,0,0));//单位\项目
        sheet.addMergedRegion(new CellRangeAddress(1,1,1,3));//报送条数
        sheet.addMergedRegion(new CellRangeAddress(1,1,4,9));//采用
        sheet.addMergedRegion(new CellRangeAddress(1,1,10,12));//领导批示
        sheet.addMergedRegion(new CellRangeAddress(1,2,13,13));//报送不规范
        sheet.addMergedRegion(new CellRangeAddress(1,1,14,15));//迟报漏报
        sheet.addMergedRegion(new CellRangeAddress(1,1,16,18));//批评
        sheet.addMergedRegion(new CellRangeAddress(1,2,19,19));//得分
        sheet.addMergedRegion(new CellRangeAddress(1,2,20,20));//扣分
        sheet.addMergedRegion(new CellRangeAddress(1,2,21,21));//计分
        sheet.addMergedRegion(new CellRangeAddress(1,2,22,22));//当年累分

        //表头内容
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;

        cell = row.createCell(0);
        cell.setCellValue("各单位报送信息和采用情况统计表");
        cell.setCellStyle(style);


        HSSFRow row1 = sheet.createRow(1);
        cell = row1.createCell(0);
        cell.setCellValue("单位\\项目");
        cell.setCellStyle(style);

        cell = row1.createCell(1);
        cell.setCellValue("报送条数");
        cell.setCellStyle(style);

        cell = row1.createCell(4);
        cell.setCellValue("采用");
        cell.setCellStyle(style);

        cell = row1.createCell(10);
        cell.setCellValue("领导批示");
        cell.setCellStyle(style);

        cell = row1.createCell(13);
        cell.setCellValue("报送不规范");
        cell.setCellStyle(style);

        cell = row1.createCell(14);
        cell.setCellValue("迟报漏报");
        cell.setCellStyle(style);


        cell = row1.createCell(16);
        cell.setCellValue("批评");
        cell.setCellStyle(style);

        cell = row1.createCell(19);
        cell.setCellValue("得分");
        cell.setCellStyle(style);

        cell = row1.createCell(20);
        cell.setCellValue("扣分");
        cell.setCellStyle(style);

        cell = row1.createCell(21);
        cell.setCellValue("计分");
        cell.setCellStyle(style);

        cell = row1.createCell(22);
        cell.setCellValue("当年累分");
        cell.setCellStyle(style);

        HSSFRow row2 = sheet.createRow(2);
        cell = row2.createCell(1);
        cell.setCellValue("文字");
        cell.setCellStyle(style);

        cell = row2.createCell(2);
        cell.setCellValue("照片");
        cell.setCellStyle(style);

        cell = row2.createCell(3);
        cell.setCellValue("声像");
        cell.setCellStyle(style);

        cell = row2.createCell(4);
        cell.setCellValue("要情");
        cell.setCellStyle(style);

        cell = row2.createCell(5);
        cell.setCellValue("摘报");
        cell.setCellStyle(style);

        cell = row2.createCell(6);
        cell.setCellValue("综合");
        cell.setCellStyle(style);

        cell = row2.createCell(7);
        cell.setCellValue("快报");
        cell.setCellStyle(style);

        cell = row2.createCell(8);
        cell.setCellValue("市委市府省厅");
        cell.setCellStyle(style);

        cell = row2.createCell(9);
        cell.setCellValue("省委省府公安部");
        cell.setCellStyle(style);

        cell = row2.createCell(10);
        cell.setCellValue("局");
        cell.setCellStyle(style);

        cell = row2.createCell(11);
        cell.setCellValue("市委市府省厅");
        cell.setCellStyle(style);

        cell = row2.createCell(12);
        cell.setCellValue("省委省府公安部");
        cell.setCellStyle(style);

        cell = row2.createCell(14);
        cell.setCellValue("一般");
        cell.setCellStyle(style);

        cell = row2.createCell(15);
        cell.setCellValue("重要");
        cell.setCellStyle(style);

        cell = row2.createCell(16);
        cell.setCellValue("局");
        cell.setCellStyle(style);

        cell = row2.createCell(17);
        cell.setCellValue("市委市府省厅");
        cell.setCellStyle(style);

        cell = row2.createCell(18);
        cell.setCellValue("省委省府公安部");
        cell.setCellStyle(style);

        //设置表单内容,获取数据并依次输出到表格中



        workbook.setActiveSheet(0);//默认打开的工作表
        //这时候把创建好的excel写入到输出流
        workbook.write(outputStream);
        outputStream.close();
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject(true);
        JSONArray jsonArray = new JSONArray();
        for(int i=0; i<3; i++){
            JSONObject object = new JSONObject(true);
            for (int j=0;j<23;j++){
                object.put(String.valueOf(j),j);
            }
            jsonArray.add(object);
        }

        System.out.println(jsonArray.toJSONString());

    }






}
