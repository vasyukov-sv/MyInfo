package Impls.Head;

import Interface.Head;

/**
 * Created by sbt-vasyukov-sv on 26.01.2017.
 */
@SuppressWarnings("ALL")
public class BaseHead implements Head {
    private String headname;

    public BaseHead() {
    }

    public BaseHead(String headname) {
        this.headname = headname;
    }

    private String getHeadname() {
        return headname;
    }

    public void setHeadname(String headname) {
        this.headname = headname;
    }

    @Override
    public void output() {
        System.out.printf(this.getHeadname());
    }
}
