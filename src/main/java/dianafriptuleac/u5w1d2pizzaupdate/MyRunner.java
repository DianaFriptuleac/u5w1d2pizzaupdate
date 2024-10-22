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

@Component
@PropertySource("application.properties")
public class MyRunner implements CommandLineRunner {

    @Autowired
    private Menu myMenu;

    @Value("${coperto.costo}")
    private double costoCoperto;

    @Override
    public void run(String... args) throws Exception {
        //  tavolo
        Tavolo t1 = new Tavolo(3, 5, StatoTavolo.OCCUPATO);

        // elementi
        List<GenericClass> elementiOrdine = new ArrayList<>();
        elementiOrdine.add(myMenu.getAllPizze().get(2)); // Buffala
        elementiOrdine.add(myMenu.getAllBevande().get(1)); // birra

        // Importo
        double totaleImporto = elementiOrdine.stream().mapToDouble(GenericClass::getPrezzo).sum() + (2 * costoCoperto); // 2 coperti

        //ordine
        Ordine ordine = new Ordine(1, t1, elementiOrdine, 2, LocalDateTime.now(), totaleImporto);

        System.out.println(ordine);
    }
}
