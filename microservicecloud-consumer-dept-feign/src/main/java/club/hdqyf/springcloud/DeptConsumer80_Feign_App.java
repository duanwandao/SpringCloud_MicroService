package club.hdqyf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

import club.hdqyf.myrule.MySelfRule;

/**
 * 有feign来做客户端的负载均衡，就不需要RestTemplate + 链接端口访问微服务service的方法，因为我们这里是面向接口编程，接口集成在api里
 * @author Garen
 *
 */
@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class)
@EnableFeignClients(basePackages= {"club.hdqyf.springcloud"})
@ComponentScan("club.hdqyf.springcloud")
public class DeptConsumer80_Feign_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}
}
