package com.rzheng.zhengcraftapi.repository;

import com.rzheng.zhengcraftapi.model.Block;
import com.rzheng.zhengcraftapi.model.BlockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends JpaRepository<Block, BlockId> {
}
