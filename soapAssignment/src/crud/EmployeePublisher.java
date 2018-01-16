package crud;

import javax.xml.ws.Endpoint;

public class EmployeePublisher {
	public static void main(String[] args) {
		  Endpoint.publish("http://localhost:8083/WS/Employee",new EmployeeList());
		 }
}
