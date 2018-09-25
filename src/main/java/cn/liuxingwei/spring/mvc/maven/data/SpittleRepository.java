package cn.liuxingwei.spring.mvc.maven.data;
import java.util.List;
import cn.liuxingwei.spring.mvc.maven.entity.Spittle;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long spittleId);
    long createSpittle(Spittle spittle);
}
