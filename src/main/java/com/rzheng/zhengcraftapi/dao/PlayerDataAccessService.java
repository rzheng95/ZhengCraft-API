package com.rzheng.zhengcraftapi.dao;

import com.rzheng.zhengcraftapi.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PlayerDataAccessService implements PlayerDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlayerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Player> selectAllPlayers() {
        final String sql = "SELECT * FROM player";

        return jdbcTemplate.query(sql, (resultSet, i) ->
                new Player(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("name")
                )
        );

    }

    @Override
    public Optional<Player> selectPlayerByUid(UUID uid) {
        final String sql = "SELECT * FROM player WHERE id = ?";

        Player player = jdbcTemplate.queryForObject(sql, new Object[]{uid}, (resultSet, i) -> new Player(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("name")
        ));

        return Optional.ofNullable(player);
    }

    @Override
    public int updatePlayerByUid(UUID uid) {
        return 0;
    }

    @Override
    public int deletePlayerByUid(UUID uid) {
        final String sql = "DELETE FROM player WHERE id = ?";
        return jdbcTemplate.update(sql, uid);
    }
}
