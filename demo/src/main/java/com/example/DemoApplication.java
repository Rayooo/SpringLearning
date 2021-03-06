package com.example;

import demo.UiApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/user")
	public Principal user(Principal user){
		return user;
	}


	@RequestMapping("/resource")
	public Map<String,Object> home(){
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content","Hello Kitty");
		return model;
	}

	public static void main(String[] args){
		SpringApplication.run(UiApplication.class, args);
	}

	//    @Configuration
//    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//        @Override
//        protected  void configure(HttpSecurity http) throws Exception{
//            http
//                    .httpBasic().
//                    and()
//                    .authorizeRequests()
//                    .antMatchers("/index.html", "/home.html","login.html","/")
//                    .permitAll()
//                    .anyRequest()
//                    .authenticated();
//        }
//    }
	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.httpBasic()
					.and()
					.authorizeRequests()
					.antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
					.anyRequest().authenticated();
		}
	}
}
