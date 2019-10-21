package my.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sap.cloud.sdk.service.prov.api.ExtensionHelper;
import com.sap.cloud.sdk.service.prov.api.annotations.BeforeQuery;
import com.sap.cloud.sdk.service.prov.api.exits.BeforeQueryResponse;
import com.sap.cloud.sdk.service.prov.api.request.QueryRequest;

import my.company.config.mail.MailServiceImpl;

@Component
public class OrdersService {

	@Autowired
    protected MailServiceImpl mailService;
//	private static final Logger LOG = CloudLoggerFactory.getLogger(OrdersService.class.getName());

	@BeforeQuery(entity = "Books", serviceName = "CatalogService")
	public BeforeQueryResponse beforeQueryOrders(QueryRequest qr, ExtensionHelper eh) {
//		LOG.error("##### Sending Mail ########");
		
		mailService.sendMail();
		
		return BeforeQueryResponse.setSuccess().response();
	}
}