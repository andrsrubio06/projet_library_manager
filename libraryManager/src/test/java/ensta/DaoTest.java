package ensta;

import java.time.LocalDate;
import java.util.List;


import org.junit.Test;



import com.ensta.librarymanager.dao.EmpruntDao;
import com.ensta.librarymanager.dao.EmpruntDaoI;
import com.ensta.librarymanager.dao.LivreDao;
import com.ensta.librarymanager.dao.LivreDaoI;
import com.ensta.librarymanager.dao.MembreDao;
import com.ensta.librarymanager.dao.MembreDaoI;
import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.model.Emprunt;
import com.ensta.librarymanager.model.Livre;
import com.ensta.librarymanager.model.Membre;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class DaoTest 
{
    /**
     * test dao
     */
    @Test
    public void testDao()
    {

        System.out.println("TEST DAO");
        try {

            LivreDao livreDao = LivreDaoI.getInstance();
            int id = livreDao.create("Don quijote","Miguel de cervantes", "123456");

            System.out.println(id);


            Livre livre = livreDao.getById(id);

            assertTrue(livre.getTitre() == "Don quijote");

            System.out.println(livre);
        } catch (DaoException e) {
            //TODO: handle exception
        }
        



        
        
    }
}
