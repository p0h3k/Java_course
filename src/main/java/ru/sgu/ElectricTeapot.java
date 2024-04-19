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
        ElectricTeapot other = (ElectricTeapot) obj;
        return this.volume == other.volume && 
               this.color.equals(other.color) && 
               this.power == other.power;
    }
    @Override
    public int hashCode() {
        int result = Integer.hashCode(volume);  
        result = 31 * result + color.hashCode();  
        result = 31 * result + Integer.hashCode(power); 
        return result;
    }

    public ElectricTeapot copy() {
        return new ElectricTeapot(this.volume, this.color, this.power);
    }
}
