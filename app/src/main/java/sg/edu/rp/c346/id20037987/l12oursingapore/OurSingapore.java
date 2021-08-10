package sg.edu.rp.c346.id20037987.l12oursingapore;

import java.io.Serializable;

public class OurSingapore implements Serializable {

    private int id;
    private String name;
    private String desc;
    private int size;
    private int stars;

    public OurSingapore(String name, String desc, int size, int stars) {
        this.name = name;
        this.desc = desc;
        this.size = size;
        this.stars = stars;
    }

    public OurSingapore(int id, String name, String desc, int size, int stars) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.size = size;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public OurSingapore setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OurSingapore setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public OurSingapore setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public int getSize() {
        return size;
    }

    public OurSingapore setSize(int size) {
        this.desc = desc;
        return this;
    }

    public int getStars() {
        return stars;
    }

    public OurSingapore setStars(int stars) {
        this.stars = stars;
        return this;
    }

    @Override
    public String toString() {
        String starsString = "";
        if (stars == 5){
            starsString = "* * * * *";
        } else if (stars == 4){
            starsString = "* * * *";
        } else if (stars == 3){
            starsString = "* * *";
        } else if (stars == 2){
            starsString = "* *";
        } else if (stars == 1){
            starsString = "*";
        }
        return starsString;
        //or
        /*for(int i = 0; i < stars; i++){
            starsString += "*";
        }
        return title + "\n" + singers + " - " + yearReleased + "\n" + starsString;*/

    }

}
