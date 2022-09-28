import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.HexUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.hash.HashCode;
import model.Model1;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.time.StopWatch;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import sun.security.provider.Sun;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author liuxiaokang
 * @date 2021/7/6
 */
public class MainTest {
    private static final ExecutorService executor = new ThreadPoolExecutor(1, 1
            , 1, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
    
    public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException {
        // for (int i = 0; i < 10; i++) {
        //     executor.execute(() -> {
        //         int n = 1 / 0;
        //     });
        //
        // }
        int i = 123;
        Long l = 123L;
        System.out.println(Objects.equals(i,l));
        
        
    }
    
    private static class ContainerMonitor extends TimerTask {
        @Override
        public void run() {
            Map<String, String> tags = Maps.newHashMapWithExpectedSize(2);
            System.out.println(111);
        }
    }
    
    
}

