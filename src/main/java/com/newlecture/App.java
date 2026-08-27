package com.newlecture;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class App {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.getConnector();

        String docBase = new File("src/main/webapp").getAbsolutePath();
        Context context = tomcat.addWebapp("", docBase);

        // [핵심] Maven/IDE 클래스로더를 Tomcat의 부모 클래스로더로 전달
        context.setParentClassLoader(App.class.getClassLoader());

        // target/classes 바인딩
        File classesDir = new File("target/classes");
        StandardRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(
                resources, "/WEB-INF/classes", classesDir.getAbsolutePath(), "/"));
        context.setResources(resources);

        System.out.println("==================================================");
        System.out.println("Tomcat Started: http://localhost:" + port + "/admin/menus/list");
        System.out.println("==================================================");

        tomcat.start();
        tomcat.getServer().await();
    }
}