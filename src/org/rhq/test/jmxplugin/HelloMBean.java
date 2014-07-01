package org.rhq.test.jmxplugin;

public interface HelloMBean {
	// operations
	public void sayHello();

	// attributes
	// a read-write attribute called Message of type String
	public String getMessage();
	public void setMessage(String message);
}
