import java.util.Comparator;

public class WineComparator implements Comparator<Wine> {
    // implement comparator interface to compare 2 objects from Star class based on temperature (numerical attribute)
    @Override
    public int compare(Wine w1, Wine w2) {
        return Double.compare(w1.getQuality(), w2.getQuality());
    }
}