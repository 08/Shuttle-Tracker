/**
 * 
 */
package com.abstractedsheep.extractor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author jonnau
 * @author
 */
public class JSONParser {
	/**
	 * write a stop object from the given values in the arraylist.
	 * @param list
	 * @return stop object
	 */
	public static Stop listToStop(ArrayList<String> list) {
		Stop stop = new Stop();
		stop.setLat(Double.parseDouble(list.get(0)));
		stop.setLon(Double.parseDouble(list.get(1)));
		stop.setName(list.get(2));
		stop.setShortName(list.get(3));
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		for(int i = 4; i < list.size(); i+= 2) {
			map.put(Integer.parseInt(list.get(i)), list.get(i + 1));
		}
		
		stop.setRouteMap(map);
		return stop;
	}
	
	public static Route listToRoute(ArrayList<String> list) {
		Route route = new Route(Integer.parseInt(list.get(1)), list.get(2));
		for(int i = 4; i < list.size() - 1; i += 2) {
			route.putCoordinate(Double.parseDouble(list.get(i + 1)), Double.parseDouble(list.get(i)));
		}
		return route;
	}
	
	public static Shuttle listToShuttle(ArrayList<String> list, ArrayList<Stop> stopList) {
		Shuttle shuttle = new Shuttle();
		shuttle.setShuttleId(Integer.parseInt(list.get(0)));
		shuttle.setCurrentLocation(new Shuttle.Point(Double.parseDouble(list.get(3)), Double.parseDouble(list.get(4))));
		shuttle.setSpeed(Integer.parseInt(list.get(5)));
		shuttle.setCardinalPoint(list.get(list.size() - 1));
		
		for(Stop stop : stopList) {
			shuttle.addStop(stop.getName(), stop.getLat(), stop.getLon());
		}
		return shuttle;
	}
}
