package tw.ibm.gbs.poc.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "tw.ibm.gbs.poc.springcloud.votebackend" })
public class VoteBackend {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("=" + args[0] + ":" + args[1] + "=");
        System.out.println("============================================");
        SpringApplication.run(VoteBackend.class, args);
    }

}
