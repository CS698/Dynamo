package net.dynamo.action;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import java.util.List;
import java.util.Map;
import net.dynamo.Dao.FetchMapDAO;
import net.dynamo.Dao.FetchMapDAOImp;
import net.dynamo.Dao.DBobjectDAO;
import net.dynamo.Dao.DBobjectDAOImp;
import net.dynamo.VO.Responder;

public class FetchMapAction {
	final static Logger logger = Logger.getLogger(FetchMapAction.class);
	//private static final long serialVersionUID = -6765991741441442190L;
	public List responderDetailsList = new ArrayList();
	public List  responderDetailsList1= new ArrayList();
	private FetchMapDAO FetchMapDAO;
	
	private int counter;
	/*public List getResponderDetailsList1() {
		return responderDetailsList1;
	}


	public void setResponderDetailsList1(List responderDetailsList1) {
		this.responderDetailsList1 = responderDetailsList1;
	}
*/

	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
		System.out.println("****************************** Inside set method::"+this.counter);
	}


	Map resDetailsMap=new HashMap();
	
	public Map getResDetailsMap() {
		return resDetailsMap;
	}


	public void setResDetailsMap(Map resDetailsMap) {
		this.resDetailsMap = resDetailsMap;
	}


	/*public List getResponderDetailsList() {
		return responderDetailsList;
	}


	public void setResponderDetailsList(List responderDetailsList) {
		this.responderDetailsList = responderDetailsList;
	}

*/
	/*****************
	 * To Fetch Location of First Responder to MAP
	 ************************/
	public String fetchToMap() throws Exception {
		/*Responder responder = new Responder();
		responder.setResName("Sushma");
		responder.setImageName("s0980233.jpg");
		responder.setOrganization("Fire");
		responder.setLattitude("40.277673");
		responder.setLongitude("-74.003730");
		responder.setResId("100");
		responderDetailsList.add(responder);
		// outerList.add(responderDetailsList);

		
		
		Responder responder1 = new Responder();
		responder1.setResName("Sushma");
		responder1.setImageName("s0980233.jpg");
		responder1.setOrganization("Police");
		responder1.setLattitude("40.277653");
		responder1.setLongitude("-74.003707");
		
		responderDetailsList.add(responder1);
		
		
		
		
		resDetailsMap.put("100", responderDetailsList);
		
		
		Responder responder5 = new Responder();
		responder5.setResName("Saraswati");
		responder5.setImageName("s1044534.jpg");
		responder5.setOrganization("Fire");
		responder5.setLattitude("40.277673");
		responder5.setLongitude("-74.003716");
		responderDetailsList1.add(responder5);
		// outerList.add(responderDetailsList);

		Responder responder6 = new Responder();
		responder6.setResName("Saraswati");
		responder6.setImageName("s1044534.jpg");
		responder6.setOrganization("Police");
		responder6.setLattitude("40.277623");
		responder6.setLongitude("-74.003647");
		
		responderDetailsList1.add(responder6);
		
		
			
		
		
		resDetailsMap.put("102", responderDetailsList1);
		
		// outerList.add(responderDetailsList);
		System.out.println("responder::" + responderDetailsList);*/
		// Gson m = new Gson();
		// String jsonData = new Gson().toJson(responderDetailsList);
		// System.out.println("jsonData::"+jsonData);
		
		
		counter=this.counter;
		System.out.println("counter value************************"+counter);
		FetchMapDAO = new FetchMapDAOImp();

		resDetailsMap = FetchMapDAO.fetchToMap(counter);
		
		System.out.println("resDetailsMap from dao::" + resDetailsMap);
		logger.debug(" fetchToMap method in FetchMapAction : " + responderDetailsList );
		logger.debug(" resDetailsMap:fetchToMap method in FetchMapAction : " + resDetailsMap );

		return "fetchToMap";
	}
	
}
