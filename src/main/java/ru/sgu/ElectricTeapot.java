package ru.sgu;

import java.util.Objects;

public class ElectricTeapot extends AbstractTeapot {
    private int power; // Мощность в Ваттах

    public ElectricTeapot(int volume, String color, int power) {
        super(volume, color);
        this.power = power;
    }

    @Override
    public void boilWater() {
        System.out.println("Чайник кипятит воду с мощностью " + power + " Ватт и активно шумит!");
    }

    @Override
    public String toString() {
        return super.toString() + ", мощность=" + power + " Ватт";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ElectricTeapot)) return false;
        if (!super.equals(obj)) return false; 
        ElectricTeapot other = (ElectricTeapot) obj;
        return power == other.power;
}
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + power;
    }

    public ElectricTeapot copy() {
        return new ElectricTeapot(this.volume, this.color, this.power);
    }
}
