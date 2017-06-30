package chapter1;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;
import Answer.BaseChapter;
import framework.Title;
import util.ChapterUtil;

import java.math.BigInteger;
import java.util.Arrays;

public class Chapter1_1Creative extends BaseChapter{
	
	@Title("1.1.26")
	public static void question26(){
		println("int a = 4,b = 2,c = 6,t;");
		println("if(a > b){t = a;a = b;b = t;}  //此次步骤结束后,a必然小于等于b");
		println("if(a > c){t = a;a = c;c = t;}  //结束后，a小于等于c。此时可以确定a为最小（小于b且小于c）");
		println("if(b > c){t = b;b = c;c = t;}  //b小于等于c，排序结束");
	}

	@Title("1.1.27")
	public static void question27(){
		int N = 100,k = 50;
		double p = 0.25;
//		println(binomial(N,k,p));  //未优化版本时间执行时间灰常的长，所以这里只能将其注释
		println(binomialFaster(N,k,p));
		print("估计调用次数：");ChapterUtil.questionNo();
	}

	@Title("1.1.28")
	public static void question28(){
        int a[] = {85,54,6,5,8,52,6,8,6,65,6,85,3};  //白名单
        int count = a.length;
        Arrays.sort(a);  //进行排序
        for(int i = 0;i<count - 1;i++){  //遍历整个数组
            while(i < count){
                if(a[i] == a[i + 1]){  //判断当前元素与下一个元素是否一致。这个过程需要不停重复，直到不一致
                    for(int j = i;j<count - 1;j++){
                        a[j] = a[j + 1];  //一致，则移动数组后面的元素，覆盖掉重复元素
                    }
                    a[--count] = 0;  //置为0，表示数组元素为空。
                }else {  //不一致了，退出while循环
                    break;
                }
            }
        }
        println(Arrays.toString(a));
    }

    @Title("1.1.29")
    public static void question29(){
        int num[] = {1,1,1,1,2,2,2,3,3,3,5,6,7,7,7,7,8,8,8};
        int key = 9;
        int rank = rank(key, num);
        print("小于"+key+"的元素个数：");println(rank < 0 ? ~rank:rank);  //如果查不到，则rank为负数，需要取反
        print("等于"+key+"的元素个数：");println(count(key,num));
	}
    private static int rank(int key,int[] a){
        return rank(key,a,0,a.length - 1);
    }

    /**
     * 题目1.1.29要求的改进版的二分法查找
     * 题目中要求找到小于key的所有元素，也可理解成找到第一个等于key的元素索引，
     * 或如果找不到，返回key应该存在的位置的索引
     * */
    private static int rank(int key,int[] a,int lo,int hi){
        if(lo > hi) return ~lo;  //不返回-1，而是返回lo，这时lo指向的即是假设key存在时的索引。取反的目的，是为了标识是否找到了该元素
        int mid = lo + (hi - lo) / 2;
        if(key < a[mid]) return rank(key,a,lo,mid - 1);
        else if(key > a[mid]) return rank(key,a,mid + 1,hi);
        //这个分支表示，如果找到了key，但是左边的元素仍然等于key，那么找到的这个元素不是目标元素，需要继续查找
        else if(mid - 1 >= 0 && a[mid - 1] == key){
            return rank(key,a,lo,mid - 1);
        }else{
            return mid;
        }
    }

