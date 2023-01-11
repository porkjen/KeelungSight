package com.springboot.demo;

import com.springboot.demo.entity.Sight;
import com.springboot.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);//啟動
		applicationContext.start();
		//ProductController controller = new ProductController();
	}

	@Component
	class ContextStartedListener implements ApplicationListener<ContextStartedEvent>{
		@Autowired
		private ProductRepository repository;
		@Autowired
		private ProductService service;

		@Override
		public void onApplicationEvent(ContextStartedEvent event) {
			KeelungSightsCrawler crawler = new KeelungSightsCrawler();
			List<Sight> sights = crawler.getItems();
			for(Sight s: sights){
				repository.save(s);
			}
		}
	}
}
