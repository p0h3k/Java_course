package ru.sgu;

public abstract class Teapot implements TeapotInterface, Comparable<Teapot> {
    protected int volume;
    protected String color;

    public Teapot(int volume, String color) {
        this.volume = volume;
        this.color = color;
    }

    @Override
    public abstract void boilWater();

    @Override
    public String toString() {
        return "Чайник {" +
               "объем=" + volume +
               " мл, цвет='" + color + '\'' +
               '}';
    }

    @Override
    public int compareTo(Teapot other) {
        return Integer.compare(this.volume, other.volume);
    }

    @Override
    public int hashCode() {
        return volume * color.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Teapot)) return false;
        Teapot other = (Teapot) obj;
        return volume == other.volume && color.equals(other.color);
    }
}
