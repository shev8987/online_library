package com.shev8987.repository;

import com.shev8987.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileRepository extends JpaRepository<FileEntity, Long> {

}
