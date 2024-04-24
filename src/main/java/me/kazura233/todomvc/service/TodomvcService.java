package me.kazura233.todomvc.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import me.kazura233.todomvc.repository.TodomvcRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TodomvcService {

    @Resource
    private TodomvcRepository todomvcRepository;
}
