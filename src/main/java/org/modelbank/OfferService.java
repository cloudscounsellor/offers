package org.modelbank;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.opentracing.Traced;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

@Traced
@Timed
@Component
public class OfferService {
	
		private static Logger LOGGER = Logger.getLogger(OfferService.class.getSimpleName());


	   @Autowired
	    MongoClient mongoClient;

	   
	   /**
	    * 
	    * @return
	    */
	    public List<Offer> list() {
			LOGGER.info("Inside  :: " + LOGGER.getName() + " ::  list()");	    	
	        List<Offer> list = new ArrayList<>();
	        MongoCursor<Document> cursor = getCollection().find().iterator();

	        try {
	            while (cursor.hasNext()) {
	                Document document = cursor.next();
	                Offer offer = new Offer();
	                offer.setCustomerID(document.getString("customerID"));
	                offer.setOfferType(document.getString("offerType"));
	                offer.setOfferDetail(document.getString("offerDetail"));
	                list.add(offer);
	            }
	        } finally {
	            cursor.close();
	        }
	        return list;
	    }

	    /**
	     * 
	     * @param offer
	     */
	    public void add(Offer offer) {
	    	LOGGER.info("Inside  :: " + LOGGER.getName() + " ::  add()");
	        Document document = new Document()
	                .append("customerID", offer.getCustomerID())
	                .append("offerType", offer.getOfferType())
	                .append("offerDetail", offer.getOfferDetail());
	        getCollection().insertOne(document);
	    }

	 
	    
	    /**
	     * 
	     * @param customerID
	     * @return
	     */
	    public List<Offer> findBycustomerID(String customerID) {
	    	LOGGER.info("Inside  :: " + LOGGER.getName() + " ::  findBycustomerID()");
	        List<Offer> list = new ArrayList<>();
	        MongoCursor<Document> cursor = getCollection().find().iterator();

	        try {
	            while (cursor.hasNext()) {
	                Document document = cursor.next();
	                Offer offer = new Offer();
	                if(document.getString("customerID").equals(customerID))
	                {
	                	offer.setCustomerID(document.getString("customerID"));
	                	offer.setOfferType(document.getString("offerType"));
	                	offer.setOfferDetail(document.getString("offerDetail"));
	                	list.add(offer);
	                }
	            }
	        } finally {
	            cursor.close();
	        }
	        return list;
	    }
	    
	    /**
	     * 
	     * @return
	     */
	    private MongoCollection getCollection() {
	    	LOGGER.info("Inside  :: " + LOGGER.getName() + " ::  getCollection()");
	        return mongoClient.getDatabase("OpenBankingDB").getCollection("tblOffers");
	    }
	    
	    
}
