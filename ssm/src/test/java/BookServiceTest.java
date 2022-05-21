import com.gzeic.dao.BookMapper;
import com.gzeic.pojo.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class BookServiceTest {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("unused/mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build( is );

        SqlSession session = factory.openSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
        Book book = mapper.findBookById(1);
        System.out.println( book );

    }

}
