package com.szl;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Handler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
        String path = t.getRequestURI().getPath();
        String httpMethod = t.getRequestMethod();
        Method[] methods = Routes.class.getMethods();
        Method method = findRoute(methods, path, httpMethod);
        String response = "page not found";
        if (method != null) {
            try {
                response = (String) method.invoke(new Routes());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private Method findRoute(Method[] methods, String path, String httpMethod) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(WebRoute.class)) {
                WebRoute annotation = method.getAnnotation(WebRoute.class);
                if (annotation.path().equals(path) && annotation.method().toString().equals(httpMethod)) {
                    return method;
                }
            }
        }
        return null;
    }
}
