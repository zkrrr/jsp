package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sun.nio.ch.ChannelInputStream;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.rmi.ServerException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

    //定义上传文件的最大字节
    public static final long MAX_SIZE = 10485760000L;

//    @Override
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        long start = System.currentTimeMillis();
//        String storePath = request.getSession().getServletContext().getRealPath("");
//        String fileName = "";
//        try {
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            // 解析请求
//            List<FileItem> items = upload.parseRequest(request);
//            for (FileItem item : items) {
//                if (item.isFormField()) {
//                    // 封装数据到JavaBean中
//                    String fieldName = item.getFieldName();// 字段名，即javabean的属性名，除了图片
//                    String fieldValue = item.getString(request
//                            .getCharacterEncoding());
//                } else {
//                    // 处理文件上传
//                    InputStream in = item.getInputStream();
//                    fileName = item.getName();//
//                    fileName = UUID.randomUUID()
//                            + fileName
//                            .substring(fileName.lastIndexOf("/") + 1);// a.jpg
//                    // 设置存取的文件名
//                    OutputStream out = new FileOutputStream(storePath + "/"
//                            + fileName);
//                    byte b[] = new byte[1024];
//                    int len = -1;
//                    while ((len = in.read(b)) != -1) {
//                        out.write(b, 0, len);
//                    }
//                    out.close();
//                    in.close();
//                    item.delete();// 删除临时文件
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();//49108
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);
//        request.getRequestDispatcher("/upload.jsp").forward(request, response);
//    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        String storePath = request.getSession().getServletContext().getRealPath("");
        String fileName = "";
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 解析请求
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    // 封装数据到JavaBean中
                    String fieldName = item.getFieldName();// 字段名，即javabean的属性名，除了图片
                    String fieldValue = item.getString(request
                            .getCharacterEncoding());
                } else {
                    // 处理文件上传
                    FileChannel inChannel = ((FileInputStream) item.getInputStream()).getChannel();
                    BufferedInputStream in = new BufferedInputStream(item.getInputStream());
                    fileName = item.getName();//
                    fileName = UUID.randomUUID()
                            + fileName
                            .substring(fileName.lastIndexOf("/") + 1);// a.jpg
                    // 设置存取的文件名
                    OutputStream out = new FileOutputStream(storePath + "/" + fileName);

                    FileChannel outChannel = new FileOutputStream(storePath + "/" + fileName).getChannel();

//                    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
//                    int len = -1;
//                    while ((len = in.read(b)) != -1) {
//                        out.write(b, 0, len);
//                        outChannel.write(byteBuffer);
//                    }
                    outChannel.transferFrom(inChannel,0,item.getSize());
                    out.close();
                    in.close();
                    item.delete();// 删除临时文件
                }
            }
        } catch (Exception e) {
            e.printStackTrace();//11123
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        request.getRequestDispatcher("/upload.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //创建根路径的保存变量
//        String rootPath;
//        //声明文件读入类
//        DataInputStream in = null;
//        FileOutputStream fileOut = null;
//        //取得互联网程序的绝对地址
//        String realPath = request.getSession().getServletContext().getRealPath("/");
//        realPath = realPath.substring(0, realPath.indexOf("/out"));
//        //创建文件的保存目录
//        rootPath = realPath + "/web/upload/";
//        //取得客户端上传的数据类型
//        String contentType = request.getContentType();
//
//        if (contentType.indexOf("multipart/form-data") >= 0) {
//            //读入上传数据
//            in = new DataInputStream(request.getInputStream());
//            int formDataLength = request.getContentLength();
//            if (formDataLength > MAX_SIZE) {
//                System.out.println("上传的字节不可以超过" + MAX_SIZE + "字节");
//                return;
//            }
//
//            //保存上传文件的数据
//            byte dataBytes[] = new byte[formDataLength];
//            int byteRead = 0;
//            int totalBytesRead = 0;
//            //上传的数据保存在byte数组里面  113863
//            while (totalBytesRead < formDataLength) {
//                byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
//                totalBytesRead += byteRead;
//            }
//            //根据byte数组创建字符串
//            String file = new String(dataBytes, StandardCharsets.UTF_8);
//            //取得上传数据的文件名
//            String saveFile = file.substring(file.indexOf("filename=\"") + 10);
//            saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
//            saveFile = saveFile.substring(saveFile.lastIndexOf("/") + 1, saveFile.indexOf("\""));
//            int lastIndex = contentType.lastIndexOf("=");
//            //取得数据的分隔字符串
//            String boundary = contentType.substring(lastIndex + 1, contentType.length());
//            //创建保存路径的文件名
//            String fileName = rootPath + saveFile;
//            int pos;
//            pos = file.indexOf("filename = \"");
//            pos = file.indexOf("\n", pos) + 1;
//            pos = file.indexOf("\n", pos) + 1;
//            pos = file.indexOf("\n", pos) + 1;
//
//            int boundaryLocation = file.indexOf(boundary, pos) - 4;
//
//            //取得文件数据的开始的位置
//            int startPos = ((file.substring(0, pos)).getBytes()).length;
//
//            int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
//
//            File checkFile = new File(fileName);
//            if (checkFile.exists()) {
//                System.out.println("<p>" + saveFile + "文件已经存在.</p>");
//                return;
//            }
//            //检查上传文件的目录是否存在
//            File fileDir = new File(rootPath);
//            if (!fileDir.exists()) {
//                fileDir.mkdirs();
//            }
//            //创建文件的输出类
//            fileOut = new FileOutputStream(fileName);
//            //保存文件的数据
//            fileOut.write(dataBytes, startPos, (endPos - startPos));
//            fileOut.close();
//            System.out.println("<b>文件上传成功</b>");
//
//        } else {
//            String content = request.getContentType();
//            System.out.println("上传的文件类型是" + content + "类型的，请上传目录mutipart/form-data类型的文件");
//        }
//
//    }
}