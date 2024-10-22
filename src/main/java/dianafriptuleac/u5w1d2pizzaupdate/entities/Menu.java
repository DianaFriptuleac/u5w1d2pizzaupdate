package dianafriptuleac.u5w1d2pizzaupdate.entities;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Pizze> allPizze;
    private List<Toppings> allToppings;
    private List<Bevande> allBevande;

    public Menu(List<Pizze> allPizze, List<Toppings> allToppings, List<Bevande> allBevande) {
        this.allPizze = new ArrayList<>(allPizze); // Usa ArrayList
        this.allToppings = new ArrayList<>(allToppings);
        this.allBevande = new ArrayList<>(allBevande);
    }

    public void stampaMenu() {
        System.out.println("Le nostre pizze:");
        allPizze.forEach(pizza -> System.out.println(pizza));

        System.out.println("\nCalorie delle pizze:");
        allPizze.forEach(pizza -> System.out.println(pizza.getCalorie()));

        System.out.println("\nPrezzo delle pizze:");
        allPizze.forEach(pizza -> System.out.println(pizza.getPrezzo() + "€"));

        System.out.println("\nCondimenti disponibili:");
        allToppings.forEach(topping -> System.out.println(topping));

        System.out.println("\nBevande:");
        allBevande.forEach(bevanda -> System.out.println(bevanda));
    }
}
