package model;

import java.io.Serializable;

public class functionalDescription extends Description implements Serializable {

    private String who;
    private String what;
    private String why;

    public functionalDescription(String[] description)
    {
        super(true);
        this.who = description[0];
        this.what = description[1];
        this.why = description[2];
    }

    public void setFunctionalDescription(String who, String what, String why)
    {
        this.who = who;
        this.what = what;
        this.why = why;
    }

    @Override
    public String[] getDescription()
    {
        String[] output = new String[3];

        output[0] = who;
        output[1] = what;
        output[2] = why;

        return output;
    }

    public String toString()
    {
        return "who: " + who +
                ", what: " + what +
                ", why: " + why;
    }
}
