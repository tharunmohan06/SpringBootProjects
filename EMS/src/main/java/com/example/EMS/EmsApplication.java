package com.example.EMS;

//import org.springframework.beans.factory.annotation.Autowired;
//import java.util.List;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EmsApplication { //implements CommandLineRunner
	
	//@Autowired
	//EmsRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * //print details from the table EmsBean ems=
	 * repository.findById("e002").get(); System.out.println(ems.geteId());
	 * System.out.println(ems.geteName()); System.out.println(ems.geteSal());
	 * 
	 * //insert records into the table EmsBean ems1= new EmsBean();
	 * ems1.seteId("Tharun1"); ems1.seteName("Tharun"); ems1.seteSal("10000");
	 * repository.save(ems1);
	 * 
	 * //print all the names in the table List<EmsBean> allrecords =
	 * repository.findAll();
	 * 
	 * for (EmsBean items: allrecords) { System.out.println(items.geteName()); }
	 * 
	 * //delete record from table repository.delete(ems1); }
	 */
}
