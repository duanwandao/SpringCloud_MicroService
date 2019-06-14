package club.hdqyf.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor 	// 全参构造函数
@NoArgsConstructor  	// 无参构造函数
@Data					// 提供类所有属性的 getting 和 setting 方法
@Accessors(chain=true)	// 链式访问，该注解设置chain=true，生成setter方法返回this，代替了默认的返回void
public class Dept implements Serializable{ // Dept(Entity) orm mysql --> Dept(table)  类表关系映射
	private Long 	deptno; // 主键
	private String 	dname; // 部门名称
	private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
}