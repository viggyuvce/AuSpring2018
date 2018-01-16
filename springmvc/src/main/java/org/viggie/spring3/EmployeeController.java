package org.viggie.spring3;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
import org.viggie.spring1.Employee;  
import org.viggie.spring2.EmployeeDAO;  
@Controller

public class EmployeeController {
    @Autowired  
    EmployeeDAO dao;

    @RequestMapping("/form")  
    public ModelAndView showform(){  
        return new ModelAndView("empform","command",new Employee());  
    }  
 
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("Employee") Employee Employee){  
        dao.save(Employee);  
        return new ModelAndView("redirect:/viewemployee");//will redirect to viewemp request mapping  
    }  
 
    @RequestMapping("/viewemployee")  
    public ModelAndView viewemp(){  
        List<Employee> list=dao.getEmployees();  
        return new ModelAndView("viewemployee","list",list);  
    }  
    
    @RequestMapping(value="/editemployee/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Employee Employee=dao.getEmpById(id);  
        return new ModelAndView("empeditform","command",Employee);  
    }  
   
    @RequestMapping(value="/editSave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("Employee") Employee Employee){  
        dao.update(Employee);  
        return new ModelAndView("redirect:/viewemployee");  
    }  
    @RequestMapping(value="/deletEmp/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        dao.delete(id);  
        return new ModelAndView("redirect:/viewemployee");  
    } 

}
