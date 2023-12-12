package com.jsp.spring_mvc_crud_operation.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc_crud_operation.dao.EmployeeDao;
import com.jsp.spring_mvc_crud_operation.dto.Employee;
import com.jsp.spring_mvc_crud_operation.service.EmployeeService;




@Controller
public class UniversityController {

	@RequestMapping(value = "/") 
	public ModelAndView viewEmployees(@ModelAttribute Employee employee) {
		EmployeeService service = new EmployeeService(); 
		List<Employee> employees = service.displayAllEmployeeService();
		ModelAndView andView = new ModelAndView("employees"); 
		andView.addObject("employeeList", employees);
		return andView; 
	}

	@RequestMapping("/create")
	public ModelAndView openIndexFile() {
		ModelAndView andView = new ModelAndView("create");
		andView.addObject("employee", new Employee());
		return andView;
	}



	@RequestMapping(value = "/register") 
	public String saveEmployee(@ModelAttribute Employee employee) {

		EmployeeService service = new EmployeeService(); 
		Employee created =  service.saveemployeeService(employee);

		return "redirect:/";
	}
	
	
	 @GetMapping("/edit/{id}")
	    public ModelAndView updateEmployeeForm( @PathVariable int id) {
		 EmployeeService service = new EmployeeService(); 
	        Employee employee = service.getEmployeeByIdService(id);
	        ModelAndView andView = new ModelAndView("edit"); 
			andView.addObject("employee", employee);
			return andView; 
	    }

	    @PostMapping("/edit/{id}")
	    public String updateEmployee(Model model, @PathVariable int id, @ModelAttribute Employee employee) {
	    	EmployeeService service = new EmployeeService(); 
	        service.updateEmployeeServices(id, employee.getName());
	        model.addAttribute("message", "Employee updated successfully!");
	        return "redirect:/employee";
	    }
	/*
	 * @GetMapping("/edit/{id}") public ModelAndView showUpdateForm(@ModelAttribute
	 * int id) { EmployeeService service = new EmployeeService(); Employee employee
	 * = service.getEmployeeByIdService(id); ModelAndView andView = new
	 * ModelAndView("edit"); andView.addObject("employee", employee); return
	 * andView; }
	 * 
	 * @PutMapping("/edit/{id}") public String updateEmployee( @ModelAttribute int
	 * id,@ModelAttribute String employeeName) { EmployeeService service = new
	 * EmployeeService(); service.updateEmployeeServices(id, employeeName); return
	 * "redirect:/"; }
	 */

	/*
	 * @Autowired private EmployeeService employeeService;
	 * 
	 * @PostMapping("/saveEmployee") public Employee saveEmployee(@RequestBody
	 * Employee employee) { return employeeService.saveemployeeService(employee); }
	 */

	//	  SAVE EMPLOYEE  			route: /employee  method: POST  body: Employee

	//	  Delete employee by id	 	route: /employee/[id]  method: DELETE  body: null

	//	  Get employee by id		route: /employee/[id]   method: GET   

	//	  List all employee			route: /employee	method: GET
}
