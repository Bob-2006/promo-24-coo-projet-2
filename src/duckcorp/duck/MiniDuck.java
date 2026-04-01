package duckcorp.duck;

/**
 * Canard en plastique miniature.
 *
 * TODO (Ex1) :
 *   - Faites hériter cette classe de Duck
 *   - Implémentez le constructeur MiniDuck(int qualityScore) avec un appel à super
 *   - Implémentez getBasePrice() et describe()
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class MiniDuck extends Duck {
    public static final double BASE_PRICE = 12.0;

    public StandardDuck(int qualityScore) {
        super(DuckType.STANDARD, qualityScore);
    }

    @Override
    public double getBasePrice() { return BASE_PRICE; }

    @Override
    public String describe() { return "Mini Canard"; }
}