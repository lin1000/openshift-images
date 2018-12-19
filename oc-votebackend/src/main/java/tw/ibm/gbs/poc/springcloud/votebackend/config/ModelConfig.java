package tw.ibm.gbs.poc.springcloud.votebackend.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tw.ibm.gbs.poc.springcloud.votebackend.model.Link;

@Configuration
public class ModelConfig {

	@Bean
	public List<Link> links() {

		List<Link> links = new ArrayList();
		links.add(new Link("http://www.google.com.tw", 100));
		links.add(new Link("http://www.ibm.com", 200));
		links.add(new Link("http://www.ibm.com.tw", 150));
		links.add(new Link("http://www.ibm.com/cbp/01", 100));

		return links;
	}

}
