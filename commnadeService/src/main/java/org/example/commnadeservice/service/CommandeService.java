package org.example.commnadeservice.service;


import org.example.commnadeservice.config.CommandeProperties;
import org.example.commnadeservice.entities.Commande;
import org.example.commnadeservice.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final CommandeProperties commandeProperties;

    public CommandeService(CommandeRepository commandeRepository, CommandeProperties commandeProperties) {
        this.commandeRepository = commandeRepository;
        this.commandeProperties = commandeProperties;
    }

    public List<Commande> getCommandesDerniersJours() {
        System.out.println("Valeur de commandesLast (propriété chargée) : " + commandeProperties.getCommandesLast());
        LocalDate dateLimite = LocalDate.now().minusDays(commandeProperties.getCommandesLast());
        System.out.println("Date limite calculée : " + dateLimite);
        List<Commande> commandes = commandeRepository.findCommandesDepuis(dateLimite);
        System.out.println("Commandes récupérées depuis la base : " + commandes);
        return commandes;
    }
}