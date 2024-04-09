package ru.sgu;

public class StockEntry implements Comparable<StockEntry> {
    private String ownerFullName;
    private String companyName;
    private int rating;

    public StockEntry(String ownerFullName, String companyName, int rating) {
        this.ownerFullName = ownerFullName;
        this.companyName = companyName;
        this.rating = rating;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public int compareTo(StockEntry o) {
        if (this.rating != o.rating) return o.rating - this.rating; 
        int surnameCompare = this.ownerFullName.split(" ")[0].compareTo(o.ownerFullName.split(" ")[0]); 
        if (surnameCompare != 0) return surnameCompare;
        int nameCompare = o.ownerFullName.split(" ")[1].compareTo(this.ownerFullName.split(" ")[1]); 
        if (nameCompare != 0) return nameCompare;
        return this.ownerFullName.split(" ")[2].compareTo(o.ownerFullName.split(" ")[2]); 
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockEntry)) return false;
        StockEntry that = (StockEntry) o;
        return ownerFullName.equals(that.ownerFullName) &&
               companyName.equals(that.companyName) &&
               rating == that.rating;
    }

    @Override
    public int hashCode() {
        return (ownerFullName + companyName + rating).hashCode();
    }

    @Override
    public String toString() {
        return ownerFullName + " " + companyName + " " + rating;
    }
}
