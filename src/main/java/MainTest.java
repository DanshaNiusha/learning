import lombok.extern.slf4j.Slf4j;
import model.Model3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxiaokang
 * @date 2021/7/6
 */
@Slf4j
public class MainTest {
    private static final ExecutorService executor = new ThreadPoolExecutor(1, 1
            , 1, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());
    
    private static String NAME = "lisi";
    
    public static void main(String[] args) throws Exception {
        String s ="eyJpZCI6NTAyODc3MzEzMTk4LCJwdXNoRGF0ZSI6IlNlcCAyNiwgMjAyMyAxMjowMDowMCBBTSIsInBhcmVudFRhc2tUeXBlIjoiSU5WQUxJRCIsImFjdGlvblR5cGUiOiJDSEFOR0UiLCJzY2hlZHVsZU5vIjoiMjAyMzA5MjYwMjAwIiwidHlwZSI6IklGQVJFIiwibWQ1IjoiYzY1MDk3ZGI3MzI0MjdiOGQyZTEzNzBkNGU2MmNjMTIiLCJtZXNzYWdlQ29udGVudERPIjp7ImNyZWF0ZUlkIjoyMDIzMDkyNTIyMDAsInRhcmlmZiI6Ijg4NCIsImNhcnJpZXIiOiJDWiIsIm9yaWciOiJETEMiLCJkZXN0IjoiQ0pVIiwiZmNsIjoiUjJBTlNVUUsiLCJnbG9iYWxkaXIiOiJFSCIsImRpc2RhdGUiOiIyOTk5LTAxLTAxIiwicnVsZSI6IlJJU04iLCJmdG50IjoiN1AiLCJsaW5rIjoiMDAyIiwic2VxIjoiMDAwMDEiLCJuZWVkUmVSdW4iOmZhbHNlLCJvYmpJZCI6MjIxNDYxNTgxMzUsImNyZWF0ZVNvdXJjZSI6IkNPTVBBUkVfUkVDMiJ9LCJtZXNzYWdlQ29udGVudCI6IntcImNyZWF0ZUlkXCI6MjAyMzA5MjUyMjAwLFwidGFyaWZmXCI6XCI4ODRcIixcImNhcnJpZXJcIjpcIkNaXCIsXCJvcmlnXCI6XCJETENcIixcImRlc3RcIjpcIkNKVVwiLFwiZmNsXCI6XCJSMkFOU1VRS1wiLFwiZ2xvYmFsZGlyXCI6XCJFSFwiLFwiZGlzZGF0ZVwiOlwiMjk5OS0wMS0wMVwiLFwicnVsZVwiOlwiUklTTlwiLFwiZnRudFwiOlwiN1BcIixcImxpbmtcIjpcIjAwMlwiLFwic2VxXCI6XCIwMDAwMVwiLFwibmVlZFJlUnVuXCI6ZmFsc2UsXCJvYmpJZFwiOjIyMTQ2MTU4MTM1LFwiY3JlYXRlU291cmNlXCI6XCJDT01QQVJFX1JFQzJcIn0iLCJyZXRyeUNvdW50IjowLCJsZXZlbCI6MSwic3RhdHVzIjoiQ0FORElTVFJJQlVURSIsImV4dHJhIjoie1wiaXNUYXhBcHBsXCI6ZmFsc2V9Iiwib3JpZyI6IkRMQyIsImRlc3QiOiJDSlUiLCJhaXJsaW5lIjoiQ1oiLCJ0YXJpZmYiOiI4ODQiLCJwYXJhbXNTdGF0SWQiOjMxNjIwMjU1NjM0OTExOSwidHlwZUlkeEtleSI6IjUyYzk1YWVjMGQ4ZjY4MGIyOTY5MDM4MGIxZmFhNGJjIiwic2Vxbm8iOiIwMDAwMSIsInRhc2tGbGFnIjoxMDAwMDAwMDAwLCJnbXRDcmVhdGUiOiJTZXAgMjYsIDIwMjMgMjoxNjoyOCBQTSIsImdtdE1vZGlmaWVkIjoiU2VwIDI2LCAyMDIzIDI6MTY6MjggUE0iLCJkdXBVcGRhdGVGbGFnIjowfQ";
        // for (int i = 0; ; i++) {
        //     try {
        //         method1("张三" + i);
        //         TimeUnit.SECONDS.sleep(5);
        //     } catch (Exception e) {
        //         log.error("sdsad", e);
        //     }
        //
        // }
    }
    
    private static Model3 method1(String username) {
        method2();
        return Model3.builder().name(username).build();
    }
    
    private static void method2() {
        System.out.println("exec m2");
    }
}

