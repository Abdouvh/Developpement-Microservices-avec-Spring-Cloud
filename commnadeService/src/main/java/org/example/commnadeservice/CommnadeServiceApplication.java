package org.example.commnadeservice;

import org.example.commnadeservice.entities.Commande;
import org.example.commnadeservice.repository.CommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class CommnadeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommnadeServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandeLineRunner(CommandeRepository commandeRepository) {
        return args -> {
            // Initialisation des commandes
            commandeRepository.save(Commande.builder()
                    .description("Laptop")
                    .quantite(2)
                    .date(LocalDate.now().minusDays(5))
                    .montant(2000)
                    .build());

            commandeRepository.save(Commande.builder()
                    .description("Scanner")
                    .quantite(1)
                    .date(LocalDate.now().minusDays(10))
                    .montant(500)
                    .build());

            commandeRepository.save(Commande.builder()
                    .description("Mouse")
                    .quantite(1)
                    .date(LocalDate.now().minusDays(15))
                    .montant(300)
                    .build());

            commandeRepository.save(Commande.builder()
                    .description("Phone")
                    .quantite(1)
                    .date(LocalDate.now().minusDays(2))
                    .montant(1000)
                    .build());

            commandeRepository.save(Commande.builder()
                    .description("Server")
                    .quantite(1)
                    .date(LocalDate.now().minusDays(2))
                    .montant(1000)
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("KeyBoard")
                    .quantite(1)
                    .date(LocalDate.now().minusDays(2))
                    .montant(1000)
                    .build());

            // Affichage des commandes sauvegardées
            commandeRepository.findAll().forEach(c -> {
                System.out.println("===================================");
                System.out.println("ID: " + c.getId());
                System.out.println("Description: " + c.getDescription());
                System.out.println("Quantité: " + c.getQuantite());
                System.out.println("Date: " + c.getDate());
                System.out.println("Montant: " + c.getMontant());
                System.out.println("===================================");
            });
        };
    }

}
