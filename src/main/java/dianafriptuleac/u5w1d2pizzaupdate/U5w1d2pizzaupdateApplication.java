package dianafriptuleac.u5w1d2pizzaupdate;

import dianafriptuleac.u5w1d2pizzaupdate.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class U5w1d2pizzaupdateApplication {

    public static void main(String[] args) {
        SpringApplication.run(U5w1d2pizzaupdateApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(U5w1d2pizzaupdateApplication.class);

        Menu menu = context.getBean(Menu.class);
        menu.stampaMenu();

        context.close();
    }
}


