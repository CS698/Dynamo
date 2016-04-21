package net.dynamo.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dynamo.Dao.FetchMapDAO;
import net.dynamo.Dao.FetchMapDAOImp;
import net.dynamo.Dao.UAVMapDAO;
import net.dynamo.Dao.UAVMapDAOImp;

public class UAVDataMapAction {

	private UAVMapDAO uAVMapDAO;
	public Map uavMap = new HashMap();

	public Map getUavMap() {
		return uavMap;
	}

	public void setUavMap(Map uavMap) {
		this.uavMap = uavMap;
	}

	private int counter;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	/***************** To Fetch UAV VDO ************************/
	public String addUAV() throws Exception {
		return "addUAV";
	}

	/*****************
	 * To Fetch Location of First Responder to MAP
	 ************************/
	public String uavToMap() throws Exception {

		counter = this.counter;
		System.out.println("counter value************************" + counter);
		uAVMapDAO = new UAVMapDAOImp();

		uavMap = uAVMapDAO.uavToMap(counter);

		System.out.println("uavMap from dao::" + uavMap);
		//logger.debug(" fetchToMap method in FetchMapAction : " + responderDetailsList);
		//logger.debug(" resDetailsMap:fetchToMap method in FetchMapAction : " + resDetailsMap);

		return "uavToMap";
	}
}
