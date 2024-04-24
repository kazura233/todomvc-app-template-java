package me.kazura233.todomvc.repository;

import me.kazura233.todomvc.common.StatusEnum;
import me.kazura233.todomvc.entity.TodomvcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodomvcRepository extends JpaRepository<TodomvcEntity, Long>,
        JpaSpecificationExecutor<TodomvcEntity> {

    List<TodomvcEntity> findByItemContainingAndStatus(String keyword,StatusEnum status);

    List<TodomvcEntity> findByStatus(StatusEnum status);
}
