import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class nBinary {
    static int N = 26;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> res = transform(n);
        for (int i = res.size() - 1; i >= 0; i--) {
            if (res.get(i) == 0 && i - 1 >= 0) {
                res.set(i, 26);
                res.set(i - 1, res.get(i - 1) - 1);
            }
        }
        for (Integer re : res) {
            if (re == 0) continue;
            System.out.print((char) (re + 'A' - 1));
        }

        int[][] a = new int[10][2];
        System.out.println(a.length);
    }

    public static List transform(double n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int t = N;
        // 找出N最接近且小于n的次幂
        while (t < n) {
            if (t * N > t && t * N < n) {
                t *= N;
            } else {
                break;
            }
        }
        while (n > 0) {
            while (t > n) {
                arr.add(0);
                t /= N;
            }
            int temp = (int) (n / t);
            n %= t;
            t /= N;
            arr.add(temp);
        }
        // 高位的和已经等于最终结果了 低位需要补上0
        while (t > n) {
            arr.add(0);
            t /= N;
        }
        return arr;
    }
}
