package com.szl;

public class Routes {

    @WebRoute()
    public static String routeMain() {
        return "This is the main page!";
    }

    @WebRoute(path = "/hello", method = WebRoute.HttpMethod.GET)
    public static String routeHello() {
        return "Hello!";
    }

    @WebRoute(path = "/hello/<name>", method = WebRoute.HttpMethod.GET)
    public static String routeHello(String name) {
        return "Hello!" + name;
    }

    @WebRoute(path = "/post", method = WebRoute.HttpMethod.POST)
    public static String routePost() {
        return "You posted it!";
    }

    @WebRoute(path = "/put", method = WebRoute.HttpMethod.PUT)
    public static String routePut() {
        return "Now we are putting something!";
    }

    @WebRoute(path = "/delete", method = WebRoute.HttpMethod.DELETE)
    public static String routeDelete() {
        return "Delete";
    }

}
