package com.bootbasic.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Dell
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableScheduling

public class DemoApplication implements ApplicationRunner{

	
    private static final Logger logger = LogManager.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	
	}
	
	
	
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.bootbasic.demo")).build();
	   }



	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("debug meassage");
		//System.out.println("Application Runner Calls");
		
	}
	
	/**
	 * FIXED RATE SCHEDULER IS USED TO EXECUTE THE TASKS AT THE SPECIFIC TIME. 
	 * IT DOES NOT WAIT FOR THE COMPLETION OF PREVIOUS TASK. THE VALUES SHOULD BE IN MILLISECONDS.
	
	  @Scheduled(fixedRate = 1000)
	   public void fixedRateSch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Fixed Rate scheduler:: " + strDate);
	   }
	   */
	
	
	  /**
		 * FIXED DELAY SCHEDULER IS USED TO EXECUTE THE TASKS AT A SPECIFIC TIME. 
		 * IT SHOULD WAIT FOR THE PREVIOUS TASK COMPLETION. THE VALUES SHOULD BE IN MILLISECONDS.
		
	  @Scheduled(fixedDelay = 1000, initialDelay = 3000)
	   public void fixedDelaySch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Fixed Delay scheduler:: " + strDate);
	   }
	    */

}
