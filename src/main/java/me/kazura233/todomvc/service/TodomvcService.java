package me.kazura233.todomvc.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import me.kazura233.todomvc.common.StatusEnum;
import me.kazura233.todomvc.dto.TodomvcAddDTO;
import me.kazura233.todomvc.entity.TodomvcEntity;
import me.kazura233.todomvc.repository.TodomvcRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodomvcService {

    @Resource
    private TodomvcRepository todomvcRepository;

    public void deleteAll(){
        todomvcRepository.deleteAll();
    }

    public List<TodomvcEntity> findAll() {
        return todomvcRepository.findAll();
    }

    public List<TodomvcEntity> find(String keyword, StatusEnum status) {
        if(keyword == null || keyword.isEmpty()){
            return todomvcRepository.findByStatus(status);
        }
        return todomvcRepository.findByItemContainingAndStatus(keyword,status);
    }

    public TodomvcEntity add(TodomvcAddDTO dto) {
        return add(dto.getItem(),StatusEnum.TODOMVC_STATUS_ACTIVE);
    }

    public TodomvcEntity add(String item, StatusEnum status){
        TodomvcEntity entity = new TodomvcEntity();
        entity.setItem(item);
        entity.setStatus(status);

        return todomvcRepository.save(entity);
    }

    public TodomvcEntity modify(TodomvcEntity entity) {
        Optional<TodomvcEntity> o = findById(entity.getId());
        if(o.isEmpty()){
            return add(entity.getItem(),entity.getStatus());
        }

        TodomvcEntity e = o.get();
        e.setItem(entity.getItem());
        e.setStatus(entity.getStatus());
        return todomvcRepository.save(e);

    }

    public void del(Long id) {
        todomvcRepository.deleteById(id);
    }

    public Optional<TodomvcEntity> findById(Long id) {
        if(id == null){
            return Optional.empty();
        }
        return todomvcRepository.findById(id);
    }
}
