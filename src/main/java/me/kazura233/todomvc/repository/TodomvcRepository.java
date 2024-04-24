package me.kazura233.todomvc.repository;

import me.kazura233.todomvc.entity.TodomvcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TodomvcRepository extends JpaRepository<TodomvcEntity, Long>,
        JpaSpecificationExecutor<TodomvcEntity> {
}