    @Title("1.1.30")
    public static void question30(String str){
        int N = 10;
        if(str != null){
            N = Integer.parseInt(str);
        }
        boolean[][] a = new boolean[N][N];
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                a[i][j] = (gcd(i,j) == 1);
            }
        }

        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                printf("%6s",a[i][j] ? "true":"false");
            }
            println();
        }
    }

    @Title("1.1.31")
    public static void question31(){
        ChapterUtil.questionNo();
    }

    @Title("1.1.32")
    public static void question32(){
        ChapterUtil.questionNo();
    }

    @Title("1.1.33")
    public static void question33(){
        {
            println("测试向量点乘");
            double[] a = {1,2,3,4,5};
            double[] b = {6,7,8,9,0};

            println("a = "+Arrays.toString(a));
            println("b = "+Arrays.toString(b));

            println("a 与 b点乘："+Matrix.dot(a,b));
        }
        println("------------------------------------------------");
        {
            println("测试矩阵积");
            double[][] a = {{1,2,3},{4,5,6}};
            double[][] b = {{1,4},{2,5},{3,6}};

            double[][] result = Matrix.mult(a,b);

            println("矩阵1：");
            ChapterUtil.printArray(a);
            println("矩阵2：");
            ChapterUtil.printArray(b);

            println("乘积：");
            ChapterUtil.printArray(result);
        }

        println("---------------------------------------------------");
        {
            println("测试矩阵转置");
            double[][] a = {{1,2,3},{4,5,6}};
            println("转置前");
            ChapterUtil.printArray(a);
            println("转置后");
            ChapterUtil.printArray(Matrix.transpose(a));
        }

        println("---------------------------------------------------");
        {
            println("测试矩阵乘以向量");
            double[][]a = { {0,0,0.2,0.3,0.5},
                            {0.1,0.4,0.4,0.1,0},
                            {0,0,0,0.5,0.5},
                            {0.4,0.3,0.3,0,0}};
            double[] b = {0.15,0.1,0.15,0.05,0.1};
            double[] result = Matrix.mult(a,b);
            println("矩阵:");
            ChapterUtil.printArray(a);
            println("向量：");
            ChapterUtil.printArray(b);
            println("矩阵与向量的乘积：");
            ChapterUtil.printArray(result);
        }
        println("---------------------------------------------------");
        {
            println("测试向量乘以矩阵");
            double[] a = {0.15,0.10,0.15,0.05};
            double[][] b = {{0,0,0.2,0.3,0.5},
                            {0.1,0.4,0.4,0.1,0},
                            {0,0,0,0.5,0.5},
                            {0.4,0.3,0.3,0,0}};
            double[] result = Matrix.mult(a,b);
            println("向量");
            ChapterUtil.printArray(a);
            println("矩阵：");
            ChapterUtil.printArray(b);
            println("向量与矩阵的乘积");
            ChapterUtil.printArray(result);
        }
    }

    /**1.1.30使用的辗转相除法算最大公约数*/
    private static int gcd(int p,int q){
        if(q == 0){
            return p;
        }
        return gcd(q,p % q);
    }

    /**1.1.29中要求的count方法*/
    private static int count(int key,int[] nums){
        //目前想到两种方案。
        // 1.通过rank方法找到最左边的key，然后往后遍历计数
        // 2.增加另一個rank方法，使其能找到最右边的key，然后两者运算。
        // 选择哪种方案，得看key的具体个数的多少，本例采用方案1。
        int count = 0;
        int rank = rank(key,nums);
        if(rank >= 0){
            for(int i = rank;i<nums.length;i++){
                if(nums[i] != key){
                    break;
                }
                count++;
            }
        }
        return count;
    }

	/**1.1.27中提供的二项分布方法*/
	private static double binomial(int N,int k,double p){
		if(N == 0 && k == 0) return 1.0;
		if(N < 0 || k < 0) return 0.0;
		return (1.0 - p) * binomial(N - 1,k,p) + p * binomial(N - 1,k - 1,p);
	}

	/**在binomialFaster方法中使用的缓存数据*/
	private static double[][] binomialFasterCache = new double[150][150];
	static{
		for(int i = 0;i<150;i++){
			for(int j = 0;j<150;j++){
				binomialFasterCache[i][j] = Double.MIN_VALUE;
			}
		}
	}
	/**1.1.27题目中要求的更好的实现*/
	private static double binomialFaster(int N,int k,double p){
		if(N == 0 && k == 0) return 1.0;
		if(N < 0 || k < 0) return 0.0;
		if(binomialFasterCache[N][k] == Double.MIN_VALUE){
			binomialFasterCache[N][k] =  (1.0 - p) * binomialFaster(N - 1,k,p) + p * binomialFaster(N - 1,k - 1,p);
		}
		return binomialFasterCache[N][k];
	}
}

/**题目1.1.33要求的矩阵库*/
class Matrix{
    /**向量点乘*/
    static double dot(double[] x,double[] y){
        if(x == null || y == null ||x.length != y.length){
            throw new RuntimeException("参数不合法");
        }
        int count = 0;
        for(int i = 0;i<x.length;i++){
            count += x[i] * y[i];
        }
        return count;
    }

    /**矩阵乘法*/
    static double[][] mult(double[][] a,double[][] b){
        if(a == null || b == null ||b[0] == null || a[0] == null || a[0].length != b.length){
            throw new RuntimeException("参数不合法");
        }
        double[][] result = new double[a.length][b[0].length];
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<result[0].length;j++){
                result[i][j] = 0;
                for(int k = 0;k < b.length;k++){
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    /**矩阵转置*/
    static double[][] transpose(double[][] a){
        if(a == null){
            throw new RuntimeException("参数不合法");
        }
        double[][] result = new double[a[0].length][a.length];
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<result[0].length;j++){
                result[i][j] = a[j][i];
            }
        }
        return result;
    }

    /**矩阵乘以向量*/
    static double[] mult(double[][] a,double[] x){
        if(a == null || x == null || a[0].length != x.length){
            throw new RuntimeException("参数不合法");
        }
        double[] result = new double[a.length];
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<x.length;j++){
                result[i] += a[i][j] * x[j];
            }
        }
        return result;
    }

    /**向量乘以矩阵*/
    static double[] mult(double[] y,double[][] a){
        if(a == null || y == null || a.length != y.length){
            throw new RuntimeException("参数不合法");
        }
        double[] result = new double[a[0].length];
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<a.length;j++){
                result[i] += a[j][i] * y[j];
            }
        }
        return result;
    }
}