package com.customer;

import com.customer.Model.User;
import com.customer.Respository.UserRespository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.*;
import java.util.Optional;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication {

    @Autowired
    private UserRespository userRespository;

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
        System.out.println("Customer Service");
    }
//    @PostConstruct
//    public void AddData() throws FileNotFoundException {
//
//        try(
//                InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.csv");
//                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
//
//            String line;
//            br.readLine(); // skip headings
//            while ((line = br.readLine()) != null){
//                String[] data = line.split(",");
//                String name = data[0];
//                String email = data[1];
//                String password = data[2];
//                User cUser= new User();
//                cUser.setName(name);
//                cUser.setEmail(email);
//                cUser.setPassword(password);
//                cUser.setRole("USER");
//
//
//                Optional<User> user = userRespository.findByEmail(email);
//                if(user.isEmpty()){
//                    userRespository.save(cUser);
//                    log.info("User {} has been saved",cUser.getName());
//                }else{
//                    log.error("User Already Exists with Email: "+email);
//                }
//
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
