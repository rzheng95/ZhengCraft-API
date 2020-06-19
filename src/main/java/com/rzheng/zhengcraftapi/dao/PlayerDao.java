package com.rzheng.zhengcraftapi.dao;

import com.rzheng.zhengcraftapi.model.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerDao {

    List<Player> selectAllPlayers();

    Optional<Player> selectPlayerByUid(UUID uid);

    int updatePlayerByUid(UUID uid);

    int deletePlayerByUid(UUID uid);
}
