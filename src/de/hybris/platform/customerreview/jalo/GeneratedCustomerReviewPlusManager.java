 package de.hybris.platform.customerreview.jalo;
 
 import de.hybris.platform.jalo.SessionContext;
 import de.hybris.platform.jalo.extension.Extension;
 import de.hybris.platform.jalo.product.Product;
 
 public abstract class GeneratedCustomerReviewPlusManager
   extends Extension
 {

	 public abstract Integer getNumberOfReviewsForGivenRatingRange(SessionContext paramSessionContext, Product paramProduct,  Double paramDouble1, 	Double paramDouble2);
   
	public Integer getNumberOfReviewsForGivenRatingRange(Product item, Double paramDouble1, Double paramDouble2) {
		return getNumberOfReviewsForGivenRatingRange(getSession().getSessionContext(), item, paramDouble1,
				paramDouble2);
	}
 
 }

