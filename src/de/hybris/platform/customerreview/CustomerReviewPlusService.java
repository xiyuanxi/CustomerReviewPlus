package de.hybris.platform.customerreview;

import de.hybris.platform.core.model.product.ProductModel;

public interface CustomerReviewPlusService {
	 // get a product's total number of customer reviews whose ratings are within a given range (inclusive)
	 public abstract Integer getNumberOfReviewsForGivenRatingRange(ProductModel paramProductModel, Double paramDouble1,Double paramDouble2);
}
