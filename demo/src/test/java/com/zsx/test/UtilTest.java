package com.zsx.test;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zsx.Application;
import com.zsx.dao.TuserDao;
 
@RunWith(SpringJUnit4ClassRunner.class)
 
//ָ������SpringBoot���̵�Application������
@SpringApplicationConfiguration(classes = Application.class)
//������Web��Ŀ��Junit��Ҫģ��ServletContext�����������Ҫ�����ǵĲ��������@WebAppConfiguration
@WebAppConfiguration
public class UtilTest {
 
    @Autowired
    private TuserDao dao;
 
    @Autowired
    private EntityManager em;
 
    @Test
    public void test1(){
        dao.findByUserName("admin");
    }
 
    @Test
    public void test3(){
        EntityManager em = dao.getEntityManager();
        Query query = em.createNativeQuery("select * from t_user limit 1");
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);
    }
}
    /*
//ִ��ԭ��SQL
 Query nativeQuery = em.createNativeQuery(String sql);
//ָ�����ض�������
nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean( Class resultType));
//���ض���
List<t> resultList = nativeQuery.getResultList();  
*/