package FFSSM;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class DiplomeDeMoniteurTest {

    @Test
    public void testCreationDiplome() {
        Plongeur plongeur = new Plongeur("123", "Test", "Nom",
                "Adresse", "Tel",
                LocalDate.of(1990, 1, 1), 4);
        DiplomeDeMoniteur diplome = new DiplomeDeMoniteur(
                DiplomeDeMoniteur.Niveau.E2,
                LocalDate.of(2023, 6, 15),
                plongeur);

        assertEquals(DiplomeDeMoniteur.Niveau.E2, diplome.getNiveau());
        assertEquals(LocalDate.of(2023, 6, 15), diplome.getDateDelivrance());
        assertEquals(plongeur, diplome.getDetenteur());
    }

    @Test
    public void testNiveauMaxEncadrement() {
        Plongeur plongeur = new Plongeur("123", "Test", "Nom",
                "Adresse", "Tel",
                LocalDate.of(1990, 1, 1), 4);

        DiplomeDeMoniteur e1 = new DiplomeDeMoniteur(
                DiplomeDeMoniteur.Niveau.E1, LocalDate.now(), plongeur);
        assertEquals(1, e1.getNiveauMaxEncadrement());

        DiplomeDeMoniteur e2 = new DiplomeDeMoniteur(
                DiplomeDeMoniteur.Niveau.E2, LocalDate.now(), plongeur);
        assertEquals(2, e2.getNiveauMaxEncadrement());

        DiplomeDeMoniteur e3 = new DiplomeDeMoniteur(
                DiplomeDeMoniteur.Niveau.E3, LocalDate.now(), plongeur);
        assertEquals(3, e3.getNiveauMaxEncadrement());

        DiplomeDeMoniteur e4 = new DiplomeDeMoniteur(
                DiplomeDeMoniteur.Niveau.E4, LocalDate.now(), plongeur);
        assertEquals(4, e4.getNiveauMaxEncadrement());
    }
}