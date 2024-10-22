package dianafriptuleac.u5w1d2pizzaupdate.entities;

import dianafriptuleac.u5w1d2pizzaupdate.enums.StatoTavolo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tavolo {
    private int numero;
    private int nrMaxCoperti;
    private StatoTavolo stato;

    public Tavolo(int numero, int nrMaxCoperti, StatoTavolo stato) {
        this.numero = numero;
        this.nrMaxCoperti = nrMaxCoperti;
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Tavolo{" +
                "numero=" + numero +
                ", nrMaxCoperti=" + nrMaxCoperti +
                ", stato=" + stato +
                '}';
    }
}
