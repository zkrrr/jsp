package servlet;
/*
 * create by zk
 * 19-4-17
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@WebServlet("/download")
public class downloadServlet extends HttpServlet {

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        long start = System.currentTimeMillis();
//
//        response.setContentType("text/html;charset=utf-8");
//        try {
//            request.setCharacterEncoding("UTF-8");
//        } catch (UnsupportedEncodingException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//
//        java.io.BufferedInputStream bis = null;
//        java.io.BufferedOutputStream bos = null;
//
//        String downLoadPath = "/home/zk/Videos/[电影天堂www.dy2018.com]飞驰人生HD国语中字.mkv";  //注意不同系统的分隔符
//        System.out.println(downLoadPath);
//        String fileName = "downloadFile";
//
//        try {
//            long fileLength = new File(downLoadPath).length();
//            response.setContentType("application/x-msdownload;");
//            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
//            response.setHeader("Content-Length", String.valueOf(fileLength));
//            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
//            bos = new BufferedOutputStream(response.getOutputStream());
//            byte[] buff = new byte[2048];
//            int bytesRead;
//            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//                bos.write(buff, 0, bytesRead);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (bis != null)
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            if (bos != null)
//                try {
//                    bos.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);//39573
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long start = System.currentTimeMillis();

        response.setContentType("text/html;charset=utf-8");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String downLoadPath = "/home/zk/IdeaProjects/jsp/web/subjectImage/timg(13).jpeg";
        File downloadFile = new File(downLoadPath);
        long fileLength = downloadFile.length();
        String fileName = downloadFile.getName();

        response.setContentType("application/x-msdownoad");
        response.setHeader("Content-disposition","attachment; filename="+fileName);
        response.setHeader("Content-Length", ""+fileLength);

        FileChannel inChannel = new FileInputStream(downloadFile).getChannel();

        BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());

        ByteBuffer buff=ByteBuffer.allocateDirect(2048);

        byte[] bytes = new byte[2048];

        int bytesRead;
        int position = 0;
        while (-1 != (bytesRead = inChannel.read(buff, position))) {
            buff.flip();
            buff.get(bytes, 0, bytesRead);
            output.write(bytes, 0, bytesRead);
            position += bytesRead;
            buff.clear();

        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);//9507
        inChannel.close();
        output.close();
    }

}
