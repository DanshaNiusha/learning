package design.statemachine;

public interface IMarioState {
    StateEnum getName();
    
    // 吃蘑菇 变大
    void obtainMushRoom(MarioStateMachine stateMachine);
    
    // 冰能力
    void obtainCape(MarioStateMachine stateMachine);
    
    // 火能力
    void obtainFireFlower(MarioStateMachine stateMachine);
    
    // 碰到怪物 变小
    void meetMonster(MarioStateMachine stateMachine);
}
