public class TriParNote implements Tri {
    @Override
    public int comparer(Hébergement h1, Hébergement h2) {
        return Double.compare(h1.noteMoyenne, h2.noteMoyenne);
    }
}
