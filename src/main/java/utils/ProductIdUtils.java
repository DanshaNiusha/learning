package utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author liuxiaokang
 * @date 2021/10/29
 */
public class ProductIdUtils {
    
    /**
     * productId 下边界
     */
    private static final long PRODUCT_ID_LOWER_BOUND = 100000000L;
    
    /**
     * id 转换基数
     */
    private static final long PRODUCT_ID_BASE = 200000000L;
    
    /**
     * productId 上边界
     */
    private static final long PRODUCT_ID_UPPER_BOUND = 300000000L;
    
    
    public static void main(String[] args) throws Exception {
        InputStream stream = new FileInputStream("/Users/liuxiaokang03/Desktop/在线.txt");
        String txt = IOUtils.toString(stream, StandardCharsets.UTF_8);
        // 转productid
        Set<Long> ret = Arrays.stream(txt.split(",")).map(Long::valueOf).map(ProductIdUtils::getProductIdResultFromGoodsId).collect(Collectors.toSet());
        // 转goodsid
        // Set<Long> ret = Arrays.stream(txt.split(",")).map(Long::valueOf).map(ProductIdUtils::getGoodsIdFromProductId).collect(Collectors.toSet());
        
        System.out.println(ret.toString().trim().replaceAll(", ", ",").replaceAll("\\[","").replaceAll("]",""));
    }
    
    
    public static Long getProductIdResultFromGoodsId(Long goodsId) {
        if (goodsId < PRODUCT_ID_LOWER_BOUND) {
            return goodsId + PRODUCT_ID_BASE;
        } else {
            return goodsId;
        }
    }
    
    public static Long getGoodsIdFromProductId(Long productId) {
        if (productId > PRODUCT_ID_BASE && productId < PRODUCT_ID_UPPER_BOUND) {
            return productId - PRODUCT_ID_BASE;
        } else {
            return productId;
        }
    }
}
