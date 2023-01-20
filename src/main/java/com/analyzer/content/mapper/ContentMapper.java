package com.analyzer.content.mapper;

import com.analyzer.content.entity.ContentEntity;
import com.analyzer.content.model.Content;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@Mapper
public interface ContentMapper {

    ContentMapper INSTANCE = Mappers.getMapper(ContentMapper.class);

    Content toContent(ContentEntity contentEntity);

    ContentEntity toContentEntity(Content content);
}
