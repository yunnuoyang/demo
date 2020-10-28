package com.ivertx.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

/**
 * @Author yunnuo.yang
 * @Date 2020/10/28 13:32
 * @Description
 **/
public class VertxHelloWorld extends AbstractVerticle {

    public static void main(String[] args) {

        Vertx vertx=Vertx.vertx();
        vertx.deployVerticle(new VertxHelloWorld());
    }


    @Override
    public void start() throws Exception {

        Router router = Router.router(vertx);

        router.route().handler(routingContext -> {
            routingContext.response().putHeader("content-type", "text/html").end("Hello World!");
        });

        vertx.createHttpServer().requestHandler(router).listen(8080);
    }

}
