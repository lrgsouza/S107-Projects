package com.strange.stuff.store;

public class Main {
    public static void main(String[] args) {
        UrbanRaccoon raccoon1 = new UrbanRaccoon("Guaxinim Raivoso e Espumante", 29.99f, 2, "Um guaxinim de pelúcia selvagem e com raiva", "Pequeno", "Cinza");
        UrbanRaccoon raccoon2 = new UrbanRaccoon("Guaxinim Urbano Peludo", 39.99f, 14, "Um guaxinim de pelúcia urbano com pelos longos", "Grande", "Marrom");

        ExoticCarnivorousPlant plant1 = new ExoticCarnivorousPlant("Planta Carnívora Venus Flytrap", 19.99f, 3, "Uma planta carnívora exótica com armadilhas que se fecham rapidamente", "Dionaea muscipula", "Médio");
        ExoticCarnivorousPlant plant2 = new ExoticCarnivorousPlant("Planta Carnívora Pitcher", 24.99f, 5, "Uma planta carnívora exótica com armadilhas em forma de jarro", "Nepenthes", "Alto");

        AlienArtifact artifact1 = new AlienArtifact("Disco Voador em Miniatura", 49.99f, 1, "Uma réplica detalhada de um disco voador alienígena", "Desconhecido", "2001");
        AlienArtifact artifact2 = new AlienArtifact("Cristal Energético Alienígena", 59.99f, 2, "Um cristal misterioso que emite uma luz estranha", "Planeta X", "2005");

        // Create Cart instance
        Checkout checkout = new Checkout();

        // Add products
        checkout.addToCart(raccoon1, 1);
        checkout.addToCart(plant1, 2);
        checkout.addToCart(plant2, 1);
        checkout.addToCart(artifact1, 1);
        checkout.addToCart(artifact2, 2);

        // Show itens in cart
        checkout.displayCart();

        // Finish purchase
        checkout.completePurchase();
    }
}