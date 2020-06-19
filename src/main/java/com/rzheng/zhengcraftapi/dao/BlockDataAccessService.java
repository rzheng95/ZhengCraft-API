package com.rzheng.zhengcraftapi.dao;

import com.rzheng.zhengcraftapi.model.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BlockDataAccessService implements BlockDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BlockDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Block> selectAllBlocks() {
        final String sql = "SELECT * FROM block";

        return jdbcTemplate.query(sql, (resultSet, i) -> new Block(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("material"),
                resultSet.getLong("blocks_placed"),
                resultSet.getLong("blocks_destroyed")
        ));
    }

    @Override
    public Optional<Block> selectBlockByUid(UUID uid) {
        final String sql = "SELECT * FROM block WHERE id = ?";

        Block block = jdbcTemplate.queryForObject(sql, new Object[]{uid}, (resultSet, i) -> new Block(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("material"),
                resultSet.getLong("blocks_placed"),
                resultSet.getLong("blocks_destroyed")
        ));

        return Optional.ofNullable(block);
    }


}
