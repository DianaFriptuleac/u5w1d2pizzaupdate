package dianafriptuleac.u5w1d2pizzaupdate;

import dianafriptuleac.u5w1d2pizzaupdate.entities.GenericClass;
import dianafriptuleac.u5w1d2pizzaupdate.entities.Menu;
import dianafriptuleac.u5w1d2pizzaupdate.entities.Ordine;
import dianafriptuleac.u5w1d2pizzaupdate.entities.Tavolo;
import dianafriptuleac.u5w1d2pizzaupdate.enums.StatoTavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component  //componente gestito da Spring
@PropertySource("application.properties")
// Annotazione fondamentale se vogliamo leggere i valori direttamente da application properties tramite @Value
public class MyRunner implements CommandLineRunner {

    //iniettare il bean Menu
    @Autowired
    private Menu myMenu;

    //inietto il valore del application.properties nella variabile costoCoperto
    @Value("${coperto.costo}")
    private double costoCoperto;

    @Override
    public void run(String... args) throws Exception {
        //  tavolo
        Tavolo t1 = new Tavolo(3, 5, StatoTavolo.OCCUPATO);

        // elementi
        List<GenericClass> elementiOrdine = new ArrayList<>();  //lista vuota
        elementiOrdine.add(myMenu.getAllPizze().get(2)); // Buffala
        elementiOrdine.add(myMenu.getAllBevande().get(1)); // birra
        elementiOrdine.add(myMenu.getAllPizze().get(0));
        elementiOrdine.add(myMenu.getAllBevande().get(2));


        System.out.println("Costo coperto " + costoCoperto);

        double totaleImporto = 0.0;
        for (GenericClass elemento : elementiOrdine) {
            totaleImporto += elemento.getPrezzo();
        }
        totaleImporto += (2 * costoCoperto);  //ho 2 coperti


        //ordine
        Ordine ordine = new Ordine(1, t1, elementiOrdine, 2, LocalDateTime.now(), totaleImporto);

        System.out.println(ordine);
    }
}
