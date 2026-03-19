public class TriParPrix implements Tri {
    @Override
    public int comparer(Hébergement h1, Hébergement h2) {
        return Double.compare(h1.getPrixParNuit(), h2.getPrixParNuit());
    }
}
