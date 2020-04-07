package com.ricky.example.service.Imp;

import com.ricky.example.dao.EmployeeDao;
import com.ricky.example.entity.Employee;
import com.ricky.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ricky
 * @create 2019-09-09 20:44
 */
@CacheConfig(cacheManager = "empCacheManager") //引入使用的缓存管理，不设置默认使用主缓存管理
@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public int insert(Employee employee) {
        return employeeDao.insert(employee);
    }



    /**
     * @CacheEvict 缓存清除,E:删除员工后就不需要保留相关的缓存数据
     *   1.key = "#id"：删除指定的id
     *   2.allEntries = true：清除这个缓存所有的数据
     *   3.beforeInvocation
     *     beforeInvocation = false:
     *       指定缓存清除在方法执行之前执行,默认在方法之后执行;如果出现异常则不会清除缓存
     *     beforeInvocation = true:
     *       代表缓存清除操作是在方法运行之前执行，无论方法出现异常，缓存都会清除
     */
    @CacheEvict(value = "emp")
    @Override
    public int delete(Integer id) {
        return employeeDao.delete(id);
    }



    /**
     * @CachePut 既调用方法，又更新缓存数据；
     *   通过设定key来更新数据：
     *     key = "#employee.id"
     *     key = "#result.id"
     */

    @CachePut(value = "emp",key = "#result.id")
    @Override
    public int update(Employee employee) {
        return employeeDao.update(employee);
    }





    /**
     * 将方法的运行结果进行缓存：以后读取相同的数据直接从缓存读取，不调用方法 @Cacheable
     *
     * CacheManager管理多个Cache组件，对缓存的真正CRUD组件中，每一个缓存都有自己唯一的名字
     * 属性：
     *    cacheNames/value：指定缓存组件的名字
     *
     *  key和keyGenerator二选一
     *    key：缓存数据使用的KEY，可以用他指定数据，默认是使用方法参数的值，1-方法的返回值
     *         值用SpEl表达式指定：#id：参数id的值， #a0 #p0 #root.args[0]
     *       E:key = "#root.methodName+'['+#id+']'"
     *    keyGenerator：key的生成器，可以自己指定key的生成器的组件id
     *       E:keyGenerator = "keyGenerator";指定自定义key生成策略注册Bean的ID名称
     *
     *    cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
     *    condition：指定符合条件下才缓存
     *       E:condition = "#id>0"
     *    unless：否定缓存；当unless指定的条件为true时，方法的返回值就不会被缓存，可以获取结果进行判断
     *       E:unless = "#result == null"
     *    sync：是否采用异步模式
     */
    @Cacheable(cacheNames = {"emp"})
    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }

    @Cacheable(cacheNames = {"emp"})
    @Override
    public List<Employee> queryAll() {
        return employeeDao.queryAll();
    }
}
