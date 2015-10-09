/**
 * Created by Pavlik on 10/8/15.
 */


public class Name {

    private String name;
    private String surName;

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Name (String name, String surName) {

        this.setName(name);
        this.setSurName(surName);
    }
}
