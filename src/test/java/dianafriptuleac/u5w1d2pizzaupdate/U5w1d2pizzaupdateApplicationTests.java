package dianafriptuleac.u5w1d2pizzaupdate;

import dianafriptuleac.u5w1d2pizzaupdate.entities.*;
import dianafriptuleac.u5w1d2pizzaupdate.enums.StatoTavolo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class U5w1d2pizzaupdateApplicationTests {

    @Autowired
    private U5w1d2pizzaupdateApplication context;

    @Autowired
    private Menu menu;


    // 1.Controllo se la mia applicazione Spring si avvia correttamente
    @Test
    void contextLoads() {
        assertNotEquals(null, context);
    }

    // 2. Verifico il bean Menu- che non sia null
    @Test
    void menuInietatoCorrettamente() {
        assertNotEquals(null, menu);
    }

    // 3. Verifico se il calcolo del prezzo totale di un ordine sia corretto
    @Test
    void calcoloPrezzoTotateOrdine() {
        List<GenericClass> elOrdine = List.of(
                new Pizze("Margherita", 6.50, 1104, new ArrayList<>(), "Classica"),
                new Bevande("Coca-cola", 3.00, 150, 0.33)
        );
        double totaleImporto = 0.0;
        double costoCoperto = 2.50;
        for (GenericClass elemento : elOrdine) {
            totaleImporto += elemento.getPrezzo();
        }
        totaleImporto += (2 * costoCoperto);
        assertEquals(14.50, totaleImporto);
    }

    // 4. Verifico i prezzi diversi delle pizze con test parametrico
    @ParameterizedTest
    @CsvSource({"Margherita, 6.50", "Salame Piccante, 7.50", "Buffala, 8.50"})
    void prezzoPizze(String nomePizza, double prezzo) {
        Pizze pizza = switch (nomePizza) {
            case "Margherita" -> new Pizze("Margherita", 6.50, 1104, new ArrayList<>(), "Classica");
            case "Salame Piccante" -> new Pizze("Salame Piccante", 7.50, 1160, List.of("Salame Piccante"), "XL");
            case "Buffala" -> new Pizze("Buffala", 8.50, 1200, List.of("Buffala", "Pomodorini", "Rucola"), "Classica");
            default -> throw new IllegalArgumentException("Invalid pizza: " + nomePizza);
        };
        assertEquals(prezzo, pizza.getPrezzo());
    }

    // 5. Veriffico se i campi dell'ordine sono compilati correttamente e creato

    @Test
    void creareOrdine() {
        List<GenericClass> elOrdine = List.of(
                new Pizze("Margherita", 6.50, 1104, new ArrayList<>(), "Classica"),
                new Bevande("Coca-cola", 3.00, 150, 0.33)

        );
        Tavolo tav1 = new Tavolo(1, 3, StatoTavolo.OCCUPATO);
        Ordine ordine1 = new Ordine(1, tav1, elOrdine, 2, LocalDateTime.now(), 19);

        assertEquals(1, ordine1.getElementiOrdine());
        assertEquals(tav1, ordine1.getTavolo());
        assertEquals(19.00, ordine1.getTotaleImporto());
        assertEquals(2, ordine1.getNrCoperti());
    }
}



