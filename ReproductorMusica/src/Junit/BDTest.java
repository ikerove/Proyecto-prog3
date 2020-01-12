package Junit;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ConectorBD.MySQLConexion;

public class BDTest {

	    @Before
	    public void antes(){
	        System.out.println("Empezando test...");
	    }
	    
	    @After
	    public void despues(){
	        System.out.println("Terminando test...");
	    }
	    
	    @Test
	    public void assertDB(){
	        MySQLConexion mg = new MySQLConexion();
	        mg.connect();
	        assertFalse(mg.getConexion()==null);
	        mg.disconnect();
	        assertTrue(mg.getConexion()==null);
	        mg.connect();
	    }
}
