package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		
		if (payload.length < 128) {
			this.payload = payload; 

		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = null;
		
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		
		Integer paylength = payload.length;
		encoded[0] = paylength.byteValue();
		
		for(int i = 0; i< payload.length; i++) {
		encoded[i+1] = payload[i];
		}
		
		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		payload = new byte[received[0]];

		for(int i = 0; i < received[0]; i++) {
			 payload[i] = received[i+1];
			
		}
		
	}
}
