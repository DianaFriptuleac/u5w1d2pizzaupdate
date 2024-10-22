package dianafriptuleac.u5w1d2pizzaupdate.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class GenericClass {
    protected String nome;
    protected double prezzo;
    protected int calorie;
}
