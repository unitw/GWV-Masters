import java.util.ArrayList;
import java.util.List;

public class Path {

    ArrayList<Node> nodelist = new ArrayList<Node>();

    public Path(Node s) {
        nodelist.add(s);
    }
    
    public Path()
    {
        
    }
    
    public Node getLastNode()
    {
        int lastIndex = nodelist.size() - 1;
        if (lastIndex > 0)
        {
            return nodelist.get(lastIndex);
        }
        else
        {
            return null;
        }
    }
    
    public List<Character> getCharPath()
    {
        List<Character> charList = new ArrayList<Character>();
        for (Node node:nodelist)
        {
            charList.add(node.getDirection());
        }
        
        return charList;
    }
}
