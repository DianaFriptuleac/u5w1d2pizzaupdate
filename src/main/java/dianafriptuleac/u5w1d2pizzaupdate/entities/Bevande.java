package dianafriptuleac.u5w1d2pizzaupdate.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Bevande extends GenericClass {
    private double quantita;

    public Bevande(String nome, double prezzo, int calorie, double quantita) {
        super(nome, prezzo, calorie);
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return nome + " (" + quantita + "L) - Prezzo: " + prezzo + "€, Calorie: " + calorie;
    }
}
