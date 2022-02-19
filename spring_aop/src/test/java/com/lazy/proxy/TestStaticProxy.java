package com.lazy.proxy;

import com.lazy.proxy.staticproxy.GamePlayer;
import com.lazy.proxy.staticproxy.GameProxyPlayer;
import com.lazy.proxy.staticproxy.IGamePlayer;
import org.junit.Test;

public class TestStaticProxy {

    @Test
    public void testGamePlayer() {
        GamePlayer gamePlayer = new GamePlayer("小学徒");
        gamePlayer.start();
        gamePlayer.play();
    }

    @Test
    public void testGameProxyPlayer() {
        IGamePlayer gameProxyPlayer = new GameProxyPlayer("小学徒");
        gameProxyPlayer.start();
        gameProxyPlayer.play();
    }
}
