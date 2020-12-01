package sample.models;

public class Bush extends Plants{

    public Boolean withFlowers;//с цветами
    int branchAmount;//к-во веток

    public Bush(String title, int height, Boolean withFlowers, int branchAmount){

        super(title, height);
        this.withFlowers = withFlowers;
        this.branchAmount = branchAmount;

    }

    public int getBranchAmount() {
        return branchAmount;
    }

    public void setBranchAmount(int branchAmount) {
        this.branchAmount = branchAmount;
    }

    public Boolean getWithFlowers() {
        return withFlowers;
    }

    public void setWithFlowers(boolean withFlowers) {
        this.withFlowers = withFlowers;
    }

    @Override
    public String getDescription() {
        String isWithFlowers = this.withFlowers ? "с цветами" : "без цветов";
        return String.format("Куст %s. Имеет %s веток."  , isWithFlowers, branchAmount);
    }

}
