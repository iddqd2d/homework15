package com.jpa;

import com.jpa.entity.Developer;
import com.jpa.services.DeveloperService;
import lombok.extern.log4j.Log4j;

@Log4j
public class Main {
    public static void main(String[] args) {
        DeveloperService developerService = new DeveloperService();

        Developer developerToBase = new Developer();
        developerToBase.setName("Zak");
        developerToBase.setAge(21);
        developerToBase.setMale(true);
        developerToBase.setSalary(1000);
        developerService.create(developerToBase);

        Developer developerFromBase = developerService.read(1);

        developerFromBase.setSalary(100);
        developerService.update(developerFromBase);

        developerService.delete(developerFromBase);
    }
}
