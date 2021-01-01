package com.yu.st.controller.trade;

import com.yu.st.entity.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author :hhyygg2009
 * @date :Created in 2020/12/23 13:05
 * @package :${PACKAGE_NAME}
 * @description:
 * @modified By：
 * @version:
 */
@MultipartConfig
@WebServlet("/trade/item/imgupload")
public class ImageUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");
        String date = dateFormat.format(new Date());
        File uploadDir = new File(this.getServletContext().getRealPath("/uploads/" + date));
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String pic = "";
        String name = UUID.randomUUID().toString().replace("-", "");
        Message message = new Message();

        try {
            Part picPart = request.getPart("image");
            if (picPart != null) {
                String header = picPart.getHeader("content-disposition");
                String oldPath = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
                String oldName = new File(oldPath).getName();
                pic = name + oldName.substring(oldName.indexOf("."));
                picPart.write(uploadDir + File.separator + pic);
                message.setnoerror();
                message.addData("picaddr", date + '/' + pic);
            }
        } catch (ServletException e) {
            //
        }
        response.getWriter().println(message);
    }
}
