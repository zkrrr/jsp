package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

    public UploadServlet(){
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resultPath = "";
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
                    InputStream in = item.getInputStream();
                    fileName = item.getName();//
                    fileName = UUID.randomUUID()
                            + fileName
                            .substring(fileName.lastIndexOf("\\") + 1);// a.jpg
                    // 设置存取的文件名
                    OutputStream out = new FileOutputStream(storePath + "\\"
                            + fileName);
                    byte b[] = new byte[1024];
                    int len = -1;
                    while ((len = in.read(b)) != -1) {
                        out.write(b, 0, len);
                    }
                    out.close();
                    in.close();
//                    item.delete();// 删除临时文件
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultPath = "/message.jsp";
            request.setAttribute("message", "服务器忙");
        }

        request.getRequestDispatcher("/upload.jsp").forward(request, response);

    }
}