package sample.models;

public class Plants {

    public int height;
    public String title;

    public Plants(String title, int height){

        /*this.setHeight(height);
        this.setTitle(title);*/

        this.title = title;
        this.height = height;

    }

    @Override
    public String toString(){

        return String.format("Растение %s высотой %s", title, height);

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return "";
    }

}
