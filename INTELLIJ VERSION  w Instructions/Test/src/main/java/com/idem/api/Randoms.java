package com.idem.api;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Randoms {

    private List<Random> randoms;

    public List<Random> getRandoms() {
        return randoms;
    }

    public void setRandoms(List<Random> randoms) {
        this.randoms = randoms;
    }
}
