package ensta;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.ensta.librarymanager.model.Membre;
import com.ensta.librarymanager.model.Livre;
import com.ensta.librarymanager.model.Emprunt;

import com.ensta.librarymanager.utils.Abonnement;

/**
 * Unit test for simple App.
 */
public class ModelTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testModel()
    {
        Membre membre = new Membre(1, "Rubio", "Andres", "Massy", "aerc@ensta.fr", "123", Abonnement.VIP);
        Livre livre = new Livre(1, "Don quijote", "Miguel de cervantes", "123456789");
        Emprunt emprunt = new Emprunt(1, membre, livre, null, null);

        System.out.println(emprunt);

        assertTrue(emprunt.getMembre().getNom() == "Rubio");
        assertNull(emprunt.getDateEmprunt());
    }
}
