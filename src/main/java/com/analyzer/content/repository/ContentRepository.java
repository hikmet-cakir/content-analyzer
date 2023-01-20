package com.analyzer.content.repository;

import com.analyzer.content.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, String> {
}
