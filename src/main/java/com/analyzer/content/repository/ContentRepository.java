package com.analyzer.content.repository;

import com.analyzer.content.dto.QueryContentRequest;
import com.analyzer.content.entity.ContentEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, String>, JpaSpecificationExecutor<ContentEntity> {


    default List<ContentEntity> queryContent(QueryContentRequest queryContentRequest) {
        Specification<ContentEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(queryContentRequest.getId() != null) {
                predicates.add(builder.equal(root.get(ContentEntity.Fields.id), queryContentRequest.getId()));
            }

            if(queryContentRequest.getText() != null) {
                predicates.add(builder.like(root.get(ContentEntity.Fields.text), queryContentRequest.getText()));
            }

            if(queryContentRequest.getLocation() != null) {
                predicates.add(builder.like(root.get(ContentEntity.Fields.location), queryContentRequest.getLocation()));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return findAll(specification);
    }
}
