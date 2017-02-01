package Impls.Info;

import Impls.Content.BaseContent;
import Impls.Head.BaseHead;
import Interface.Info;

/**
 * Created by sbt-vasyukov-sv on 26.01.2017.
 */
public class CurrencyInfo extends BaseInfo implements Info {
    public CurrencyInfo(BaseHead head, BaseContent content) {
        super(head, content);
    }

    @Override
    public void process() {
        System.out.println("Process CurrencyInfo");
        this.getContent().setContentname(" new 63.59 56.55");
    }
}
