package com.ust.employee_service.Generator;

import java.io.Serializable;
import java.time.Year;
import java.util.UUID;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.ust.employee_service.repository.EmployeeRepository;

@Component // Register this class as a Spring bean
public class CustomIdGenerator implements IdentifierGenerator, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext context) {
        applicationContext = context;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        EmployeeRepository employeeRepository= applicationContext.getBean(EmployeeRepository.class);
        int count = (int) employeeRepository.count();
        int currentYear = Year.now().getValue();
        String yearSuffix = String.valueOf(currentYear).substring(2);
        String formattedCount = String.format("%04d", count + 1);
        return "EMP" + yearSuffix + formattedCount;
    }
}
