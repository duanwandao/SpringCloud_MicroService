package club.hdqyf.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import club.hdqyf.springcloud.entities.Dept;
import club.hdqyf.springcloud.service.DeptClientService_Config;

@RestController
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService_Config service;

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return this.service.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list()
	{
		return this.service.list();
	}

	@RequestMapping(value = "/consumer/dept/add")
	public Object add(Dept dept)
	{
		return this.service.add(dept);
	}
	
	//测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value="/consumer/dept/discovery")
	public Object discovery() {
		return this.service.discovery();
	}
}
