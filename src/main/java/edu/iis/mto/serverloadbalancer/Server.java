package edu.iis.mto.serverloadbalancer;


public class Server {

	private static final double _MAXIMUM_LOAD = 100.0d;
	public double currentLoadPecentage;
	public int capacity;

	public boolean contains(Vm vm) {
		return true;
	}

	public Server(int capacity) {
		super();
		this.capacity = capacity;
	}

	public void addVm(Vm vm) {
		currentLoadPecentage = (double)vm.size / (double)capacity * _MAXIMUM_LOAD;
	}

}
