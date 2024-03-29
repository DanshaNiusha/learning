package demo;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class SocketTextStreamWordCount {
    
    
    public static void main(String[] args) throws Exception {
        //参数检查
        if (args.length != 2) {
            System.err.println("USAGE:\nSocketTextStreamWordCount <hostname> <port>");
            return;
        }
        
        String hostName = args[0];
        Integer port = Integer.parseInt(args[1]);
        
        //设置环境
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        
        //获取数据
        DataStream<String> text = env.socketTextStream(hostName, port);
        
        //计数
        DataStream<Tuple2<String, Integer>> counts = text.flatMap(new LineSplitter())
                .keyBy(0)
                .sum(1);
        counts.print();
        
        env.execute("Java WordCount from SocketTextStream Example");
        
    }
    
    
    public static final class LineSplitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) {
            String[] tokens = s.toLowerCase().split("\\W+");
            
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    collector.collect(new Tuple2<>(token, 1));
                }
            }
        }
    }
}

// flink run -c demo.SocketTextStreamWordCount /Users/dansha/IdeaProjects/learning/flink/target/flink-1.0-SNAPSHOT.jar 127.0.0.1 9000