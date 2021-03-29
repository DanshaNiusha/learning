package algorithms.string;

/**
 * 字符串型的数字转int
 * @author liuxiaokang
 * @date 2021/3/12
 */
public class StrToInt {
    public static void main(String[] args) {
        String str ="1234";
        System.out.println(toInt(str));
    }
    
    
    public static int toInt(String str) {
        int result = 0;
        for(int i = 0 ; i < str.length() ; i++){
            // char字符变量是可以进行加减运算的，在运算的时候，我们通过查找对应字符变量值的ASCII值，利用其在ASCII里的对应值进行加减运算。
            // 减'0'就能得到对应的数字了
            int k = str.charAt(i) - '0';
            result = result * 10 + k;
        }
        return result;
    }
}
