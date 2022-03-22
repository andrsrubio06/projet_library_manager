package ensta;

import java.time.LocalDate;
import java.util.List;


import org.junit.Test;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Emprunt;
import com.ensta.librarymanager.model.Livre;
import com.ensta.librarymanager.model.Membre;
import com.ensta.librarymanager.service.EmpruntService;
import com.ensta.librarymanager.service.EmpruntServiceI;
import com.ensta.librarymanager.service.LivreService;
import com.ensta.librarymanager.service.LivreServiceI;
import com.ensta.librarymanager.service.LivreServiceI;
import com.ensta.librarymanager.service.MembreService;
import com.ensta.librarymanager.service.MembreServiceI;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class ServiceTest 
{
    /**
     * test dao
     */
    @Test
    public void testService()
    {

        System.out.println("TEST SERVICE    ");
        try {

            LivreServiceI livreService = LivreServiceI.getInstance();
            int id = livreService.create("Don quijote","Miguel de cervantes", "123456");

            System.out.println(id);


            Livre livre = livreService.getById(id);

            assertTrue(livre.getTitre() == "Don quijote");

            System.out.println(livre);
        } catch (ServiceException e) {
            //TODO: handle exception
        }
        



        
        
    }
}
