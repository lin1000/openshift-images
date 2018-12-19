package tw.ibm.gbs.poc.springcloud.appfrontend.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface LinkRepository extends MongoRepository<Link, String> {
	
    public Link findByUrl(String url);

}
