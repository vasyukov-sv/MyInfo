package Impls.Content;

import Interface.Content;

/**
 * Created by sbt-vasyukov-sv on 26.01.2017.
 */

public class BaseContent implements Content {
    private String contentname;

    public BaseContent() {
    }

    public BaseContent(String contentname) {
        this.contentname = contentname;
    }

    private String getContentname() {
        return contentname;
    }

    public void setContentname(String contentname) {
        this.contentname = contentname;
    }

    @Override
    public void output() {
        System.out.printf(this.getContentname());
    }
}