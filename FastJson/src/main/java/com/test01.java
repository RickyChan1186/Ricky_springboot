package com;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Bookmark;
import org.apache.poi.hwpf.usermodel.Bookmarks;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
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

            File excel=new File("d:/test.doc");

            InputStream is = new FileInputStream(excel);
            OutputStream outputStream = new FileOutputStream("d:/aa.doc");



            Map<String,String> dataMap = new HashMap<>();
            dataMap.put("PO_Jzyj","aaaaaaaaaaaaaaaaaaa");

            docOperate(is,outputStream,dataMap);

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


    //修改docx表格书签方法
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
                                //设置字体和大小
                                run.setFontFamily("楷体_GB2312");
                                run.setFontSize(15);

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



    //往docx表格指定位置注入内容的方法
    public static void docxOperateTable2(InputStream inputStream, OutputStream outputStream, Map<String,String> dataMap) throws IOException {
        XWPFDocument document = new XWPFDocument(inputStream).getXWPFDocument();

        //获取表单List
        List<XWPFTable> xwpfTableList = document.getTables();
        //修改中心主任意见批示
        XWPFTable xwpfTable = xwpfTableList.get(0);
        XWPFTableRow xwpfTableRow = xwpfTable.getRow(5);
        XWPFTableCell xwpfTableCell = xwpfTableRow.getCell(0);

        CTTc ctTc = xwpfTableCell.getCTTc();
        ctTc.setPArray(new CTP[] {CTP.Factory.newInstance()});


        //获取每一行每一列中的文本集
        List<XWPFParagraph> paragraphList = xwpfTableCell.getParagraphs();
        //把批示内容去掉，再重新注入
        for(int i=0; i<paragraphList.size(); i++){
            /*XWPFParagraph xwpfParagraph = paragraphList.get(i);
            CTBookmark[] ctBookmarks= xwpfParagraph.getCTP().getBookmarkStartArray();
            for(int j=0; j<ctBookmarks.length; j++){
                ctBookmarks[j].getId();
                ctBookmarks[j].getName();
                if(!ctBookmarks[j].getName().equals("PO_Jzyj")||!ctBookmarks[j].getName().equals("PO_Zxzryj")){
                    continue;
                }
                System.out.println(ctBookmarks[j].getId()+"|"+ctBookmarks[j].getName());
                xwpfParagraph.getCTP().removeBookmarkStart(Integer.parseInt(ctBookmarks[j].getId().toString()));
                xwpfParagraph.getCTP().removeBookmarkEnd(Integer.parseInt(ctBookmarks[j].getId().toString()));

            }*/

           // xwpfTableCell.removeParagraph(i);
        }

        for(int i=1; i<2; i++){
            XWPFParagraph xwpfParagraph = xwpfTableCell.addParagraph();
            XWPFRun run = xwpfParagraph.createRun();
            //设置字体和大小
            run.setFontFamily("楷体_GB2312");
            run.setFontSize(15);

            run.setText("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");

        }





        document.write(outputStream);
        document.close();
    }


    //删除段落内所有的书签 去掉w:bookmarkStart/w:bookmarkEnd
    public void removeParagraphBookMark(XWPFParagraph para) {
        List<CTBookmark> bookmarkStartList = para.getCTP()
                .getBookmarkStartList();
        if (bookmarkStartList == null) {
            return;
        }
        for (int i = bookmarkStartList.size() - 1; i >= 0; i--) {
            Node bookStartNode = bookmarkStartList.get(i).getDomNode();
            printNodeAllAttributeValue(bookStartNode);
            bookStartNode.getParentNode().removeChild(bookStartNode);
        }
        List<CTMarkupRange> bookmarkEndList = para.getCTP()
                .getBookmarkEndList();
        if (bookmarkEndList == null) {
            return;
        }
        for (int i = bookmarkEndList.size() - 1; i >= 0; i--) {
            Node bookEndNode = bookmarkEndList.get(i).getDomNode();
            printNodeAllAttributeValue(bookEndNode);
            bookEndNode.getParentNode().removeChild(bookEndNode);
        }

    }

    public void printNodeAllAttributeValue(Node node) {
        NamedNodeMap nodeAttr = node.getAttributes();
        if (nodeAttr != null) {
            int numAttrs = nodeAttr.getLength();
            for (int i = 0; i < numAttrs; i++) {
                Attr attr = (Attr) nodeAttr.item(i);
                String attrName = attr.getNodeName();
                String attrValue = attr.getNodeValue();
                System.out.println(node.getNodeName() + " 属性="
                        + attrName + " 值= " + attrValue);
            }
        }
    }
}
