package com.briozing.employees.service;
import com.briozing.employees.models.EmployeeRequestVO;
import com.briozing.employees.models.EmployeeResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.lang.String;


import javax.sql.DataSource;
import java.util.Map;

@Service
public class EmployeeService {

    private static JdbcTemplate jdbcTemplate;
    public EmployeeService(@Autowired DataSource dataSource){
        jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public EmployeeResponseVO addEmployee(EmployeeRequestVO employeeRequestVO){
        int id = jdbcTemplate.update("insert into employee (name, emailId) values('"+employeeRequestVO.getName()+"','"+employeeRequestVO.getEmailId()+"')");
        EmployeeResponseVO employeeResponseVO=new EmployeeResponseVO();
        employeeResponseVO.setName(employeeRequestVO.getName());
        employeeResponseVO.setEmailId(employeeRequestVO.getEmailId());
        return employeeResponseVO;
    }

    public EmployeeResponseVO updateEmployee(EmployeeRequestVO employeeRequestVO, int id){
        int id1 = jdbcTemplate.update("UPDATE employee SET name = '"+employeeRequestVO.getName()+"',emailId='"+ employeeRequestVO.getEmailId()+"' WHERE id = '"+id+"'");
        System.out.println(id1);
        EmployeeResponseVO employeeResponseVO=new EmployeeResponseVO();
        employeeResponseVO.setName(employeeRequestVO.getName());
        employeeResponseVO.setEmailId(employeeRequestVO.getEmailId());
        employeeResponseVO.setId(id);
        return employeeResponseVO;
    }

//    public EmployeeResponse getEmployee(String name, String emailId) {
//        String query = "select * from employees";
//        System.out.println("Query :"+query);
//
//        return employeeResponseVO;
//    }

    public EmployeeResponseVO findEmployeeById(String id) {
        String query = "select * from employee where id = '" + id + "'";
        System.out.println("Query : " + query);
        Map<String ,Object> map=jdbcTemplate.queryForMap(query);
        EmployeeResponseVO employeeResponseVO=new EmployeeResponseVO();
        employeeResponseVO.setId(Integer.parseInt(String.valueOf(map.get("id"))));
        employeeResponseVO.setName(String.valueOf(map.get("name")));
        employeeResponseVO.setEmailId(String.valueOf(map.get("emailId")));

        System.out.println(employeeResponseVO);
        return employeeResponseVO;
    }

    public static int delete(int id){
        String query="DELETE from employee WHERE id=?";
        System.out.println("DELETE Query :- " + query);
        int deletedId = jdbcTemplate.update(query,id);

        return deletedId;
    }



}
