package tw.ibm.gbs.poc.springcloud.votebackend.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ibm.gbs.poc.springcloud.votebackend.model.Link;

@RestController
class VoteController {
	
	@Autowired
	public List<Link> links;
 
   @RequestMapping("/links/")
   public List<Link> getLinks() {
	   
	   Iterator it = links.iterator();
	   while(it.hasNext()) {
		   Link link = (Link) it.next();
		   System.out.println(link.getUrl()+ " " + String.valueOf(link.getScore()));
		   
	   }
	   
      return links;
   }
}