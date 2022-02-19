package com.lazy.proxy.staticproxy;

/**
* @Author: Lazy小学徒
* @Date: 2022/1/15 22:53
* @Description: 玩家
*/
public class GamePlayer implements IGamePlayer{

    private String name;

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("菜鸟玩家：" + name + " 登录了游戏");
    }

    @Override
    public void play() {
        System.out.println("菜鸟玩家：" + name + " 被对手击败");
    }
}
