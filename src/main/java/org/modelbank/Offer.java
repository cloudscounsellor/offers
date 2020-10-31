package org.modelbank;

public class Offer   {
	
	
	private String id;

	private String customerID;
	private String offerType;
	private String offerDetail;
	private String offerCreationDate;
	private String offerCreatedBy;
	private String offerExpirationDate;
	
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}






	public Offer(String customerID, String offerType, String offerDetail) {
		super();
		this.customerID = customerID;
		this.offerType = offerType;
		this.offerDetail = offerDetail;
	}






	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getCustomerID() {
		return customerID;
	}



	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


	

	public String getOfferType() {
		return offerType;
	}






	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}






	public String getOfferDetail() {
		return offerDetail;
	}



	public void setOfferDetail(String offerDetail) {
		this.offerDetail = offerDetail;
	}



	public String getOfferCreationDate() {
		return offerCreationDate;
	}



	public void setOfferCreationDate(String offerCreationDate) {
		this.offerCreationDate = offerCreationDate;
	}



	public String getOfferCreatedBy() {
		return offerCreatedBy;
	}



	public void setOfferCreatedBy(String offerCreatedBy) {
		this.offerCreatedBy = offerCreatedBy;
	}



	public String getOfferExpirationDate() {
		return offerExpirationDate;
	}



	public void setOfferExpirationDate(String offerExpirationDate) {
		this.offerExpirationDate = offerExpirationDate;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((offerCreatedBy == null) ? 0 : offerCreatedBy.hashCode());
		result = prime * result + ((offerCreationDate == null) ? 0 : offerCreationDate.hashCode());
		result = prime * result + ((offerDetail == null) ? 0 : offerDetail.hashCode());
		result = prime * result + ((offerExpirationDate == null) ? 0 : offerExpirationDate.hashCode());
		result = prime * result + ((offerType == null) ? 0 : offerType.hashCode());
		return result;
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (offerCreatedBy == null) {
			if (other.offerCreatedBy != null)
				return false;
		} else if (!offerCreatedBy.equals(other.offerCreatedBy))
			return false;
		if (offerCreationDate == null) {
			if (other.offerCreationDate != null)
				return false;
		} else if (!offerCreationDate.equals(other.offerCreationDate))
			return false;
		if (offerDetail == null) {
			if (other.offerDetail != null)
				return false;
		} else if (!offerDetail.equals(other.offerDetail))
			return false;
		if (offerExpirationDate == null) {
			if (other.offerExpirationDate != null)
				return false;
		} else if (!offerExpirationDate.equals(other.offerExpirationDate))
			return false;
		if (offerType == null) {
			if (other.offerType != null)
				return false;
		} else if (!offerType.equals(other.offerType))
			return false;
		return true;
	}



	
	
}
