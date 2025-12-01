package FFSSM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class PlongeeTest {
    private Site site;
    private Club club;
    private Plongeur moniteur;
    private Plongeur plongeur1;
    private Plongeur plongeur2;

    @BeforeEach
    public void setUp() {
        site = new Site("Calanque de Sormiou", "Marseille", 30);
        club = new Club("Club Méditerranée", "Marseille", "0412345678");

        // Création d'un moniteur
        moniteur = new Plongeur("M001", "Durand", "Pierre",
                "Marseille", "0623456789",
                LocalDate.of(1980, 5, 10), 4);
        moniteur.ajouterDiplome(new DiplomeDeMoniteur(
                DiplomeDeMoniteur.Niveau.E3,
                LocalDate.of(2020, 6, 1),
                moniteur));

        // Création de plongeurs
        plongeur1 = new Plongeur("P001", "Martin", "Luc",
                "Marseille", "0634567890",
                LocalDate.of(1995, 3, 15), 2);
        plongeur2 = new Plongeur("P002", "Bernard", "Marie",
                "Marseille", "0645678901",
                LocalDate.of(1990, 7, 20), 3);
    }

    @Test
    public void testCreationPlongee() {
        Plongee plongee = new Plongee(site, club,
                LocalDate.of(2024, 6, 15),
                LocalTime.of(10, 30), 20, 45);

        assertEquals(site, plongee.getLieu());
        assertEquals(club, plongee.getOrganisateur());
        assertEquals(LocalDate.of(2024, 6, 15), plongee.getDate());
        assertEquals(20, plongee.getProfondeur());
        assertEquals(45, plongee.getDuree());
    }

    @Test
    public void testAjouterParticipant() {
        Plongee plongee = new Plongee(site, club,
                LocalDate.of(2024, 6, 15),
                LocalTime.of(10, 30), 20, 45);

        plongee.ajouteParticipant(plongeur1);
        plongee.ajouteParticipant(plongeur2);

        assertEquals(2, plongee.getParticipants().size());
        assertTrue(plongee.getParticipants().contains(plongeur1));
        assertTrue(plongee.getParticipants().contains(plongeur2));
    }

    @Test
    public void testPlongeeConforme() {
        Plongee plongee = new Plongee(site, club,
                LocalDate.of(2024, 6, 15),
                LocalTime.of(10, 30), 20, 45);

        // Ajout des licences valides
        moniteur.ajouterLicence("LM001", LocalDate.of(2024, 1, 1), club);
        plongeur1.ajouterLicence("LP001", LocalDate.of(2024, 1, 1), club);
        plongeur2.ajouterLicence("LP002", LocalDate.of(2024, 1, 1), club);

        // Configuration de la plongée
        plongee.setChefDePalanquee(moniteur);
        plongee.ajouteParticipant(plongeur1);
        plongee.ajouteParticipant(plongeur2);

        assertTrue(plongee.estConforme());
    }

    @Test
    public void testPlongeeNonConformeSansChefMoniteur() {
        Plongee plongee = new Plongee(site, club,
                LocalDate.of(2024, 6, 15),
                LocalTime.of(10, 30), 20, 45);

        // Plongeur1 n'est pas moniteur
        plongeur1.ajouterLicence("LP001", LocalDate.of(2024, 1, 1), club);
        plongee.setChefDePalanquee(plongeur1);

        assertFalse(plongee.estConforme());
    }

    @Test
    public void testPlongeeNonConformeProfondeurExcessive() {
        Plongee plongee = new Plongee(site, club,
                LocalDate.of(2024, 6, 15),
                LocalTime.of(10, 30), 35, 45); // 35m > 30m max

        moniteur.ajouterLicence("LM001", LocalDate.of(2024, 1, 1), club);
        plongee.setChefDePalanquee(moniteur);

        assertFalse(plongee.estConforme());
    }
}