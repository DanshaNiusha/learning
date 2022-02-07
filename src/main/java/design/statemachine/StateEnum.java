package design.statemachine;

public enum StateEnum {
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);
    
    private int value;
    
    private StateEnum(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
}