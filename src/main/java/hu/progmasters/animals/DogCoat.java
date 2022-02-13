package hu.progmasters.animals;

import hu.progmasters.enums.CoatColor;
import hu.progmasters.enums.CoatLength;
import hu.progmasters.enums.Shedding;

public class DogCoat {

    private CoatColor coatColor;
    private CoatLength coatLength;
    private Shedding shedding;

    public DogCoat(CoatColor coatColor, CoatLength coatLength, Shedding shedding) {
        this.coatColor = coatColor;
        this.coatLength = coatLength;
        this.shedding = shedding;
    }

    public CoatColor getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(CoatColor coatColor) {
        this.coatColor = coatColor;
    }

    public CoatLength getCoatLength() {
        return coatLength;
    }

    public void setCoatLength(CoatLength coatLength) {
        this.coatLength = coatLength;
    }

    public Shedding getShedding() {
        return shedding;
    }

    public void setShedding(Shedding shedding) {
        this.shedding = shedding;
    }
}


