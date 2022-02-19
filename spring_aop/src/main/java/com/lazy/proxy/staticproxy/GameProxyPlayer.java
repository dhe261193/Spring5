package com.lazy.proxy.staticproxy;

/**
* @Author: Lazy小学徒
* @Date: 2022/1/15 22:54
* @Description: 代练玩家
*/
public class GameProxyPlayer implements IGamePlayer{

    private String name;
    private GamePlayer gamePlayer;

    public GameProxyPlayer(String name) {
        this.name = name;
        this.gamePlayer = new GamePlayer(name);
    }

    @Override
    public void start() {
        System.out.println("拿到玩家：" + name + " 用户名密码");
        gamePlayer.start();
    }

    @Override
    public void play() {
        System.out.println("代练玩家击败了对手");
    }
}
