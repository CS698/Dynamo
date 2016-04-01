package net.dynamo.action;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import java.util.List;

import net.dynamo.VO.Responder;

public class FetchMapAction {
	final static Logger logger = Logger.getLogger(FetchMapAction.class);
	//private static final long serialVersionUID = -6765991741441442190L;
	public List responderDetailsList = new ArrayList();
	
	
	public List getResponderDetailsList() {
		return responderDetailsList;
	}


	public void setResponderDetailsList(List responderDetailsList) {
		this.responderDetailsList = responderDetailsList;
	}


	/*****************
	 * To Fetch Location of First Responder to MAP
	 ************************/
	public String fetchToMap() throws Exception {
		Responder responder = new Responder();
		responder.setResName("maurani");
		responder.setImageName("icon.png");
		responder.setOrganization("Fire");
		responder.setLattitude("-33.923036");
		responder.setLongitude("151.259052");
		responderDetailsList.add(responder);
		// outerList.add(responderDetailsList);

		Responder responder1 = new Responder();
		responder1.setResName("Ramya");
		responder1.setImageName("icon.png");
		responder1.setOrganization("Police");
		responder1.setLattitude("-34.028249");
		responder1.setLongitude("151.157507");
		responderDetailsList.add(responder1);
		// outerList.add(responderDetailsList);
		System.out.println("responder::" + responderDetailsList);
		// Gson m = new Gson();
		// String jsonData = new Gson().toJson(responderDetailsList);
		// System.out.println("jsonData::"+jsonData);
		System.out.println("responder::" + responderDetailsList);
		logger.debug(" fetchToMap method in FetchMapAction : " + responderDetailsList );

		return "fetchToMap";
	}
	
}
