package design.statemachine.state;

import design.statemachine.IMarioState;
import design.statemachine.MarioStateMachine;
import design.statemachine.StateEnum;

public class FireMario implements IMarioState {
    private static final FireMario instance = new FireMario();
    
    private FireMario() {
    }
    
    public static FireMario getInstance() {
        return instance;
    }
    
    @Override
    public StateEnum getName() {
        return StateEnum.FIRE;
    }
    
    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }
    
    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }
    
    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        // do nothing
    }
    
    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 300);
    }
}
