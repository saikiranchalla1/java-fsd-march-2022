import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.dell.simplilearn.spring.A;
import com.dell.simplilearn.spring.Employee;
import com.dell.simplilearn.spring.Question;
import com.dell.simplilearn.springjdbc.EmployeeDAO;
import com.dell.simplilearn.springjdbc.EmployeeJDBC;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource r = new ClassPathResource("applicationContext.xml");
		
		BeanFactory factory = new XmlBeanFactory(r);
		
//		Employee s = (Employee) factory.getBean("e");
//		s.show();
//		
//		Question q = (Question) factory.getBean("q");
//		q.displayInfo();
//		
//		
//		A a = factory.getBean("a", A.class);
//		
//		a.diplay();
		
		
		
		EmployeeDAO dao = (EmployeeDAO) factory.getBean("edao");
		boolean status = dao.saveEmployeeByPreparedStatement(new EmployeeJDBC(105, "Sai", 35000));
	
		System.out.println(status);
		
		List<EmployeeJDBC> returnVal = dao.getAllEmployeesRowMapper();
		
		for (EmployeeJDBC employeeJDBC : returnVal) {
			System.out.println(employeeJDBC.toString());
		}
		
		dao.save(new EmployeeJDBC(205, "Sai", 35000));
		
	}
	
	
	

}
/*

byName
byType
autodetect
no
constructor
*/