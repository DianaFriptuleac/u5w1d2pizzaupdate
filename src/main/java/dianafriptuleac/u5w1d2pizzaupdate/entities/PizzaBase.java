package dianafriptuleac.u5w1d2pizzaupdate.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PizzaBase extends GenericClass {
    protected String pomodoro;
    protected String mozzarella;

    public PizzaBase(String nome, double prezzo, int calorie) {
        super(nome, prezzo, calorie);
        this.pomodoro = "Pomodoro";
        this.mozzarella = "Mozzarella";
    }

    @Override
    public String toString() {
        return "Nome: '" + nome + '\'' +
                ", Prezzo: " + prezzo +
                "€ , Calorie: " + calorie +
                ", Condimenti: '" + pomodoro + '\'' +
                ", '" + mozzarella + '\'';
    }
}

