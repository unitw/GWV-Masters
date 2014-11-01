import java.util.ArrayList;

public class Path {

    ArrayList nodelist = new ArrayList();

    public Path(Node... s) {
        for (int i = 0; i < s.length; i++) {
            nodelist.add(s);
        }

    }
}
