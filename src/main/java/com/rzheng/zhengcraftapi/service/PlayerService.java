package com.rzheng.zhengcraftapi.service;

import com.rzheng.zhengcraftapi.model.Player;
import com.rzheng.zhengcraftapi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayer(UUID uid) {
        return playerRepository.findById(uid);
    }
}
