package com.demo.store.rest.product;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import com.demo.store.entity.product.Product;
import com.demo.store.service.product.ProductService;
@Stateless
@Path("/products")
public class ProductRestService {

	Logger log=Logger.getLogger(getClass());
	@Inject
	ProductService ps;
	
	@GET
	@Path("/test/{msg}")
	@Produces("text/plain")
	public String test(@PathParam("msg") String msg) {
		log.debug("REST : test ");
		String output="hello "+msg;
		return output;
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts() {
		log.debug("REST: getAll");
		return ps.getAllEntities();
	}
	
	@DELETE
	@Path("/remove/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") String id) {

		log.debug("delete : "+id);
		Product p=new Product();
		p.setId(Long.parseLong(id));
		ps.remove(p);
		String result="product "+id+" deleted";

		return Response.status(201).entity(result).build();

	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("id") String id) {
		log.debug("REST: get");
		Product p=new Product();
		p.setId(Long.parseLong(id));
		p=ps.get(p);
		return p;
	}

/*
curl http://192.168.223.130:8080/store.product/rest/products/get/11111
{"name":"11111","description":"test","shortDescription":null,"unitPrice":null,"uom":null,"id":null}
 */	
	

	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Product p) {

		log.debug(p.getDescription());
		String result="product "+p.getName()+" saved";
		ps.add(p);

		return Response.status(201).entity(result).build();

	}
}
/** if without declaring this class @stateless, will need to use usertransaction, or to be more correct, at the AbstractDataService
	public Response save(Product p) {
		log.debug(p.getDescription());
		String result="product "+p.getName()+" saved";
		UserTransaction txn=null;
		try {
			txn = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
			txn.begin();
			ps.add(p);
			txn.commit();
		} catch (Exception e) {
			try {
				txn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return Response.status(201).entity(result).build();
}
*
*/