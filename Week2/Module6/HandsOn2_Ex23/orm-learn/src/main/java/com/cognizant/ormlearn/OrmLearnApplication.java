package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context =
            SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        testGetEmployee();
        testGetDepartment();
        testGetSkill();
    }

    // Many-to-One: Get employee with department
    private static void testGetEmployee() {
        LOGGER.info("Start testGetEmployee");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());
        LOGGER.debug("Skills: {}", employee.getSkills());
        LOGGER.info("End testGetEmployee");
    }

    // One-to-Many: Get department with employees
    private static void testGetDepartment() {
        LOGGER.info("Start testGetDepartment");
        Department department = departmentService.get(1);
        LOGGER.debug("Department: {}", department);
        LOGGER.debug("Employees: {}", department.getEmployees());
        LOGGER.info("End testGetDepartment");
    }

    // Get skill
    private static void testGetSkill() {
        LOGGER.info("Start testGetSkill");
        Skill skill = skillService.get(1);
        LOGGER.debug("Skill: {}", skill);
        LOGGER.info("End testGetSkill");
    }
}