package com.works.facade;

import java.util.Properties;

public class ServiceFacade {

    private static ServiceFacade applicationInstance;
    //private IPersonDao personDao = null;

    public static ServiceFacade getInstance(){
        if(applicationInstance == null)
            applicationInstance = new ServiceFacade();
        return applicationInstance;
    }

    public void start(Properties appProps){
        //TODO log
        try{

            //personDao = new PersonDaoImpl();
            // personDao.init(appProps);

        }catch(Exception e){
            //TODO Log
        }

    }

}
