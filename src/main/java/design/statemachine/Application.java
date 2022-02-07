package design.statemachine;

import com.alibaba.fastjson.JSON;

/**
 * 状态模式实现有限状态机
 * 状态,事件,动作  事件驱动状态流转,状态流转触发动作
 * 马里奥吃蘑菇,或者冰火能力,进行状态流转,然后加减分数
 *
 * @author liuxiaokang
 * @date 2022/1/29
 */
public class Application {
    public static void main(String[] args) {
        
        MarioStateMachine stateMachine = new MarioStateMachine();
        // 吃蘑菇
        stateMachine.obtainMushRoom();
        System.out.println(JSON.toJSONString(stateMachine));
        
        // 吃火
        stateMachine.obtainFireFlower();
        System.out.println(JSON.toJSONString(stateMachine));
        
        // 吃冰
        stateMachine.obtainCape();
        System.out.println(JSON.toJSONString(stateMachine));
        
        // 碰怪物
        stateMachine.meetMonster();
        System.out.println(JSON.toJSONString(stateMachine));
        
    }
    
}
