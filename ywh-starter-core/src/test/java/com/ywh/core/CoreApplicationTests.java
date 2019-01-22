package com.ywh.core;

import com.ywh.cache.utils.RedisUtil;
import com.ywh.core.dao.ExampleDao;
import com.ywh.core.dao.UserDao;
import com.ywh.core.entity.ExampleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {

	@Autowired
	private ExampleDao exampleDao;

	@Autowired
    private UserDao userDao;

	@Test
	public void contextLoads() {
		List<ExampleEntity> all = exampleDao.findAll();
		System.out.println(all);
	}


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 测试stringRedisTemplate连接redis，并存入数据
     */
    @Test
    public void redisTest(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        redisTemplate.opsForValue().set("abc","测试");
        redisTemplate.opsForList().leftPushAll("ywh",list);
    }

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void redisUtilTest(){
        //设置缓存的值，默认为24小时
        redisUtil.setString("测试1","哈哈哈哈1111");
        System.out.println("获取String类型的指定key的值：" + redisUtil.getString("测试1"));
        System.out.println("删除指定key的数据：" + redisUtil.deleteKey("redisRight"));
        System.out.println("判断指定的key是否存在：" + redisUtil.existsKey("测试1"));
        System.out.println("返回指定key的缓存类型：" + redisUtil.typeKey("测试1"));

        //System.out.println("返回List类型的缓存的指定的key的所有数据" + redisUtils.getList("redisLeft",0,-1));
        String listValue1 = "1123";

        List<ExampleEntity> listValue2 = new ArrayList<>();
        for(int i =0;i<2;i++){
            ExampleEntity examplePojo = new ExampleEntity();
            examplePojo.setId(i);
            examplePojo.setAge(i + "");
            examplePojo.setGender(i + "");
            examplePojo.setName("" + i);
            listValue2.add(examplePojo);
        }
        System.out.println("设置List类型的缓存数据，单个数据不设置时间:" + redisUtil.setList("测试2",listValue1));
        System.out.println("设置List类型的缓存数据，单个数据设置时间:" + redisUtil.setList("测试3",listValue1,60));
        //0到-1为所有数据
        System.out.println("返回List类型的缓存的指定的key的所有数据:" + redisUtil.getList("测试3",0,1));
        System.out.println("设置List类型的缓存数据，list集合设置时间:" + redisUtil.setList("测试4",listValue2,60));
        System.out.println("删除指定Key的数据：" + redisUtil.deleteKey("测试4"));
        List<String> keys = new ArrayList<>();
        keys.add("测试3");
        keys.add("测试2");
        System.out.println("删除指定Key的集合的数据：" + redisUtil.deleteKey(keys));
        System.out.println("设置List类型的缓存数据，单个数据不设置时间:" + redisUtil.setList("测试2",listValue1));
        System.out.println("设置List类型的缓存数据，单个数据设置时间:" + redisUtil.setList("测试3",listValue1,60));
        System.out.println("设置List类型的缓存数据，list集合设置时间:" + redisUtil.setList("测试4",listValue2,60));
        System.out.println("设置List类型的缓存数据，追加list集合设置时间" + redisUtil.setListAll("测试4",listValue2,60));
        System.out.println("获取List的大小：" + redisUtil.getListSize("测试4"));
        System.out.println("删除List缓存中某一个list数据：" + redisUtil.deleteListIndex("测试4",1,listValue2));
        //测试设置时间
        redisUtil.expire("测试1",60);
        //测试给list相同key值 是否覆盖，不覆盖是正确的
        redisUtil.setList("sss","hahah");
        redisUtil.setList("sss","xixixix");
    }
}

