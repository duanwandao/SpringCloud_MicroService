package club.hdqyf.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import club.hdqyf.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;

/**
 * 实现fallback接口，进行服务降级等操作，避免provider臃肿 (AOP),减少高耦合
 * 
 * @author Garen
 *
 */
@Component // 不要忘记添加，不要忘记添加！！！
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable arg0) {
		return new DeptClientService() {
			@Override
			public Dept get(Long id) {
				return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDb_source("no this database in MySQL");
			}

			@Override
			public List<Dept> list() {
				return null;
			}

			@Override
			public boolean add(Dept dept) {
				return false;
			}

			@Override
			public Object discovery() {
				return null;
			}
		};
	}
}
