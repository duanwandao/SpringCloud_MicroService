package club.hdqyf.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean { //boot使用注解@Configuration --> applicationContext.xml
	@Bean
	@LoadBalanced  //当new RestTemplate是自带负载均衡（Ribbon实现的一套客户端负载均衡的工具）
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * 更换Ribbon的使用规则
	 * @return
	 */
	@Bean
	public IRule myRule() {
		//return new RandomRule(); //达到目的，用我们重新选择的随机算法替代默认的轮询算法规则
		return new RetryRule();
	}
}

/*  
@Bean
public UserService getUserService() {
	return new UserServcieImpl();
}

这里的@Bean类似于  --> <bean id="userService" class="club.hdqyf.ebay.Service.impl.UserServiceImpl" />
*/