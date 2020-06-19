package com.rzheng.zhengcraftapi.service;

import com.rzheng.zhengcraftapi.model.Block;
import com.rzheng.zhengcraftapi.model.BlockId;
import com.rzheng.zhengcraftapi.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlockService {
    @Autowired
    private BlockRepository blockRepository;

    public List<Block> getBlocks() {
        return blockRepository.findAll();
    }

    public Optional<Block> getBlock(BlockId blockId) {
        return blockRepository.findById(blockId);
    }
}
