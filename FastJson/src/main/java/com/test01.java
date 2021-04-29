package com;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Bookmark;
import org.apache.poi.hwpf.usermodel.Bookmarks;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.w3c.dom.Node;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ricky
 * @create 2020-03-19 9:28
 */
public class test01 {


    public static void main(String[] args) {

        try {

            File excel=new File("d:/test.docx");

            FileInputStream is = new FileInputStream(excel);
            OutputStream outputStream = new FileOutputStream("d:/aa.docx");

            Map<String,String> dataMap = new HashMap<>();
            dataMap.put("PO_Jzyj","11111111111111111111111111");

            docxOperateTable(is,outputStream,dataMap);

            is.close();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //修改doc文本书签方法
    public static void docOperate(InputStream inputStream,OutputStream outputStream,
                                  Map<String,String> dataMap) throws IOException {

        HWPFDocument document = new HWPFDocument(inputStream);
        Bookmarks bookmarks = document.getBookmarks();
        for(int dwI = 0;dwI < bookmarks.getBookmarksCount();dwI++){
            Bookmark bookmark = bookmarks.getBookmark(dwI);
            if(dataMap.containsKey(bookmark.getName())){
                Range range = new Range(bookmark.getStart(),bookmark.getEnd(),document);
                range.replaceText(dataMap.get(bookmark.getName()),false);
            }
        }
        document.write(outputStream);
    }


    /** docx中定义的部分常量引用  **/
    public static final String RUN_NODE_NAME = "w:r";
    public static final String TEXT_NODE_NAME = "w:t";
    public static final String BOOKMARK_START_TAG = "w:bookmarkStart";
    public static final String BOOKMARK_END_TAG = "w:bookmarkEnd";
    public static final String BOOKMARK_ID_ATTR_NAME = "w:id";
    public static final String STYLE_NODE_NAME = "w:rPr";



    //修改docx文本书签方法
    public static void docxOperate(InputStream inputStream, OutputStream outputStream, Map<String,String> dataMap) throws IOException {
        XWPFDocument document = new XWPFDocument(inputStream).getXWPFDocument();
        List<XWPFParagraph> paragraphList =  document.getParagraphs();
        for(XWPFParagraph xwpfParagraph:paragraphList){
            CTP ctp = xwpfParagraph.getCTP();

            for(int dwI = 0;dwI < ctp.sizeOfBookmarkStartArray();dwI++){
                CTBookmark bookmark = ctp.getBookmarkStartArray(dwI);
                if(dataMap.containsKey(bookmark.getName())){

                    XWPFRun run = xwpfParagraph.createRun();
                    run.setText(dataMap.get(bookmark.getName()));

                    Node firstNode = bookmark.getDomNode();
                    Node nextNode = firstNode.getNextSibling();
                    while(nextNode != null){
                        // 循环查找结束符
                        String nodeName = nextNode.getNodeName();
                        if(nodeName.equals(BOOKMARK_END_TAG)){
                            break;
                        }

                        // 删除中间的非结束节点，即删除原书签内容
                        Node delNode = nextNode;
                        nextNode = nextNode.getNextSibling();

                        ctp.getDomNode().removeChild(delNode);
                    }

                    if(nextNode == null){
                        // 始终找不到结束标识的，就在书签前面添加
                        ctp.getDomNode().insertBefore(run.getCTR().getDomNode(),firstNode);
                    }else{
                        // 找到结束符，将新内容添加到结束符之前，即内容写入bookmark中间
                        ctp.getDomNode().insertBefore(run.getCTR().getDomNode(),nextNode);
                    }
                }
            }
        }

        document.write(outputStream);
        document.close();
    }


    //修改docx文本书签方法
    public static void docxOperateTable(InputStream inputStream, OutputStream outputStream, Map<String,String> dataMap) throws IOException {
        XWPFDocument document = new XWPFDocument(inputStream).getXWPFDocument();

        //获取表单List
        List<XWPFTable> xwpfTableList = document.getTables();
        for(XWPFTable xwpfTable:xwpfTableList){
            //获取表单的所有行对象
            List<XWPFTableRow>  xwpfTableRowList = xwpfTable.getRows();
            for(XWPFTableRow xwpfTableRow:xwpfTableRowList){
                //获取行中共有多少列
                List<XWPFTableCell> xwpfTableCellList =  xwpfTableRow.getTableCells();
                for(XWPFTableCell xwpfTableCell:xwpfTableCellList){
                    //获取每一行每一列中的文本集
                    List<XWPFParagraph> paragraphList = xwpfTableCell.getParagraphs();
                    for(XWPFParagraph xwpfParagraph:paragraphList){
                        CTP ctp = xwpfParagraph.getCTP();

                        for(int dwI = 0;dwI < ctp.sizeOfBookmarkStartArray();dwI++){
                            CTBookmark bookmark = ctp.getBookmarkStartArray(dwI);
                            if(dataMap.containsKey(bookmark.getName())){

                                XWPFRun run = xwpfParagraph.createRun();
                                run.setText(dataMap.get(bookmark.getName()));

                                Node firstNode = bookmark.getDomNode();
                                Node nextNode = firstNode.getNextSibling();
                                while(nextNode != null){
                                    // 循环查找结束符
                                    String nodeName = nextNode.getNodeName();
                                    if(nodeName.equals(BOOKMARK_END_TAG)){
                                        break;
                                    }

                                    // 删除中间的非结束节点，即删除原书签内容
                                    Node delNode = nextNode;
                                    nextNode = nextNode.getNextSibling();

                                    ctp.getDomNode().removeChild(delNode);
                                }

                                if(nextNode == null){
                                    // 始终找不到结束标识的，就在书签前面添加
                                    ctp.getDomNode().insertBefore(run.getCTR().getDomNode(),firstNode);
                                }else{
                                    // 找到结束符，将新内容添加到结束符之前，即内容写入bookmark中间
                                    ctp.getDomNode().insertBefore(run.getCTR().getDomNode(),nextNode);
                                }
                            }
                        }
                    }
                }
            }
        }

        document.write(outputStream);
        document.close();
    }


}
