package org.rhq.test.jmxplugin;

import java.lang.management.ManagementFactory;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.ObjectInstance;
import javax.management.ObjectName;

public class CreateAndRegisterMBeanInMBeanServer {
	public static void main(String[] args) throws Exception {
		
		String objectName = "rhq.jmxtest:type=Hello";
		
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();

	    // Construct the ObjectName for the Hello MBean we will register
	    ObjectName mbeanName = new ObjectName(objectName);
	    
	    Hello mbean = new Hello();
	    
	    server.registerMBean(mbean, mbeanName);
	    
	    Set<ObjectInstance> instances = server.queryMBeans(new ObjectName(objectName), null);
	    
	    ObjectInstance instance = (ObjectInstance) instances.toArray()[0];
	    
	    System.out.println("Class Name:" + instance.getClassName());
	    System.out.println("Object Name:" + instance.getObjectName());
	    System.out.println("Ctl-C to quit");
	    while (true) {
	    	Thread.sleep(1000);
	    }
		
	}
}
