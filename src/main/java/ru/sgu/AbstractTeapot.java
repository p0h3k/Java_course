package ru.sgu;

public abstract class AbstractTeapot implements TeapotInterface, Comparable<AbstractTeapot> {
    protected int volume;
    protected String color;

    public AbstractTeapot(int volume, String color) {
        this.volume = volume;
        this.color = color;
    }


    @Override
    public String toString() {
        return "Чайник {" +
               "объем=" + volume +
               " мл, цвет='" + color + '\'' +
               '}';
    }

    @Override
    public int compareTo(AbstractTeapot other) {
        int volumeComparison = Integer.compare(this.volume, other.volume);
        if (volumeComparison != 0) {
            return volumeComparison;
        }
        return this.color.compareTo(other.color);
    }

    @Override
    public int hashCode() {
        return 31 * volume + color.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbstractTeapot)) return false;
        AbstractTeapot other = (AbstractTeapot) obj;
        return volume == other.volume && color.equals(other.color);
    }
}
