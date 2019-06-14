package club.hdqyf.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MySelfRule {
	@Bean
	public IRule myRule() {
		// return new RandomRule(); //默认是轮询，我们这里设置随机
		return new RandomRule_ByMe(); // 自定义的Ribbon负载均衡规则
	}
}
