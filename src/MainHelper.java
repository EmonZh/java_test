import java.util.ArrayList;
import java.util.List;

/**
 * @description: 测试类
 * @author: emonzhong
 * @create 2018-09-25 下午3:29
 */

public class MainHelper<RankerBase> {
    private List<RankerBase> m_ranker;

    public MainHelper(RankerBase ...args) {
        m_ranker = new ArrayList<RankerBase>();
        for (RankerBase ranker : args) {
            m_ranker.add(ranker);
        }
    }


    public int size() { return m_ranker.size(); }

}
