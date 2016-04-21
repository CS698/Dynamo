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
	

	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}


	Map resDetailsMap=new HashMap();
	
	public Map getResDetailsMap() {
		return resDetailsMap;
	}


	public void setResDetailsMap(Map resDetailsMap) {
		this.resDetailsMap = resDetailsMap;
	}


	
	/*****************
	 * To Fetch Location of First Responder to MAP
	 ************************/
	public String fetchToMap() throws Exception {
				
		counter=this.counter;
		System.out.println("counter value************************"+counter);
		FetchMapDAO = new FetchMapDAOImp();

		resDetailsMap = FetchMapDAO.fetchToMap(counter);
		
		System.out.println("resDetailsMap from dao::" + resDetailsMap);
		logger.debug(" fetchToMap method in FetchMapAction : " + responderDetailsList );
		logger.debug(" resDetailsMap:fetchToMap method in FetchMapAction : " + resDetailsMap );

		return "fetchToMap";
	}
	
	
	
	/***************** To navigate to the MapMultiLocation.jsp ************************/
	public String addMap() throws Exception {
		return "addMap";
	}
	
}
