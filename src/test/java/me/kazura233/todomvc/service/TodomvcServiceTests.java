package me.kazura233.todomvc.service;

import jakarta.annotation.Resource;
import me.kazura233.todomvc.common.StatusEnum;
import me.kazura233.todomvc.dto.TodomvcAddDTO;
import me.kazura233.todomvc.entity.TodomvcEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TodomvcServiceTests {
    @Resource
    private TodomvcService todomvcService;

    @Test
    public void test() {

        // 删除全部
        System.out.println("---------- step 1 ----------");
        todomvcService.deleteAll();
        dump();

        // 新增5个
        System.out.println("---------- step 2 ----------");
        TodomvcAddDTO addDTO = new TodomvcAddDTO();
        addDTO.setItem("任务1");
        TodomvcEntity modifyEntity = todomvcService.add(addDTO);
        addDTO.setItem("任务2");
        todomvcService.add(addDTO);
        addDTO.setItem("任务3");
        TodomvcEntity delEntity =  todomvcService.add(addDTO);
        addDTO.setItem("关键词吃烤肠");
        todomvcService.add(addDTO);
        addDTO.setItem("关键词吃雪糕");
        todomvcService.add(addDTO);
        dump();

        // 修改一个
        System.out.println("---------- step 3 ----------");
        modifyEntity.setItem("任务1-修改");
        modifyEntity.setStatus(StatusEnum.TODOMVC_STATUS_COMPLETED);
        todomvcService.modify(modifyEntity);
        dump();

        // 删除一个
        System.out.println("---------- step 4 ----------");
        todomvcService.del(delEntity.getId());
        dump();

        // 条件查询 关键词吃 状态未完成
        System.out.println("---------- step 5 ----------");
        List<TodomvcEntity> list = todomvcService.find("吃",StatusEnum.TODOMVC_STATUS_ACTIVE);
        list.forEach(System.out::println);

        // 条件查询 状态已完成
        System.out.println("---------- step 6 ----------");
        list = todomvcService.find(null,StatusEnum.TODOMVC_STATUS_COMPLETED);
        list.forEach(System.out::println);

        System.out.println("----------END----------");
    }

    public void dump() {
        List<TodomvcEntity> list = todomvcService.findAll();
        System.out.println("---------- findAll >>>>>>>>>>");
        list.forEach(System.out::println);
        System.out.println("---------- findAll <<<<<<<<<<");
    }












    @Test
    public void demo() {
        System.out.println("----------END----------");
    }

}
