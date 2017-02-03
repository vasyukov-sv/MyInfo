package Impls.Info;

import Impls.CB.CBcourse;
import Impls.Content.BaseContent;
import Impls.Head.BaseHead;
import Interface.Info;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sbt-vasyukov-sv on 26.01.2017 11:20.
 * Process Currence output.
 */
public class CurrencyInfo extends BaseInfo implements Info {
    public CurrencyInfo(BaseHead head, BaseContent content) {
        super(head, content);
    }

    @Override
    public void process() {
        ApplicationContext context = new ClassPathXmlApplicationContext("currency.xml");
        CBcourse cbcourse = (CBcourse) context.getBean("cbCourse");
        String courseString = cbcourse.get();
        getContent().setContentname(courseString);
    }
}