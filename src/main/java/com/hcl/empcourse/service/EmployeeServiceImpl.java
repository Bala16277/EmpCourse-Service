package com.hcl.empcourse.service;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jboss.logging.Logger;

import com.hcl.empcourse.Repository.EmployeeRepository;
import com.hcl.empcourse.dto.EmployeeDto;
import com.hcl.empcourse.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeDto getEmployeebyEmployeeId(Integer employeeId) {
		logger.info("Inside employee method::: ");
		EmployeeDto employeeDto = new EmployeeDto();
		Employee employee = employeeRepository.findByEmployeeId(employeeId);

		try {
			BeanUtils.copyProperties(employeeDto, employee);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return employeeDto;
	}

}
