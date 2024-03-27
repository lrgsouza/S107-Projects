import com.strange.stuff.store.AlienArtifact;
import com.strange.stuff.store.Checkout;
import com.strange.stuff.store.ExoticCarnivorousPlant;
import com.strange.stuff.store.UrbanRaccoon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestStrangeStuffStore {

    Checkout checkout;
    UrbanRaccoon raccoon1;
    UrbanRaccoon raccoon2;
    ExoticCarnivorousPlant plant1;
    ExoticCarnivorousPlant plant2;
    AlienArtifact artifact1;
    AlienArtifact artifact2;

    @Before
    public void setUp() {
        this.checkout = new Checkout();
        this.raccoon1 = new UrbanRaccoon("Guaxinim Raivoso e Espumante", 29.99f, 2, "Um guaxinim de pelúcia selvagem e com raiva", "Pequeno", "Cinza");
        this.raccoon2 = new UrbanRaccoon("Guaxinim Urbano Peludo", 39.99f, 14, "Um guaxinim de pelúcia urbano com pelos longos", "Grande", "Marrom");
        this.plant1 = new ExoticCarnivorousPlant("Planta Carnívora Venus Flytrap", 19.99f, 3, "Uma planta carnívora exótica com armadilhas que se fecham rapidamente", "Dionaea muscipula", "Médio");
        this.plant2 = new ExoticCarnivorousPlant("Planta Carnívora Pitcher", 24.99f, 5, "Uma planta carnívora exótica com armadilhas em forma de jarro", "Nepenthes", "Alto");
        this.artifact1 = new AlienArtifact("Disco Voador em Miniatura", 49.99f, 1, "Uma réplica detalhada de um disco voador alienígena", "Desconhecido", "2001");
        this.artifact2 = new AlienArtifact("Cristal Energético Alienígena", 59.99f, 2, "Um cristal misterioso que emite uma luz estranha", "Planeta X", "2005");
    }

    @Test
    public void testAddToCart() {
        checkout.addToCart(raccoon1, 1);
        assertEquals(1, checkout.getCartSize());
    }

    @Test
    public void testCartPrice() {
        checkout.addToCart(raccoon1, 1);
        checkout.addToCart(raccoon2, 1);
        checkout.addToCart(plant1, 1);
        assertEquals(89.97f, checkout.calculateTotal(), 0.0001);
    }


    @Test
    public void testCartSize() {
        checkout.addToCart(raccoon1, 1);
        checkout.addToCart(raccoon2, 7);
        assertEquals(8, checkout.getCartSize());
    }

    @Test
    public void testRemoveFromCart() {
        checkout.addToCart(raccoon1, 1);
        checkout.removeFromCart(raccoon1);
        assertEquals(0, checkout.getCartSize());
    }

    @Test
    public void testClearCart() {
        checkout.addToCart(raccoon1, 1);
        checkout.addToCart(raccoon2, 1);
        checkout.addToCart(plant1, 1);
        checkout.addToCart(plant2, 18);
        checkout.addToCart(artifact1, 1);
        checkout.addToCart(artifact2, 25);
        checkout.clearCart();
        assertEquals(0, checkout.getCartSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveUnlistedItem() {
        checkout.removeFromCart(raccoon2);
    }

    @Test
    public void testAddToCartSameProduct() {
        checkout.addToCart(raccoon1, 1);
        checkout.addToCart(raccoon1, 7);
        assertEquals(8, checkout.getCartSize());
    }

    @Test
    public void testCartPriceAfterAddSameProduct() {
        checkout.addToCart(raccoon1, 5);
        checkout.addToCart(raccoon1, 2);
        assertEquals(209.93f, checkout.calculateTotal(), 0.0001);
    }

    @Test(expected = IllegalStateException.class)
    public void testCompleteEmptyCart() {
        checkout.completePurchase();
    }

    @Test
    public void testAddToCartNegativeQuantity() {
        checkout.addToCart(artifact1, 1);
        checkout.addToCart(artifact1, -1);
        assertEquals(0, checkout.getCartSize());
    }
}
