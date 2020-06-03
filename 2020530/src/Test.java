/**
 * @program: 2020530
 * @description
 * @author: mrs.yang
 * @create: 2020 -06 -01 21 :59
 */

public class Test {
    public static int func(int n){
        int sum=0;
        while(n>=2){
            int x=n/3;
            int y=n%3;
            if(x+y==2){
                n++;
            }else{
                sum=sum+x;
                n=x+y;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
       int ret=func(10);
        System.out.println(ret);
    }
}
