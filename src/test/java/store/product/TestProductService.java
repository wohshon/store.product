package store.product;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.demo.store.service.product.ProductService;

public class TestProductService {

	Logger log=null;
	@Inject
	ProductService ps;
	@Before
	public void setUp() throws Exception {
		ps=new ProductService();
		log=Logger.getLogger(getClass());
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		//fail("Not yet implemented");
		log.info("*********************************"+ps);
		//ps.getAllEntities();
		assertTrue(true);
	}

}
