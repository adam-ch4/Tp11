package FFSSM;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

    @Test
    public void testScenarioComplet() {
        // 1. Création d'un club
        Club club = new Club("Blue Diving", "Toulon", "0495123456");

        // 2. Création de moniteurs
        Plongeur moniteurPrincipal = new Plongeur("M001", "Moreau", "Jacques",
                "Toulon", "0611223344",
                LocalDate.of(1978, 4, 22), 4);
        moniteurPrincipal.ajouterDiplome(new DiplomeDeMoniteur(
                DiplomeDeMoniteur.Niveau.E4,
                LocalDate.of(2018, 3, 10),
                moniteurPrincipal));

        // 3. Création de plongeurs
        Plongeur plongeur1 = new Plongeur("P001", "Leroy", "Sophie",
                "Toulon", "0622334455",
                LocalDate.of(1995, 8, 30), 2);
        Plongeur plongeur2 = new Plongeur("P002", "Garcia", "Marc",
                "Toulon", "0633445566",
                LocalDate.of(1988, 12, 15), 3);

        // 4. Ajout des membres au club
        club.ajouteMembre(moniteurPrincipal);
        club.ajouteMembre(plongeur1);
        club.ajouteMembre(plongeur2);

        // 5. Embauche du moniteur
        club.nouvelleEmbauche(moniteurPrincipal, LocalDate.of(2024, 1, 1));

        // 6. Délivrance des licences
        LocalDate dateLicence = LocalDate.of(2024, 1, 15);
        moniteurPrincipal.ajouterLicence("LM001", dateLicence, club);
        plongeur1.ajouterLicence("LP001", dateLicence, club);
        plongeur2.ajouterLicence("LP002", dateLicence, club);

        // 7. Organisation d'une plongée
        Site site = new Site("Ile du Levant", "Hyères", 40);
        LocalDate datePlongee = LocalDate.of(2024, 6, 20);
        Plongee plongee = new Plongee(site, club, datePlongee,
                LocalTime.of(11, 0), 25, 50);

        plongee.setChefDePalanquee(moniteurPrincipal);
        plongee.ajouteParticipant(plongeur1);
        plongee.ajouteParticipant(plongeur2);

        club.organisePlongee(plongee);

        // 8. Vérifications
        assertTrue(plongee.estConforme());
        assertTrue(moniteurPrincipal.estMoniteur());
        assertTrue(plongeur1.aUneLicenceValide(datePlongee));
        assertTrue(plongeur2.aUneLicenceValide(datePlongee));
        assertEquals(3, club.getMembres().size());
        assertEquals(1, club.getPlongeesOrganisees().size());
        assertEquals(1, club.embauches().size());
        assertTrue(club.embauches().get(0).estEnCours(datePlongee));
    }
}