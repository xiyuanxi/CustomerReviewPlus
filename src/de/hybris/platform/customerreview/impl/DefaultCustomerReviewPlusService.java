package de.hybris.platform.customerreview.impl;

import org.springframework.beans.factory.annotation.Value;

import de.hybris.platform.customerreview.CustomerReviewPlusService;
import de.hybris.platform.customerreview.CustomerReviewService;
import de.hybris.platform.customerreview.constants.CustomerReviewConstants;
import de.hybris.platform.customerreview.jalo.CustomerReviewPlusManager;
import de.hybris.platform.customerreview.model.CustomerReviewModel;
import de.hybris.platform.core.model.product.ProductModel;

import de.hybris.platform.util.localization.Localization;
import de.hybris.platform.jalo.JaloInvalidParameterException;


public class DefaultCustomerReviewPlusService extends DefaultCustomerReviewService
		implements CustomerReviewService, CustomerReviewPlusService {

	// curse words, load from curse_word_prop.properties
	@Value("#{curseWordProperties['curseWords']}") 
	private String curseWords;
	public void setCurseWords(String curseWords) {
		this.curseWords = curseWords;
	}

	@Override
	public Integer getNumberOfReviewsForGivenRatingRange(ProductModel paramProductModel, Double paramDouble1,
			Double paramDouble2) {

		// new function
		// get a product¡¯s total number of customer reviews whose ratings are within a given range (inclusive)
		return CustomerReviewPlusManager.getInstance().getNumberOfReviewsForGivenRatingRange(paramProductModel,
				paramDouble1, paramDouble2);
	}

	@Override
	public CustomerReviewModel createCustomerReview(Double rating, String headline, String comment, UserModel user,
			ProductModel product) {
		
		//a. read a list of curse words
		String[] words = curseWords.split(",");
		//b. Check if Customer¡¯s comment contains any of these curse words
		//If it does, throw an exception with a message.
		for (String w : words) {
			if (comment.toLowerCase().indexOf(w.trim().toLowerCase()) != -1) {
				throw new JaloInvalidParameterException(Localization.getLocalizedString("error.customerreview.curseword"));
			}
		}
		
		// c. Check if the rating is not < 0.
		// If it is < 0, throw an exception with a message.
		if (rating.doubleValue() < 0.0D) {
			throw new JaloInvalidParameterException(Localization.getLocalizedString("error.customerreview.invalidrating",
							new Object[] { "null", new Double(CustomerReviewConstants.getInstance().MINRATING),
							new Double(CustomerReviewConstants.getInstance().MAXRATING) }), 0);
		}
		
		// If all the rules are passed, go ahead and create the customer review.
		return super.createCustomerReview(rating, headline, comment, user, product);
	}

}
