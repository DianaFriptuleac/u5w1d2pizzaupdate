package dianafriptuleac.u5w1d2pizzaupdate.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Ordine {
    private int nrOrdine;
    private Tavolo tavolo;
    private List<GenericClass> elementiOrdine;
    private int nrCoperti;
    private LocalDateTime oraAquisto;


    public Ordine(int nrOrdine, Tavolo tavolo, List<GenericClass> elementiOrdine, int nrCoperti,
                  LocalDateTime oraAquisto) {
        this.nrOrdine = nrOrdine;
        this.tavolo = tavolo;
        this.elementiOrdine = elementiOrdine;
        this.nrCoperti = nrCoperti;
        this.oraAquisto = oraAquisto;

    }

    public double calcolaTotaleImporto(double costoCoperto) {
        double totaleImporto = 0.0;
        for (GenericClass elemento : elementiOrdine) {
            totaleImporto += elemento.getPrezzo();
        }
        totaleImporto += (nrCoperti * costoCoperto);
        return totaleImporto;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "nrOrdine=" + nrOrdine +
                ", tavolo=" + tavolo +
                ", elementiOrdine=" + elementiOrdine +
                ", nrCoperti=" + nrCoperti +
                ", oraAquisto=" + oraAquisto +
                ", totaleImporto=" + calcolaTotaleImporto(0) +
                '}';
    }
}
