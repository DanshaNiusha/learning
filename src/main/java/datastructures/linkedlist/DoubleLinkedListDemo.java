package datastructures.linkedlist;

/**
 * 双向链表
 *
 * @author liuxiaokang
 * @date 2020/12/28
 */
public class DoubleLinkedListDemo {
    
    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义");
        HeroNode2 hero3 = new HeroNode2(3, "吴用");
        HeroNode2 hero4 = new HeroNode2(4, "林冲");
        HeroNode2 hero5 = new HeroNode2(5, "dansha");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero5,1);
        
        doubleLinkedList.list();
        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();
        // 删除
        doubleLinkedList.del(4);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();
    }
}

// 创建一个双向链表的类
class DoubleLinkedList {
    
    private HeroNode2 head = new HeroNode2(0, "");
    
    public HeroNode2 getHead() {
        return head;
    }
    
    private HeroNode2 last = head;
    
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
        
    }
    public void add(HeroNode2 heroNode,int index) {
        HeroNode2 temp = head.next;
        int cur = 0;
        while (temp != null) {
            if (index == cur){
                heroNode.next = temp.pre.next;// 原位置的接到新节点的屁股上
                temp.pre.next = heroNode;
                temp.next.pre = heroNode;
            }
            temp = temp.next;
            cur++;
        }
    }
    
    public void list() {
        if (head.next==null){
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        
    }
    
    public void update(HeroNode2 newHeroNode) {
        HeroNode2 temp = head.next;
        while (temp != null) {
            if (temp.no == newHeroNode.no) {
                temp.name = newHeroNode.name;
                break;
            }
            temp = temp.next;
        }
        
    }
    
    public void del(int no) {
        HeroNode2 temp = head.next;
        while (temp != null) {
            if (temp.no == no) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public HeroNode2 next;
    public HeroNode2 pre;
    
    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }
    
}