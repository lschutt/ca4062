package com.estateagent.client;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

@ApplicationScoped
@ManagedBean
public class MyClient 
{
	// ================ Property Web Service =======================
	
	public void propertiesRSCall(boolean all, String id)
	{
		Client client = ClientBuilder.newClient();
		
		String response = client.target("http://localhost:8080/estateagent/api/property-service/properties")
								.queryParam("all", all)		
					   			.queryParam("id", id)	
					   			.request()
					   			.get(String.class);	
		
		System.out.println(response);
	}
	
	public void propertyViewingTime(String id)
	{
		Client client = ClientBuilder.newClient();
		
		String response = client.target("http://localhost:8080/estateagent/api/property-service/properties")
								.queryParam("all", false)		
					   			.queryParam("id", id)	
					   			.request()
					   			.get(String.class);	
		
		System.out.println(response);
	}
	
	public void insertProperty(String property)
	{
		Client client = ClientBuilder.newClient();

		client.target("http://localhost:8080/estateagent/api/property-service/properties")		
			  .request()
			  .post(Entity.json(property));		
	}
	
	public void insertPropertyWithTimeframe(String property)
	{
		Client client = ClientBuilder.newClient();

		client.target("http://localhost:8080/estateagent/api/property-service/properties")		
			  .request()
			  .post(Entity.json(property));		
	}
	
	public void updateProperty(String property)
	{
		Client client = ClientBuilder.newClient();

		client.target("http://localhost:8080/estateagent/api/property-service/properties")		
			  .request()
			  .put(Entity.json(property));		
	}
	
	public void deleteProperty(boolean all, String id)
	{
		Client client = ClientBuilder.newClient();
		
		client.target("http://localhost:8080/estateagent/api/property-service/properties")		
		      .queryParam("all", all)		
			  .queryParam("id", id)
			  .request()
			  .delete();
	}
	
	
	// ================ Biding Web Service =======================
	
	public void bidingsRSCall(boolean all, String id)
	{
		Client client = ClientBuilder.newClient();
		
		String bids = client.target("http://localhost:8080/estateagent/api/biding-service/bidings")
							.queryParam("all", all)		
				   			.queryParam("id", id)
				   			.request()
				   			.get(String.class);
		
		System.out.println(bids);
	}
	
	public void insertBiding(String biding)
	{
		Client client = ClientBuilder.newClient();

		String output = client.target("http://localhost:8080/estateagent/api/biding-service/bidings")		
								  .request()
								  .post(Entity.json(biding), String.class);	
		
		System.out.println(output);
	}
	
	public void counterOfferBiding(String propertyId, String name, double counterOffer)
	{
		Client client = ClientBuilder.newClient();
		
		String response = propertyId + "," + name + "," + counterOffer;

		String output = client.target("http://localhost:8080/estateagent/api/biding-service/bidings/counter")		
			  .request()
			  .post(Entity.json(response), String.class);
		
		System.out.println(output);
	}
	
	
	// ================ Booking Web Service =======================
	
	public void bookingsRSCall(boolean all, String id)
	{
		Client client = ClientBuilder.newClient();
		
		String bookings = client.target("http://localhost:8080/estateagent/api/booking-service/bookings")
								.queryParam("all", all)		
					   			.queryParam("id", id)
					   			.request()
					   			.get(String.class);

		System.out.println(bookings);
	}
	
	public void insertBooking(String booking)
	{
		Client client = ClientBuilder.newClient();

		client.target("http://localhost:8080/estateagent/api/booking-service/bookings")		
			  .request()
			  .post(Entity.json(booking));		
	}
	
	public void updateBooking(String booking)
	{
		Client client = ClientBuilder.newClient();

		client.target("http://localhost:8080/estateagent/api/booking-service/bookings")		
			  .request()
			  .put(Entity.json(booking));		
	}
	
	public void deleteBooking(boolean all, String id)
	{
		Client client = ClientBuilder.newClient();

		client.target("http://localhost:8080/estateagent/api/booking-service/bookings")		
		      .queryParam("all", all)		
			  .queryParam("id", id)
			  .request()
			  .delete();
	}
}