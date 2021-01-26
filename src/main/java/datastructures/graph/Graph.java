package datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图
 * @author liuxiaokang
 * @date 2021/1/25
 */
public class Graph {
    
    
    public static void main(String[] args) {
        int n = 8;
        // String vertex[] = {"A","B","C","D","E"};
        String vertex[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        
        //创建图对象
        Graph graph = new Graph(n);
        for (String val : vertex) {
            graph.insertVertex(val);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        // graph.insertEdge(0,1,1);
        // graph.insertEdge(0,2,1);
        // graph.insertEdge(1,2,1);
        // graph.insertEdge(1,3,1);
        // graph.insertEdge(1,4,1);
    
        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
    
    
        //显示一把邻结矩阵
        graph.showGraph();
    
        //测试一把，我们的dfs遍历是否ok
        System.out.println("深度遍历");
        // graph.dfs(); // A->B->C->D->E [1->2->4->8->5->3->6->7]
        System.out.println("广度优先!");
        graph.bfs(); // A->B->C->D-E [1->2->3->4->5->6->7->8]
        
    }
    
    /**
     * 顶点集合
     */
    private final ArrayList<String> vertexList;
    /**
     * 存储对应的邻结矩阵
     */
    private final int[][] edges;
    /**
     * 边的数目
     */
    private int numOfEdges;
    
    /**
     * 记录某个节点是否被访问
     */
    private boolean[] isVisited;
    
    // n 顶点个数
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;//初始化不知道有几条边 默认为0
        isVisited = new boolean[n];
    }
    
    
    /**
     * 查找第一个邻接节点
     * @param index
     * @return 存在就返回对应的下标, 否则-1
     */
    public int getFirstNeihbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 根据前一个邻接节点坐标获取下一个邻接节点
     * @return 存在就返回对应的下标, 否则-1
     */
    public int getNextNeihbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }
    /////////////////////////////////////////深度优先////////////////////////////////////////
    /**
     * 对dfs进行重载,遍历所有的节点,并进行dfs(遍历不连通图)
     */
    public void dfs() {
        // 遍历所有的节点进行dfs
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }
 
    /**
     * 深度优先遍历算法
     * @param isVisited
     * @param i 第一次是0
     */
    private void dfs(boolean[] isVisited, int i){
        // 输出
        System.out.print(getValueByIndex(i)+"-> ");
        // 标记节点为已访问
        isVisited[i] = true;
        // 查找邻接节点
        int w = getFirstNeihbor(i);
        while (w != -1) { // 存在邻接点
            // w未被访问过,继续往深查
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            // w被访问过
            w = getNextNeihbor(i,w);
        }
    
    }
    /////////////////////////////////////////深度优先////////////////////////////////////////
    
    
    /////////////////////////////////////////广度优先////////////////////////////////////////
    /**
     * 对一个节点进行广度优先遍历
     */
    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }
    
    private void bfs(boolean[] isVisited, int i) {
        int u;// 头结点对应的下标
        int w; // 邻接节点
        //队列 记录节点访问的的顺序
        LinkedList<Integer> queue = new LinkedList<>();
        // 访问节点
        System.out.print(getValueByIndex(i) + "->");
        // 标记为已访问
        isVisited[i] = true;
        // 讲这个节点加进队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeihbor(u);
            while (w != -1) { // 说明找到了
                if (!isVisited[w]) { //没访问过
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                // 以u为前驱点, 找w后面的下一个邻节点
                w = getNextNeihbor(u, w);// *体现广度优先
            }
            
        }
    }
    
    /////////////////////////////////////////广度优先////////////////////////////////////////
    
    /**
     * 插入结点
     * @param vertex
     */
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    
    /**
     * 插入边
     * @param v1 插入点1
     * @param v2 插入点2
     * @param weight 权值表示12的关系 0没连起来 1连起来
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
    
    /**
     * 结点的总个数
     */
    public int getNumOfVertex(){
        return vertexList.size();
    }
    
    /**
     * 图边的个数
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }
    
    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }
    
    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }
    
    //返回v1和v2的权值
    public void showGraph() {
        Arrays.stream(edges).forEach(link -> System.out.println(Arrays.toString(link)));
    }
    
    
    
    
    
}
