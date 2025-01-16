package com.eccomerce.Ikhlas_eccomerce.implementation;


import com.eccomerce.Ikhlas_eccomerce.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        // Get File named pf current / original file
        String originalFileName = file.getOriginalFilename();

        // Generate a unique file name

        String randomId = UUID.randomUUID().toString();
        String filName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
        String filePath= path + File.separator + filName;
        //Check if path exist and create
        File folder = new File(path);
        if(!folder.exists())
            folder.mkdirs();

        // Upload to server
        Files.copy(file.getInputStream(), Paths.get(filePath));
        //Return file
        return filName;
    }
}
