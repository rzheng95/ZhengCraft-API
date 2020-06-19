package com.rzheng.zhengcraftapi.controller;

import com.rzheng.zhengcraftapi.model.Player;
import com.rzheng.zhengcraftapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("{uid}")
    public Player getPlayer(@PathVariable("uid") UUID uid) {
        return playerService.getPlayer(uid).orElse(null);
    }

}
