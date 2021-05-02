package com.yu.st.controller.handler;

import com.yu.st.bean.vo.Message;
import com.yu.st.util.MyLogger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/22 22:23
 */
@RestController
@MultipartConfig
@RequestMapping("/api/image")
public class ImageHandler {
    @PostMapping("/upload")
    public Message imageUpload(@RequestParam(value = "image") MultipartFile file, HttpSession session, Message message) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = dateFormat.format(new Date());
//        File uploadDir = new File("./uploads/" + date);
        File uploadDir = new File(session.getServletContext().getRealPath("./uploads/") + date);
//        File uploadDir=new File(".");
        if (!uploadDir.exists()) {
            if(!uploadDir.mkdirs()){
                MyLogger.getLogger().error("[上传文件]目录创建失败:"+uploadDir.getAbsolutePath());
            }else {
//                System.out.println(uploadDir.getAbsolutePath());
                String uuid = UUID.randomUUID().toString().replace("-", "");
                try {
                    String originalFilename = file.getOriginalFilename();
                    if(originalFilename!=null){
                        String newName = uuid + originalFilename.substring(originalFilename.indexOf("."));
                        File newFile = new File(uploadDir + File.separator + newName);
                        file.transferTo(newFile);
                        message.setnoerror();
                        message.addData("picaddr", date + '/' + newName);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    MyLogger.getLogger().info("上传失败");
                }
            }
        }

        return message;
    }
}
