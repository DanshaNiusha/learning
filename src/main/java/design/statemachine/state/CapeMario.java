package design.statemachine.state;

import design.statemachine.IMarioState;
import design.statemachine.MarioStateMachine;
import design.statemachine.StateEnum;

public class CapeMario implements IMarioState {
    private static final CapeMario instance = new CapeMario();
    
    private CapeMario() {
    }
    
    public static CapeMario getInstance() {
        return instance;
    }
    
    @Override
    public StateEnum getName() {
        return StateEnum.CAPE;
    }
    
    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }
    
    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        // do nothing
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
