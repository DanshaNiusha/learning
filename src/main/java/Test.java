import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaokang
 * @date 2021/2/3
 */
public class Test {
    public static void main(String[] args) {
    
    }
    
    
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (!root.children.isEmpty()){
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return list;
        
        
    }
    
    private static class Node {
        public int val;
        public List<Node> children;
        
        public Node() {
        }
        
        public Node(int _val) {
            val = _val;
        }
        
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    
    ;
    
}
