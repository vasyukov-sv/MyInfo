package Impls.Info;

import Impls.Content.BaseContent;
import Impls.Head.BaseHead;
import Interface.Info;

/**
 * Created by sbt-vasyukov-sv on 26.01.2017.
 */
public abstract class BaseInfo implements Info {
    private BaseHead head;
    private BaseContent content;
    private String infoname;
    private String url;

    public BaseInfo(BaseHead head, BaseContent content) {
        this.head = head;
        this.content = content;
    }

    BaseHead getHead() {
        return head;
    }

    public void setHead(BaseHead head) {
        this.head = head;
    }

    BaseContent getContent() {
        return content;
    }

    public void setContent(BaseContent content) {
        this.content = content;
    }

    private String getInfoname() {
        return infoname;
    }

    public void setInfoname(String infoname) {
        this.infoname = infoname;
    }

    String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public void output() {
        System.out.println(this.getInfoname() + "(" + this.getUrl() + "):");
        this.getHead().output();
        System.out.print("-");
        this.getContent().output();
        System.out.println();
    }
}