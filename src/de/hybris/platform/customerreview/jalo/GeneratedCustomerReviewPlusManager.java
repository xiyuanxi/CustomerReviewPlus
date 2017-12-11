 package de.hybris.platform.customerreview.jalo;
 
 import de.hybris.platform.core.Tenant;
 import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants.Attributes.User;
 import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants.TC;
 import de.hybris.platform.jalo.Item;
 import de.hybris.platform.jalo.Item.AttributeMode;
 import de.hybris.platform.jalo.JaloBusinessException;
 import de.hybris.platform.jalo.JaloConnection;
 import de.hybris.platform.jalo.JaloInvalidParameterException;
 import de.hybris.platform.jalo.JaloSession;
 import de.hybris.platform.jalo.JaloSystemException;
 import de.hybris.platform.jalo.SessionContext;
 import de.hybris.platform.jalo.extension.Extension;
 import de.hybris.platform.jalo.product.Product;
 import de.hybris.platform.jalo.type.ComposedType;
 import de.hybris.platform.jalo.type.JaloGenericCreationException;
 import de.hybris.platform.jalo.type.TypeManager;
 import de.hybris.platform.jalo.user.User;
 import de.hybris.platform.util.OneToManyHandler;
 import java.util.Collection;
 import java.util.HashMap;
 import java.util.Map;
 
 
 
 public abstract class GeneratedCustomerReviewPlusManager
   extends Extension
 {

   public abstract Integer getNumberOfReviewsForGivenRatingRange(SessionContext paramSessionContext, Product paramProduct,  Double paramDouble1, 	Double paramDouble2);
   
 
 
 
	public Integer getNumberOfReviewsForGivenRatingRange(Product item, Double paramDouble1, Double paramDouble2) {
		return getNumberOfReviewsForGivenRatingRange(getSession().getSessionContext(), item, paramDouble1,
				paramDouble2);
	}
 
 }

