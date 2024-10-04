package com.works.configs;

import com.works.facade.ServiceFacade;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Properties appProps = null;
        try {
            appProps = new Properties();
            String appPropsPath = sce.getServletContext().getRealPath("/WEB-INF/classes/db.properties");


            File f = new File(appPropsPath);
            if (f.exists() && !f.isDirectory()) {
                try {
                    FileInputStream fis = new FileInputStream(f);
                    appProps.load(fis);

                    fis.close();
                } catch (IOException e) {
                    //TODO log
                }
            } else {
                //TODO log
            }

            ServiceFacade.getInstance().start(appProps);
        } catch (Exception e) {
            //TODO log
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
