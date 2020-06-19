package com.rzheng.zhengcraftapi.dao;

import com.rzheng.zhengcraftapi.model.Block;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BlockDao {
    List<Block> selectAllBlocks();

    Optional<Block> selectBlockByUid(UUID uid);

}
