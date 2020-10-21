package com.blazdemsar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//import com.blazdemsar.utilities.BannerImpl;

@SpringBootApplication
public class OnlineBankingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		/* SpringApplication.run(OnlineBankingApplication.class, args); */
		
		System.setProperty("server.servlet.context-path", "/MyApp");  // this way of changing servlet context not recognized by externatl Tomcat.
		
		SpringApplication app = new SpringApplication(OnlineBankingApplication.class);
		//app.setBannerMode(Mode.OFF); // Mode.OFF, Mode.LOG, Mode.CONSOLE
		//app.setBanner(new BannerImpl());
		app.setBannerMode(Mode.CONSOLE);
		app.run(args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(OnlineBankingApplication.class);
		
	}

}
