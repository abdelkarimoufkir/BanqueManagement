package com.aoufkir.tuto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.aoufkir.tuto.entity.ClientTypes;
import com.aoufkir.tuto.entity.Clients;
import com.aoufkir.tuto.entity.CompteTypes;
import com.aoufkir.tuto.repository.ClientRepository;
import com.aoufkir.tuto.repository.ClientTypesRepository;
import com.aoufkir.tuto.repository.CompteTypesRepository;

@SpringBootApplication
public class MyspringDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyspringDemo1Application.class, args);
		
	//  Ajout Data Demo On Load 
		/*	ApplicationContext ctx = SpringApplication.run(MyspringDemo1Application.class, args);
			
				ClientTypesRepository cltyperepo = ctx.getBean(ClientTypesRepository.class);
				cltyperepo.save(new ClientTypes("Étudiant","Personnel"));
				cltyperepo.save(new ClientTypes("Commerçant","Professionel"));
				cltyperepo.save(new ClientTypes("AE","Auto-Entrepreneur"));
				
				CompteTypesRepository comptetyprerepo = ctx.getBean(CompteTypesRepository.class);
				comptetyprerepo.save(new CompteTypes("Courant","un compte salarié"));
				comptetyprerepo.save(new CompteTypes("Épargne","un compte personnel"));
				comptetyprerepo.save(new CompteTypes("Société","un compte professionel"));
			
			 */
			

	}

}
