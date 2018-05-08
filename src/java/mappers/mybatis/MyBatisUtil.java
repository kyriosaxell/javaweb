package mappers.mybatis;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisUtil {
    public static String RESOURCE = "mappers/mybatis/mybatis-config.xml";
    public static String ENVIROMENT = "develoment";
    private static SqlSessionFactory sqlSessionFactory;

       static{
        try{
            Reader reader;
            reader = Resources.getResourceAsReader(RESOURCE);
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }  
    }
    public static SqlSession getSqlSessionFactory() {
        SqlSession session = null;
        session = sqlSessionFactory.openSession();
        return session;
    }
}