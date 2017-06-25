package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

public class ServerLoadBalancer {

	public void balance(Server[] servers, Vm[] vms) {
		for (Vm vm : vms) {
			extractLessLoadedServer(servers, vm);
		}

	}

	private void extractLessLoadedServer(Server[] servers, Vm vm) {
		List<Server> capableServers = new ArrayList<Server>();
		for(Server server : servers){
			if(server.canFit(vm)){
				capableServers.add(server);
			}
		}
		Server lessLoaded = null;
		for(Server server : capableServers){
			if(lessLoaded == null || lessLoaded.currentLoadPecentage > server.currentLoadPecentage){
				lessLoaded = server;
			}
		}

		if(lessLoaded != null){
			lessLoaded.addVm(vm);
		}
	}

}
