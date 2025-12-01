package FFSSM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class LicenceTest {
    private Plongeur plongeur;
    private Club club;

    @BeforeEach
    public void setUp() {
        plongeur = new Plongeur("1234567890123", "Martin", "Paul",
                "Paris", "0612345678",
                LocalDate.of(1985, 3, 20), 3);
        club = new Club("Club Test", "Marseille", "0412345678");
    }

    @Test
    public void testCreationLicence() {
        Licence licence = new Licence(plongeur, "LIC001",
                LocalDate.of(2024, 1, 15), club);

        assertEquals(plongeur, licence.getPossesseur());
        assertEquals("LIC001", licence.getNumero());
        assertEquals(club, licence.getClub());
        assertEquals(LocalDate.of(2024, 1, 15), licence.getDelivrance());
        assertEquals(LocalDate.of(2025, 1, 15), licence.getFinValidite());
    }

    @Test
    public void testLicenceValide() {
        Licence licence = new Licence(plongeur, "LIC001",
                LocalDate.of(2024, 1, 15), club);

        assertTrue(licence.estValide(LocalDate.of(2024, 6, 15)));
        assertTrue(licence.estValide(LocalDate.of(2024, 1, 15)));
        assertTrue(licence.estValide(LocalDate.of(2025, 1, 15)));
        assertFalse(licence.estValide(LocalDate.of(2023, 12, 31)));
        assertFalse(licence.estValide(LocalDate.of(2025, 1, 16)));
    }
}