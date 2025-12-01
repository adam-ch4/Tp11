package FFSSM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class PlongeurTest {
    private Plongeur plongeur;
    private Club club;

    @BeforeEach
    public void setUp() {
        plongeur = new Plongeur("1234567890123", "Dupont", "Jean",
                "12 rue de Paris", "0612345678",
                LocalDate.of(1990, 5, 15), 2);
        club = new Club("Club Subaquatique", "Paris", "0123456789");
    }

    @Test
    public void testCreationPlongeur() {
        assertEquals("Dupont", plongeur.getNom());
        assertEquals("Jean", plongeur.getPrenom());
        assertEquals(2, plongeur.getNiveau());
        assertNotNull(plongeur.getLicences());
        assertTrue(plongeur.getLicences().isEmpty());
    }

    @Test
    public void testAjouterLicence() {
        plongeur.ajouterLicence("LIC123", LocalDate.of(2024, 1, 15), club);

        assertEquals(1, plongeur.getLicences().size());
        Licence licence = plongeur.derniereLicence();
        assertNotNull(licence);
        assertEquals("LIC123", licence.getNumero());
        assertEquals(club, licence.getClub());
    }

    @Test
    public void testDerniereLicence() {
        assertNull(plongeur.derniereLicence());

        plongeur.ajouterLicence("LIC1", LocalDate.of(2023, 1, 1), club);
        plongeur.ajouterLicence("LIC2", LocalDate.of(2024, 1, 1), club);

        Licence derniere = plongeur.derniereLicence();
        assertEquals("LIC2", derniere.getNumero());
    }

    @Test
    public void testLicenceValide() {
        plongeur.ajouterLicence("LIC123", LocalDate.of(2024, 1, 15), club);

        assertTrue(plongeur.aUneLicenceValide(LocalDate.of(2024, 6, 15)));
        assertFalse(plongeur.aUneLicenceValide(LocalDate.of(2025, 2, 15)));
    }

    @Test
    public void testEstMoniteur() {
        assertFalse(plongeur.estMoniteur());

        DiplomeDeMoniteur diplome = new DiplomeDeMoniteur(
                DiplomeDeMoniteur.Niveau.E1,
                LocalDate.of(2023, 6, 1),
                plongeur);
        plongeur.ajouterDiplome(diplome);

        assertTrue(plongeur.estMoniteur());
    }
}