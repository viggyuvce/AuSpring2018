package crud;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public interface crudService {
	@WebMethod
	public String add(String id,String name, String designation, String Salary);
	@WebMethod
	public String remove(String id);
	@WebMethod
	public String getName(String id);
	@WebMethod
	public String update(String id,String increment);
}
