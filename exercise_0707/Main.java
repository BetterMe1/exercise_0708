package exercise.exercise_0707;

/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] nums = new int[n+1];
        for(int i=1; i<=n; i++){
            nums[i] = in.nextInt();
        }
        long[][]dp = new long[n+1][sum+1];//表示前i个数可以凑到j的方法数
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int j=1; j<=sum; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(nums[i] > j){//选择不拿
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                }
            }
        }
        System.out.println(dp[n][sum]);
    }
}
*/
/*
年会抽奖
 */
/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            double result = (literal(n)/count(n))*100 ;
            System.out.println(String.format("%.2f",result)+"%");
        }
    }
    *//*
    计算一共有多少种抽法
     *//*
    public static double count(int n) {
        double result = 1;
        while(n > 0){
            result *= n;
            n--;
        }
        return result;
    }
    *//*
    计算每个人都不抽到自己的抽法有多少种
     *//*
    public static double literal(int n) {
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        return (n-1)*(literal(n-1)+literal(n-2));
    }
}
*/

/*
奇偶校验
 */
/*
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.next();
            for(int i=0,len=str.length(); i<len; i++){
                char a = str.charAt(i);
                System.out.println(solution(a));
            }
        }
    }
    public static String solution(char a) {
        String str = new BigInteger(String.valueOf((int)a),10).toString(2);
        int count = 0;
        int len=str.length();
        for(int i=0; i<len; i++){
            if(str.charAt(i) == '1'){
                count++;
            }
        }
        while(len != 7){
            str = "0"+str;
            len++;
        }
        if(count%2 == 0){
            str = "1"+str;
        }else{
            str = "0"+str;
        }
        return str;
    }
}
*/

/*
大整数排序
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[n];
        strs[0] = in.next();
        int size = 1;
        for(int i=1; i<n; i++){
            String str = in.next();
            int len = str.length();
            int j=0;
            while(strs[j]!= null){
                if(strs[j].length()<len){
                    j++;
                }else if(strs[j].length()>len){
                    System.arraycopy(strs,j,strs,j+1,size-j);
                    strs[j] = str;
                    break;
                }else{
                    boolean flag = false;
                    for(int m=0; m<len; m++){
                        if(strs[j].charAt(m) < str.charAt(m)){
                            j++;
                            break;
                        }else if(strs[j].charAt(m) > str.charAt(m)){
                            flag = true;
                            System.arraycopy(strs,j,strs,j+1,size-j);
                            strs[j] = str;
                            break;
                        }
                    }
                    if(flag){
                        break;
                    }
                }
            }
            if(strs[j]== null){
                strs[j] = str;
            }
            size++;
        }
        for(int i=0; i<n; i++){
            System.out.println(strs[i]);
        }
    }
}