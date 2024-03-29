package design.commond;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 命令模式 : 将请求收口,封装为各种命令放入队列排队,不断拉取执行命令, 命令中有执行命令的方法,类似策略模式
 */
public class GameApplication {
    private static final int MAX_HANDLED_REQ_COUNT_PER_LOOP = 100;
    private Queue queue = new LinkedList<>();
    
    public void mainloop() {
        // while (true) {
        //   List requests = new ArrayList<>();
        
        //省略从epoll或者select中获取数据，并封装成Request的逻辑，
        //注意设置超时时间，如果很长时间没有接收到请求，就继续下面的逻辑处理。
        //
        //   for (Request request : requests) {
        //     Event event = request.getEvent();
        //     Command command = null;
        //     if (event.equals(Event.GOT_DIAMOND)) {
        //       command = new GotDiamondCommand(/*数据*/);
        //     } else if (event.equals(Event.GOT_STAR)) {
        //       command = new GotStartCommand(/*数据*/);
        //     } else if (event.equals(Event.HIT_OBSTACLE)) {
        //       command = new HitObstacleCommand(/*数据*/);
        //     } else if (event.equals(Event.ARCHIVE)) {
        //       command = new ArchiveCommand(/*数据*/);
        //     } // ...一堆else if...
        //
        //     queue.add(command);
        //   }
        //
        //   int handledCount = 0;
        //   while (handledCount < MAX_HANDLED_REQ_COUNT_PER_LOOP) {
        //     if (queue.isEmpty()) {
        //       break;
        //     }
        //     Command command = queue.poll();
        //     command.execute();
        //   }
        // }
    }
}