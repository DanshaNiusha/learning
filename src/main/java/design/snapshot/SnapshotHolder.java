package design.snapshot;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SnapshotHolder {
    // private Stack<Snapshot> snapshots = new Stack<>();
    private LinkedList<Snapshot> snapshots = new LinkedList<>();
    
    public Snapshot popSnapshot() {
        return snapshots.removeLast();
    }
    
    public void pushSnapshot(Snapshot snapshot) {
        snapshots.addLast(snapshot);
    }
}