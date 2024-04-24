package me.kazura233.todomvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.kazura233.todomvc.common.StatusEnum;

@Setter
@Getter
@ToString
public class TodomvcModifyDTO {
    Long id;
    String item;
    StatusEnum status;
}
