package utils;

import com.alibaba.fastjson.JSON;
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
        InputStream stream = new FileInputStream("/Users/liuxiaokang03/Desktop/goods2.txt");
        String txt = IOUtils.toString(stream, StandardCharsets.UTF_8);
        String replace = StringUtils.replace(txt, "\n", ",");
    
        // 转productid
        // Set<Long> ret = Arrays.stream(txt.split(",")).map(Long::valueOf).map(ProductIdUtils::getProductIdResultFromGoodsId).collect(Collectors.toSet());
        // String s = "665948730,721940490,721917453,721884412,720403189,721872629,718738633,718842225,718767068,718754922,719688388,66584743,608257033,0,721663794,4909393,4083960,0,634888052,634889070,667338715,4125478,641841312,737206566,667417982,731227946,731137421,731228440,731142078,731233258,731128894,731221614,692637567,692626299,694410450,692635958,625142865,604918834,604916869,692634023,623234183,622456414,604935083,68903943,709550827,678470379,678456166,67409485,714618923,630245426,660935997,64842817,671938615,709858015,732032428,737887733,673471966,63251591,607739246,607738895,33228117,736262829,736266185,18801345,600119198,600104638,600113238,600119197,12660789,14092402,13309634,725434739,614613410,69173533,613594465,651696342,658508229,737515058,4075442,4075443,4075440,4075439,710076200,737671327,641357073,652053323,707870930,707788514,726136110,726123923,726133291,627639768,691079466,691080578,691069187,691068218";
        // List<Long> ret = Arrays.stream(txt.split(",")).map(Long::valueOf).map(ProductIdUtils::getProductIdResultFromGoodsId).collect(Collectors.toList());
        // Set<Long> ret = Arrays.stream(s.split(",")).map(Long::valueOf).map(ProductIdUtils::getProductIdResultFromGoodsId).collect(Collectors.toSet());
        // 转goodsid
        List<Long> ret = Arrays.stream(replace.split(",")).map(Long::valueOf).map(ProductIdUtils::getGoodsIdFromProductId).collect(Collectors.toList());
        // String result = ret.toString().trim().replaceAll(", ", ",").replaceAll("\\[", "").replaceAll("]", "");
        // System.out.println(result);
    
        System.out.println(ret.size());
        // FileWriter fileWriter = new FileWriter("/Users/liuxiaokang03/Desktop/goods2.txt");
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
