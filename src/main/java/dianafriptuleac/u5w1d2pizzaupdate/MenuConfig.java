package dianafriptuleac.u5w1d2pizzaupdate;

import dianafriptuleac.u5w1d2pizzaupdate.entities.Bevande;
import dianafriptuleac.u5w1d2pizzaupdate.entities.Menu;
import dianafriptuleac.u5w1d2pizzaupdate.entities.Pizze;
import dianafriptuleac.u5w1d2pizzaupdate.entities.Toppings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MenuConfig {

    //-----------------Prova 1 con beans con nome personalizzato
    @Bean(name = "pizzaMargherita")
    public Pizze margherita() {
        return new Pizze("Margherita", 6.50, 1104, new ArrayList<>(), "Classica");
    }

    @Bean(name = "pizzaSalamePiccante")
    public Pizze salamePiccante() {
        return new Pizze("Salame Piccante", 7.50, 1160, new ArrayList<>(List.of("Salame Piccante")), "XL");
    }

    @Bean(name = "pizzaBuffala")
    public Pizze buffala() {
        return new Pizze("Buffala", 8.50, 1200, new ArrayList<>(List.of("Buffala", "Pomodorini", "Rucola")), "Classica");
    }

    //Toppings
    @Bean(name = "toppingBuffala")
    public Toppings tBuffala() {
        return new Toppings("Buffala", 1.50, 102);
    }

    @Bean(name = "toppingSalamePiccante")
    public Toppings tSalamePiccante() {
        return new Toppings("Salame Piccante", 1.00, 90);
    }

    @Bean(name = "toppingFunghi")
    public Toppings tFunghi() {
        return new Toppings("Funghi", 1.00, 70);
    }

    @Bean(name = "toppingRucola")
    public Toppings tRucola() {
        return new Toppings("Rucola", 0.50, 20);
    }

    // Bevande
    @Bean(name = "bevandaCocaCola")
    public Bevande cocaCola() {
        return new Bevande("Coca-Cola", 3.00, 150, 0.33);
    }

    @Bean(name = "bevandaBirra")
    public Bevande birra() {
        return new Bevande("Birra", 4.50, 120, 0.66);
    }

    @Bean(name = "bevandaAcqua")
    public Bevande acqua() {
        return new Bevande("Acqua", 1.50, 0, 0.5);
    }

    //Creo il menu
    @Bean
    public Menu myMenu() {
        List<Pizze> allPizze = new ArrayList<>(List.of(margherita(), salamePiccante(), buffala()));
        List<Toppings> allToppings = new ArrayList<>(List.of(tFunghi(), tSalamePiccante(), tBuffala(), tRucola()));
        List<Bevande> allBevande = new ArrayList<>(List.of(cocaCola(), birra(), acqua()));


        return new Menu(allPizze, allToppings, allBevande);
    }



   /* @Bean
    public List<Pizze> allPizze() {
        List<Pizze> pizze = new ArrayList<>();
        pizze.add(new Pizze("Margherita", 6.50, 1104, new ArrayList<>(), "Classica"));
        pizze.add(new Pizze("Salame Piccante", 7.50, 1160, new ArrayList<>(List.of("Salame Piccante")), " XL"));
        pizze.add(new Pizze("Buffala", 8.50, 1200, new ArrayList<>(List.of("Buffala", "Pomodorini", "Rucola")), "Classica"));
        return pizze;
    }


    @Bean
    public List<Bevande> allBevande() {
        List<Bevande> bevande = new ArrayList<>();
        bevande.add(new Bevande("Coca-Cola", 3.00, 150, 0.33));
        bevande.add(new Bevande("Birra", 4.50, 120, 0.66));
        bevande.add(new Bevande("Acqua", 1.50, 0, 0.5));
        return bevande;
    }


    @Bean
    public List<Toppings> allToppings() {
        List<Toppings> toppings = new ArrayList<>();
        toppings.add(new Toppings("Buffala", 1.50, 102));
        toppings.add(new Toppings("Salame Piccante", 1.00, 90));
        toppings.add(new Toppings("Funghi", 1.00, 70));
        toppings.add(new Toppings("Rucola", 0.50, 20));
        return toppings;
    }

    // Bean per il menu
    @Bean
    public Menu myMenu(List<Pizze> allPizze, List<Toppings> allToppings, List<Bevande> allBevande) {
        return new Menu(allPizze, allToppings, allBevande);
    }*/

}



