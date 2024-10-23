package dianafriptuleac.u5w1d2pizzaupdate;

import dianafriptuleac.u5w1d2pizzaupdate.entities.*;
import dianafriptuleac.u5w1d2pizzaupdate.enums.StatoTavolo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;


@SpringBootTest
class U5w1d2pizzaupdateApplicationTests {

    @Autowired
    private U5w1d2pizzaupdateApplication context;

    @Autowired
    private Menu menu;
    @Value("${coperto.costo}")
    private double costoCoperto;

    // 1.Controllo se la mia applicazione Spring si avvia correttamente
    @Test
    void contextLoads() {
        assertNotNull("Context", context);
    }

    // 2. Verifico il bean Menu- che non sia null
    @Test
    void menuInietatoCorrettamente() {
        assertNotNull("Ciao", menu);
    }

    // 3. Verifico se il calcolo del prezzo totale di un ordine sia corretto
    @Test
    void calcoloPrezzoTotateOrdine() {
        List<GenericClass> elOrdine = List.of(
                menu.getAllPizze().getFirst(), menu.getAllBevande().getFirst()
        );
        double totaleImporto = 0.0;
        for (GenericClass elemento : elOrdine) {
            totaleImporto += elemento.getPrezzo();
        }
        totaleImporto += (2 * costoCoperto);
        assertEquals(14.50, totaleImporto);
    }

    // 4. Verifico i prezzi diversi delle pizze con test parametrico
    @ParameterizedTest
    @CsvSource({"0, 6.50", "1, 7.50", "2, 8.50"})
    void prezzoPizze(int index, double prezzo) {
        Pizze pizza = menu.getAllPizze().get(index);

        assertEquals(prezzo, pizza.getPrezzo());
    }


    // 5. Veriffico se i campi dell'ordine  e creato

    @Test
    void creareOrdine() {
        List<GenericClass> elOrdine = List.of(
                menu.getAllPizze().get(0),  // Margherita
                menu.getAllBevande().get(0)  // Coca-Cola
        );

        Tavolo tav1 = new Tavolo(1, 3, StatoTavolo.OCCUPATO);
        Ordine ordine1 = new Ordine(1, tav1, elOrdine, 2, LocalDateTime.now());

        assertEquals(elOrdine, ordine1.getElementiOrdine());
        assertEquals(tav1, ordine1.getTavolo());
        assertEquals(ordine1.calcolaTotaleImporto(costoCoperto), ordine1.calcolaTotaleImporto(costoCoperto));
        assertEquals(2, ordine1.getNrCoperti());
    }
}



