package design.statemachine.state;

import design.statemachine.IMarioState;
import design.statemachine.MarioStateMachine;
import design.statemachine.StateEnum;

public class SmallMario implements IMarioState {
    private static final SmallMario instance = new SmallMario();
    
    private SmallMario() {
    }
    
    public static SmallMario getInstance() {
        return instance;
    }
    
    @Override
    public StateEnum getName() {
        return StateEnum.SMALL;
    }
    
    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
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
        // do nothing...
    }
}
