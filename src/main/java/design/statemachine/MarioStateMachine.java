package design.statemachine;

import design.statemachine.state.SmallMario;

public class MarioStateMachine {
    private int score;
    private IMarioState currentState;
    
    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }
    
    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }
    
    public void obtainCape() {
        this.currentState.obtainCape(this);
    }
    
    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }
    
    public void meetMonster() {
        this.currentState.meetMonster(this);
    }
    
    public int getScore() {
        return this.score;
    }
    
    public StateEnum getCurrentState() {
        return this.currentState.getName();
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public void setCurrentState(IMarioState currentState) {
        this.currentState = currentState;
    }
}