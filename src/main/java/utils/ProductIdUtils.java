package utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        // InputStream stream = new FileInputStream("/Users/liuxiaokang03/Desktop/products.txt");
        InputStream streamall = new FileInputStream("/Users/liuxiaokang03/Desktop/all.txt");
        InputStream streamyf = new FileInputStream("/Users/liuxiaokang03/Desktop/yf.txt");
        String txtall = IOUtils.toString(streamall, StandardCharsets.UTF_8);
        String txtyf = IOUtils.toString(streamyf, StandardCharsets.UTF_8);
        // String replace = StringUtils.replace(txt, "\n", ",");
        // Pattern pattern = Pattern.compile("\\[(.*?)]");
        // Matcher matcher = pattern.matcher(txt);
        // Set<Long> set = Sets.newHashSet();
        // while (matcher.find()) {
        //     String[] split = matcher.group(1).trim().split(",");
        //     for (String s : split) {
        //         set.add(Long.parseLong(s.trim()));
        //     }
        //
        // }
        // 转productid
        Set<Long> allset = Arrays.stream(txtall.split(",")).map(Long::valueOf).map(ProductIdUtils::getProductIdResultFromGoodsId).collect(Collectors.toSet());
        Set<Long> yfset = Arrays.stream(txtyf.split(",")).map(Long::valueOf).map(ProductIdUtils::getProductIdResultFromGoodsId).collect(Collectors.toSet());
    
        yfset.removeAll(allset);
        System.out.println(JSON.toJSONString(yfset));
        
        // // 转goodsid
        // // List<Long> ret = Arrays.stream(replace.split(",")).map(Long::valueOf).map(ProductIdUtils::getGoodsIdFromProductId).collect(Collectors.toList());
        // String result = ret.toString().trim().replaceAll(", ", ",").replaceAll("\\[", "").replaceAll("]", "");
        // System.out.println(result);
        //
        // FileWriter fileWriter = new FileWriter("/Users/liuxiaokang03/Desktop/productIds11.txt");
        // IOUtils.write(JSON.toJSONString(ret), fileWriter);
        
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
