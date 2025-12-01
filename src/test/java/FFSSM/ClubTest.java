package FFSSM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class ClubTest {
    private Club club;
    private Plongeur moniteur;
    private Plongeur plongeur;

    @BeforeEach
    public void setUp() {
        club = new Club("Aqua Club", "Nice", "0498765432");

        moniteur = new Plongeur("M001", "Robert", "Jean",
                "Nice", "0654321987",
                LocalDate.of(1975, 8, 12), 4);
        moniteur.ajouterDiplome(new DiplomeDeMoniteur(
                DiplomeDeMoniteur.Niveau.E2,
                LocalDate.of(2019, 5, 15),
                moniteur));

        plongeur = new Plongeur("P001", "Dubois", "Anne",
                "Nice", "0678912345",
                LocalDate.of(1992, 11, 5), 2);
    }

    @Test
    public void testCreationClub() {
        assertEquals("Aqua Club", club.getNom());
        assertEquals("Nice", club.getAdresse());
        assertEquals("0498765432", club.getTelephone());
        assertNotNull(club.getMembres());
        assertTrue(club.getMembres().isEmpty());
    }

    @Test
    public void testAjouterMembre() {
        club.ajouteMembre(plongeur);

        assertEquals(1, club.getMembres().size());
        assertTrue(club.getMembres().contains(plongeur));
    }

    @Test
    public void testOrganiserPlongee() {
        Site site = new Site("Baie des Anges", "Nice", 25);
        Plongee plongee = new Plongee(site, club,
                LocalDate.of(2024, 7, 10),
                LocalTime.of(9, 0), 15, 60);

        club.organisePlongee(plongee);

        assertEquals(1, club.getPlongeesOrganisees().size());
        assertTrue(club.getPlongeesOrganisees().contains(plongee));
    }

    @Test
    public void testNouvelleEmbauche() {
        club.nouvelleEmbauche(moniteur, LocalDate.of(2024, 1, 1));

        assertEquals(1, club.embauches().size());
        Embauche embauche = club.embauches().get(0);

        assertEquals(moniteur, embauche.getEmploye());
        assertEquals(club, embauche.getEmployeur());
        assertEquals(LocalDate.of(2024, 1, 1), embauche.getDebut());
        assertTrue(embauche.estEnCours());
    }

    @Test
    public void testEmbaucheNonMoniteur() {
        // plongeur n'est pas moniteur
        club.nouvelleEmbauche(plongeur, LocalDate.of(2024, 1, 1));

        assertTrue(club.embauches().isEmpty());
    }
}