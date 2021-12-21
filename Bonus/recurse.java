import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.concurrent.*;

public class recurse extends RecursiveTask<Integer> {
    int n; int k;
    public recurse(int _n, int _k){
        n = _n;
        k = _k;
    }
    public int sequential_pascal(int n_, int k_){
        if(n_==0 || k_==0 || n_==k_){
            return 1;
        }
        else{
            return sequential_pascal(n_-1, k_-1) + sequential_pascal(n_-1, k_);
        }
    }
    public Integer compute(){
        if(n==0 || k==0 || n==k){
            return 1;
        }
        if(n < 17 && k < 7){
            return sequential_pascal(n, k)+1;
        }
        else{
            recurse left = new recurse(this.n-1, this.k-1);
            recurse right = new recurse(this.n-1, this.k);
            left.fork();
            return right.compute() + left.join();
        }
    }

    public static void main(String args[]) throws InterruptedException{
        int n = 3, k = 2;
        int threads = Integer.parseInt(args[0]);
        ForkJoinPool pool = new ForkJoinPool(2);
        recurse task = new recurse(n, k);
        int result = pool.invoke(task);
        System.out.println(result);
    }
}