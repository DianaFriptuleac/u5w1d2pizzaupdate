package dianafriptuleac.u5w1d2pizzaupdate.entities;


import java.util.List;


public class Pizze extends PizzaBase {
    private List<String> toppings;
    private String formatoPizza;

    public Pizze(String nome, double prezzo, int calorie, List<String> toppings, String formatoPizza) {
        super(nome, prezzo, calorie);
        this.toppings = toppings;
        this.formatoPizza = formatoPizza;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", Condimento aggiunto: " + (toppings.isEmpty() ? "nessuno" : String.join(", ", toppings)) +
                ", Formato pizza: " + formatoPizza;
    }
}
