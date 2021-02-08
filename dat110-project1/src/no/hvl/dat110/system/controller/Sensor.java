package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;

	public int read() {

		int temp;

		// TODO
		// implement marshalling, call and unmarshalling for read RPC method

		byte[] send = RPCUtils.marshallVoid(RPCID);
		
		byte[] recieve = rpcclient.call(send);
		
		temp = RPCUtils.unmarshallInteger(recieve);
		
		return temp;

	}
}
