package me.kazura233.todomvc.repository;

import jakarta.persistence.criteria.Predicate;
import me.kazura233.todomvc.common.StatusEnum;
import me.kazura233.todomvc.entity.TodomvcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TodomvcRepository extends JpaRepository<TodomvcEntity, Long>,
        JpaSpecificationExecutor<TodomvcEntity> {

    default List<TodomvcEntity> search(String keyword, StatusEnum status) {
        return findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(keyword)) {
                predicates.add(criteriaBuilder.like(root.get("item"), "%" + keyword + "%"));
            }

            if (status != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
