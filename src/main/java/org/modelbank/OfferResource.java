package org.modelbank;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.opentracing.Traced;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Traced
@Timed
@RestController
public class OfferResource {

	private static Logger LOGGER = Logger.getLogger(OfferResource.class.getSimpleName());

	@Autowired
	OfferService offerService;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/offers")
	@Retry(maxRetries = 3, delay = 2000)
	@Timeout(400)
	@Fallback(fallbackMethod = "offerFallback")
	public List<Offer> list() {
		LOGGER.info("Inside  :: " + LOGGER.getName() + " ::  list()");
		// boolean b = true;
		// if (b = true)
		// throw new RuntimeException();
		return offerService.list();
	}

	/**
	 * 
	 * @param offer
	 * @return
	 */
	@PostMapping("/offers")
	@Retry(maxRetries = 3, delay = 2000)
	@Timeout(400)
	public List<Offer> add(@RequestBody Offer offer) {
		LOGGER.info("Inside  :: " + LOGGER.getName() + " ::  add()");
		offerService.add(offer);
		return list();
	}

	/**
	 * 
	 * @param customerID
	 * @return
	 */
	@GetMapping("/offers/{customerID}")
	@Retry(maxRetries = 3, delay = 2000)
	@Timeout(400)
	public List<Offer> get(@PathVariable("customerID") String customerID) {
		LOGGER.info("Inside  :: " + LOGGER.getName() + " ::  get()");
		return offerService.findBycustomerID(customerID);
	}

	/**
	 * 
	 * @return
	 */
	public List<Offer> offerFallback() {
		LOGGER.info("Inside  :: " + LOGGER.getName() + " ::  offerFallback()");
		List<Offer> emptyOffers = new ArrayList<Offer>();
		Offer emptyOffer = new Offer("Empty Customer ID", "Empty Offer Type", "Empty Offer Detail");
		emptyOffers.add(emptyOffer);
		emptyOffers.add(emptyOffer);
		emptyOffers.add(emptyOffer);
		return emptyOffers;
	}

}
