package main;

import Impls.Info.CurrencyInfo;
import Impls.Info.WorldTimeInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sbt-vasyukov-sv on 23.01.2017 12:10
 */
class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        CurrencyInfo currencyInfo = (CurrencyInfo) context.getBean("currency");
        currencyInfo.process();
        currencyInfo.output();
        WorldTimeInfo worldTimeInfo = (WorldTimeInfo) context.getBean("worldtime");
        worldTimeInfo.process();
        worldTimeInfo.output();
    }
}