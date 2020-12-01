package sample.models;

public class Flowers extends Plants{

    public int sheetAmount;//к-во листьев
    public String color;// цвет
    public enum Type {annuals, perennials, biennials;}// ежегодники, многолетние, двулетние
    public Type type;

    public Flowers(String title, int height, int sheetAmount, String color ,Type type){

        super(title, height);
        this.sheetAmount = sheetAmount;
        this.color = color;
        this.type = type;

    }

    public int getSheetAmount() {
        return sheetAmount;
    }

    public void setSheetAmount(int sheetAmount) {
        this.sheetAmount = sheetAmount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        String typeString = "";
        switch (this.type)
        {
            case annuals:
                typeString = "ежегодный";
                break;
            case perennials:
                typeString = "многолетний";// ежегодники, многолетние, двулетние
                break;
            case biennials:
                typeString = "двулетний";
                break;
        }
        return String.format("Цветок типа %s. Имеет %s цвет и %s листьев."  , typeString, color, sheetAmount);
    }

}
