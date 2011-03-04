/* 
 * Copyright 2011 Austin Wagner
 *     
 * This file is part of Mobile Shuttle Tracker.
 *
 *  Mobile Shuttle Tracker is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Mobile Shuttle Tracker is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Mobile Shuttle Tracker.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */

package com.abstractedsheep.shuttletracker.android;

import java.util.ArrayList;

import com.abstractedsheep.shuttletracker.json.RoutesJson;
import com.abstractedsheep.shuttletracker.json.VehicleJson;
import com.abstractedsheep.shuttletracker.json.EtaJson;

public interface IShuttleDataMonitor {
	void registerCallback(IShuttleDataUpdateCallback callback);
	void unregisterCallback(IShuttleDataUpdateCallback callback);
	ArrayList<VehicleJson> getCurrentShuttleLocations();
	ArrayList<EtaJson> getCurrentEtas();
	RoutesJson getRoutes();
}
