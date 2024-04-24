package me.kazura233.todomvc.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import me.kazura233.todomvc.common.StatusEnum;
import me.kazura233.todomvc.entity.TodomvcEntity;
import me.kazura233.todomvc.repository.TodomvcRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TodomvcService {

    @Resource
    private TodomvcRepository todomvcRepository;

    public List<TodomvcEntity> find(String keyword, StatusEnum status) {

        return new ArrayList<>();
    }

    public void add(TodomvcEntity entity) {

    }

    public void modify(TodomvcEntity entity) {

    }

    public void del(Long id) {

    }
}
