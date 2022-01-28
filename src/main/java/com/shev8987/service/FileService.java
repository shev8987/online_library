package com.shev8987.service;

import com.shev8987.entity.FileEntity;
import com.shev8987.repository.IFileRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {

    private final IFileRepository fileRepository;

    public FileService(IFileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void save(MultipartFile file) throws IOException {

        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        fileRepository.save(fileEntity);

    }

    public Optional<FileEntity> getFile(Long id) {
        return fileRepository.findById(id);
    }

}
