package ru.sgu;

public class ElectricTeapot extends Teapot {
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
    public ElectricTeapot copy() {
 	return new ElectricTeapot(this.volume, new String(this.color), this.power);
    }
}
