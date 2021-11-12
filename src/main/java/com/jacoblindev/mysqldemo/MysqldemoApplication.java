package com.jacoblindev.mysqldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysqldemoApplication /* implements CommandLineRunner */ {

	// private Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Autowired
	// private EmployeeJDBCRepo employeeRepo;

	// @Override
	// public void run(String... args) throws Exception {

	// logger.info("Inserting -> {}",
	// employeeRepo.insert(new Employee(10011L, 0115604, "Ramesh", "Fadatare",
	// "ramesh@gmail.com")));
	// logger.info("Inserting -> {}",
	// employeeRepo.insert(new Employee(10012L, 0115605, "John", "Cena",
	// "john@gmail.com")));
	// logger.info("Inserting -> {}",
	// employeeRepo.insert(new Employee(10013L, 0115606, "tony", "stark",
	// "stark@gmail.com")));

	// logger.info("Employee id 10011 -> {}", employeeRepo.findById(10011L));

	// logger.info("Update 10003 -> {}",
	// employeeRepo.update(new Employee(10011L, 0115604, "ram", "Stark",
	// "ramesh123@gmail.com")));

	// employeeRepo.deleteById(10013L);

	// logger.info("All users -> {}", employeeRepo.findAll());
	// }

	public static void main(String[] args) {
		SpringApplication.run(MysqldemoApplication.class, args);
	}

}
