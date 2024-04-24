package me.kazura233.todomvc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.kazura233.todomvc.common.StatusEnum;

@Getter
@Setter
@ToString
@Entity
@Table(name = "todomvc")
public class TodomvcEntity extends BaseEntity {
    @Column(name = "item", unique = true, length = 233, nullable = false)
    private String item;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private StatusEnum status;
}
