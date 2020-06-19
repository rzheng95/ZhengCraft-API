package com.rzheng.zhengcraftapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(BlockId.class)
public class Block {
    @Id
    private UUID id;
    @Id
    private String material;
    private long blocks_placed;
    private long blocks_destroyed;
}
