package com.xgileit.PizzaOrderManagementSystem;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.Status;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Chef;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.DeliveryPerson;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Manager;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ChefRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.DeliveryPersonRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ManagerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzaOrderManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaOrderManagementSystemApplication.class, args);
	}


	/**
	 * They already work at this restaurant, so I won't need to register them. They can just
	 * log in.
	 *
	 * @param managerRepository
	 * @param chefRepository
	 * @param deliveryPersonRepository
	 * @return
	 */
	@Bean
	CommandLineRunner run(ManagerRepository managerRepository, ChefRepository chefRepository,
						  DeliveryPersonRepository deliveryPersonRepository)
	{
		return args -> {
			//ID = 1
			managerRepository.save(new Manager("Adam", "Adam@admin.com", "qwerty", "876718676", "76 Strand Street CT")).setStatus(Status.LOGGED_OUT);

			//ID = 2
			chefRepository.save(new Chef("James", "James@chef.com", "food", "876331116", "742 Adderley Street CT")).setStatus(Status.LOGGED_OUT);

			//ID = 3
			deliveryPersonRepository.save(new DeliveryPerson("Bryston", "Bryston@delivery.com", "fast", "07142842", "11 Long Street CT")).setStatus(Status.LOGGED_OUT);
		};
	}

}
