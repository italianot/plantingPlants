package sample.models;

public class Trees extends Plants{

    public enum Type {coniferous, leaf;}// хвойное, листовое
    public Trees.Type type;
    public int radius;

    public Trees(String title, int height, Trees.Type type, int radius){

        super(title, height);
        this.type = type;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Trees.Type getType() {
        return type;
    }

    public void setType(Trees.Type type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        String typeString = "";
        switch (this.type)
        {
            case coniferous:
                typeString = "хвойное";
                break;
            case leaf:
                typeString = "листовое";// хвойное, листовое
                break;
        }
        return String.format("Дерево типа %s. Радиус ствола %s."  , typeString, radius);
    }
}
