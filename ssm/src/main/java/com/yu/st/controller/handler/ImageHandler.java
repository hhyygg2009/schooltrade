package com.yu.st.controller.handler;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.yu.st.bean.vo.Message;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/22 22:23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/image")
public class ImageHandler {


    private final GridFsOperations gridFsOperations;

    @PostMapping("/upload")
    public Message imageUpload(@RequestParam(value = "image") MultipartFile file, HttpSession session) {
        try {
            ObjectId id = gridFsOperations.store(file.getInputStream(), file.getOriginalFilename());
            return Message.success().addData("picaddr", id.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Message.error();
    }

    @GetMapping(value = "/get/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] image(@PathVariable String id) {
        GridFSFile gridFSFile = gridFsOperations.findOne(new Query().addCriteria(Criteria.where("_id").is(id)));
        GridFsResource resource = gridFsOperations.getResource(gridFSFile);
        try {
            InputStream inputStream = resource.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = inputStream.read(buff, 0, 100)) > 0) {
                byteArrayOutputStream.write(buff, 0, rc);
            }

            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }


}
