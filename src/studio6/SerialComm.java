package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = false; // Default is to NOT be in debug mode
	}
		
	// TODO: Add writeByte() method from Studio 5
	void writeByte(byte num){
		try {
			port.writeByte(num);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 
		if (debug){
		System.out.println(num);
		}
}
	
	// TODO: Add available() method
	boolean available() throws SerialPortException{
		boolean b = false;
		if (port.getInputBufferBytesCount() !=0){
			b = true;
		} else{
			b = false;
		}
		return b; 
	}
	
	// TODO: Add readByte() method	
	byte readByte() throws SerialPortException{
		byte[] a = port.readBytes(1);
		byte b = a[0];
		return b;
		
	}
	
	// TODO: Add a main() method
	static void main() throws SerialPortException{
		SerialComm port = new SerialComm("/dev/cu.usbserial-DN02ZB69");
		while(true){
			if (port.available()){
				System.out.println(port.readByte());
			}
		}
	}
}
