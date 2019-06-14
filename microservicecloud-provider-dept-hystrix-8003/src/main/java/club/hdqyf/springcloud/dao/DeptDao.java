package club.hdqyf.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import club.hdqyf.springcloud.entities.Dept;

@Mapper  //帮助springboot识别这位dao接口
public interface DeptDao {
	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
