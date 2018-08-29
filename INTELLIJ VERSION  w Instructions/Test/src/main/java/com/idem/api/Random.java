package com.idem.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Random {

    private String stuff;
    private String more;

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }
}
