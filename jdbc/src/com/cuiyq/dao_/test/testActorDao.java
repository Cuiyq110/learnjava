package com.cuiyq.dao_.test;

import com.cuiyq.dao_.dao.ActorDao;
import com.cuiyq.dao_.domain.Actor;
import org.junit.Test;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */

public class testActorDao {


//    测试ActorDao对actor表crud操作
    @Test
    public void testActorDao() {
        ActorDao actorDao = new ActorDao();
//        1. 查询
        List<Actor> actors = actorDao.queryMulti("select * from actor", Actor.class);
        System.out.println("===查询结果===");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

//        2.查询单行记录
        Actor actor = actorDao.querySingle("select * from actor where id = ?", Actor.class, 2);
        System.out.println("---单行记录查询结果---");
        System.out.println(actor);

//        3.单行单列查询结果
        Object o = actorDao.queryScalar("select name from actor where id = ?", 1);
        System.out.println("---单行单列查询结果---");
        System.out.println(o);

//        4.执行dml
        int update = actorDao.update("insert into actor(id,name,sex) values(null,?,?)", "大哥", "女");
        System.out.println("---update执行结果---");
        System.out.println(update > 0 ? "执行成功" : "未对表进行操作");

    }
}
