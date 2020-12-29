package datastructures.linkedlist;

import java.util.Stack;

/**
 * 单项链表只能从头遍历, 并且不能自我删除, 只能先找到待删除的前一个节点才可以
 * 使用带 head 头的单向链表实现 –水浒英雄排行榜管理完成对英雄人物的增删改查操作
 * 第一种方法在添加英雄时，直接添加到链表的尾部
 * 第二种方式在添加英雄时， 根据排名将英雄插入到指定位置(如果有这个排名，则添加失败，并给出提示)
 */
public class SingleLinkedListDemo {
    
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江");
        HeroNode hero2 = new HeroNode(2, "卢俊义");
        HeroNode hero3 = new HeroNode(3, "吴用");
        HeroNode hero4 = new HeroNode(4, "林冲");
        
        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        
        
        System.out.println("原来链表的情况~~");
        singleLinkedList.list();
        
        //测试一下看看是否得到了倒数第K个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println("res=" + res);
        
        // //测试修改节点的代码
        // HeroNode newHeroNode = new HeroNode(2, "小卢");
        // singleLinkedList.update(newHeroNode);
        // System.out.println("修改后的链表情况~~");
        // singleLinkedList.list();
        //
        // //删除一个节点
        // singleLinkedList.del(1);
        // singleLinkedList.del(4);
        // System.out.println("删除后的链表情况~~");
        // singleLinkedList.list();
        //
        
        System.out.println("反转单链表~~");
        // reversetList(singleLinkedList.getHead());
        reversetListStack(singleLinkedList.getHead());
        singleLinkedList.list();
        
        // System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
        // reversePrint(singleLinkedList.getHead());
		
        /*
		//加入按照编号的顺序
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		
		//显示一把
		singleLinkedList.list();
		
		
		//测试一下 求单链表中有效节点的个数
		System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));//2
		
        */
        
        
    }
    
    
    /**
     * 利用栈先进先出将单链表反转
     */
    public static void reversetListStack(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        // 逐个压栈
        Stack<HeroNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        
        // 尾插法todo
        
        // // 1.创建头结点,头结点的next指向null
        // HeroNode reverseHead = new HeroNode(0, "resversHead");
        // // 2.把头结点赋值给一个中间变量
        // // 3.循环中创建结点, 中间变量的next指向新结点
        // // 4.新结点覆盖中间变量
        // HeroNode temp = null;
        // while (stack.size() > 0) {
        //     HeroNode pop = stack.pop();
        //     temp = reverseHead;
        //     temp.next = pop;
        //     temp = pop;
        // }
        // // 重进接入
        // head.next = reverseHead.next;
    
    }
    
    /**
     * 头插法将单链表反转
     *
     * @param head
     */
    public static void reversetList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        // 定义一个新的链表. 遍历原来的链表, 取一个加到新的最前端
        HeroNode newHead = new HeroNode(0, "resversHead");
        // 当前
        HeroNode cur = head.next;
        // 当前节点的下个节点
        HeroNode next = null;
        while (cur != null) {
            // 1.右边右移, 临时记录下一个节点
            next = cur.next;
            // 2.把新链表的第一个节点(一大串)接到cur(一个)后面(头插法)
            cur.next = newHead.next;
            // 3.把接完后的cur再接回到新链表
            newHead.next = cur;
            // 4.游标后移继续遍历
            cur = next;
        }
        // 旧的链表指向新的链表
        head.next = newHead.next;
        
    }
    
    
    //查找单链表中的倒数第k个结点 【新浪面试题】
    //思路
    //1. 编写一个方法，接收head节点，同时接收一个index
    //2. index 表示是倒数第index个节点
    //3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    //4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    //5. 如果找到了，则返回该节点，否则返回nulll
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int length = getLength(head);
        if (index > length || index < 0) {
            return null;
        }
        int resIndex = length - index + 1;
        int cur = 1;
        HeroNode temp = head.next;
        while (temp != null) {
            if (cur == resIndex) {
                break;
            }
            temp = temp.next;
            cur++;
        }
        return temp;
    }
    
    /**
     * 面试题: 获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            // 遍历
            cur = cur.next;
        }
        return length;
    }
    
    ////判断如果链表为空，返回null
    //if (head.next == null) {
    //    return null;//没有找到
    //}
    ////第一个遍历得到链表的长度(节点个数)
    //int size = getLength(head);
    ////第二次遍历  size-index 位置，就是我们倒数的第K个节点
    ////先做一个index的校验
    //if (index <= 0 || index > size) {
    //    return null;
    //}
    ////定义给辅助变量， for 循环定位到倒数的index
    //HeroNode cur = head.next; //3 // 3 - 1 = 2
    //for (int i = 0; i < size - index; i++) {
    //    cur = cur.next;
    //}
    //return cur;
    
    
}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "");
    
    
    //返回头节点
    public HeroNode getHead() {
        return head;
    }
    
    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    
    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            int currNo = temp.no;
            if (heroNode.no == currNo) {
                System.out.println(heroNode.no + "排名已经存在,不能添加");
                break;
            }
            if (heroNode.no > currNo) {
                temp.next = heroNode;
                break;
            }
        }
    }
    
    
    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode heroNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点, 根据no编号
        boolean flag = false;
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                heroNode.next = temp.next;
                temp.name = heroNode.name;
                flag = true;
                System.out.printf("修改成功");
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.no);
        }
        
    }
    
    
    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }
    
    //显示链表[遍历]
    public void list() {
        HeroNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public HeroNode next; //指向下一个节点
    
    //构造器
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
    
    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }
    
}
