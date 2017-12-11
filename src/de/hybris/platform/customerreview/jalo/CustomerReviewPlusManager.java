package de.hybris.platform.customerreview.jalo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants;
import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants.Attributes.Product;

public class CustomerReviewPlusManager extends GeneratedCustomerReviewPlusManager {
	private static final Logger LOG = Logger.getLogger(CustomerReviewPlusManager.class.getName());
	
	public static CustomerReviewManager getInstance() {
		ExtensionManager extensionManager = JaloSession.getCurrentSession().getExtensionManager();
		return (CustomerReviewPlusManager) extensionManager.getExtension("customerreviewplus");
	}
	
	@Override
	public Integer getNumberOfReviewsForGivenRatingRange(SessionContext paramSessionContext,
			de.hybris.platform.customerreview.jalo.Product paramProduct, Double paramDouble1, Double paramDouble2) {
		String query = "SELECT count(*) FROM {" + GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEW + "} WHERE {"
				+ "product" + "} = ?product AND {rating} >= ?rating1 AND {rating} <= ?rating2 ";
		Map<String, Object> values = Collections.singletonMap("product", paramProduct);
		values.put("rating1", paramDouble1);
		values.put("rating2", paramDouble2);
		
		List<Integer> result = FlexibleSearch.getInstance()
				.search(query, values, Collections.singletonList(Integer.class), true, true, 0, -1).getResult();
		return (Integer) result.iterator().next();
	}

}
