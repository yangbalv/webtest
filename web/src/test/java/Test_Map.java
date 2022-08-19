import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test_Map {
    public void test1() {
        Map map1 = new HashMap();
        Map map2 = new ConcurrentHashMap();
        map1.forEach((aa, bb) -> {
        });
        map2.forEach((aa, bb) -> {
        });
        Hashtable hashtable = new Hashtable();
        com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable hashtable2 = new com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable();
    }

}
