package me.kazura233.todomvc.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import me.kazura233.todomvc.common.RestResult;
import me.kazura233.todomvc.dto.TodomvcAddDTO;
import me.kazura233.todomvc.dto.TodomvcDelDTO;
import me.kazura233.todomvc.dto.TodomvcFindDTO;
import me.kazura233.todomvc.dto.TodomvcModifyDTO;
import me.kazura233.todomvc.entity.TodomvcEntity;
import me.kazura233.todomvc.service.TodomvcService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todomvc")
public class TodomvcController extends BaseController {

    @Resource
    private TodomvcService todomvcService;

    @PostMapping("/find")
    public RestResult find(@RequestBody TodomvcFindDTO body) {

        List<TodomvcEntity> list = todomvcService.find(body.getKeyword(), body.getStatus());

        return success(list);
    }

    @PostMapping("/add")
    public RestResult add(@RequestBody TodomvcAddDTO body) {

        todomvcService.add(body);

        return success();
    }

    @PostMapping("/modify")
    public RestResult modify(@RequestBody TodomvcModifyDTO body) {
        TodomvcEntity entity = new TodomvcEntity();
        entity.setId(body.getId());
        entity.setItem(body.getItem());
        entity.setStatus(body.getStatus());

        todomvcService.modify(entity);

        return success();
    }

    @PostMapping("/del")
    public RestResult del(@RequestBody TodomvcDelDTO body) {
        todomvcService.del(body.getId());

        return success();
    }
}
