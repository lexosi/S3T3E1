package s3t3e1.GardenShop.domain;

import s3t3e1.GardenShop.domain.enums.Colours;
import s3t3e1.GardenShop.domain.enums.ProductType;

public class Flower extends Product {

    private Colours colour;

    public Flower(ProductType prodType, double price, String name, Colours colour) {
        super(prodType, price, name);
        this.colour = colour;
    }

    public Colours getColour() {
        return colour;
    }

    public void setColour(Colours colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return (super.toString() +
                "\nColour: " + this.colour);
    }

}
