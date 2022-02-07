package design.statemachine.state;

import design.statemachine.IMarioState;
import design.statemachine.MarioStateMachine;
import design.statemachine.StateEnum;

public class SuperMario implements IMarioState {
    private static final SuperMario instance = new SuperMario();
    
    private SuperMario() {
    }
    
    public static SuperMario getInstance() {
        return instance;
    }
    
    @Override
    public StateEnum getName() {
        return StateEnum.SUPER;
    }
    
    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        // do nothing
    }
    
    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }
    
    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(FireMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }
    
    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 300);
    }
}
