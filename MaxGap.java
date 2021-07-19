package SummerMath;

public class MaxGap {
    public static void main(String[] args) {
        int[] arr = {1,3,7,12,0,};
        System.out.println(maxGap(arr));
    }
    /**
     * 给定一个数组，排序之后相邻两个数的最大差值，
     * 要求时间复杂度O(N),而且要求不能用非基于比较的排序
     */
    /**
     * 思路：1 找出数组的最大值跟最小值
     * 2 建立三个数组 bool max min 当桶用
     * 3 把数组的最大值最小值放到桶的第一个和最后一个桶
     * 4 遍历数组，并把相应的数放到桶中
     */
    public static int maxGap(int[] arr){
        if(arr == null && arr.length == 1)
            return 0;
        int max = Integer.MIN_VALUE; //最大值给最小数
        int min = Integer.MAX_VALUE;  //一般给0但是有时候会是负数

        //遍历数组得到数组的最大值和最小值
        for(int i=0; i<arr.length;i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        if(max == min){
            return 0;
        }
        //建立三个数组当桶用，为什么这里时LENGTH+1
        // 因为这样它们当中必会有一个空桶，好算差值
        boolean[] isNum = new boolean[arr.length + 1]; //记录当前桶是否有数值
        int[] maxNum = new int[arr.length+1];   //记录应放在这个桶里得得最大值
        int[] minNum = new int[arr.length+1];  //记录应放在这个桶里得得最小值
        int bid = 0; //判断这个数应该放在那个位置
        //桶建立好了？怎么放数？
        for(int i=0; i < arr.length;i++){
            bid = bucket(arr[i],arr.length,min,max);
            /*((num - min) * len / (max - min))
            ((1-0)*5/(12-0)  2
            ((7-0)*5/12      2
            (12-0)*5/12      4
            判断每个数应该放在那个桶里面，并且判断当前桶里面的最大值最小值跟它比较
             */
            maxNum[bid] = isNum[i] ? Math.max(maxNum[bid],arr[i]) : arr[i];
            minNum[bid] = isNum[i] ? Math.min(minNum[bid],arr[i]) : arr[i];
            isNum[bid] = true;
        }
        //循环取出最大数
        int res = 0;
        int preMax = maxNum[0];
       // int last_i = 0;
        for(int i = 1;i<isNum.length;i++){
//            if(!isNum[i]){
//                i++;
//                continue;
//            }
//            int maxValue = maxNum[last_i];
//            int minValue = minNum[i];
//            last_i++;
//            res = res > (maxValue - minValue) ? res : maxValue - minValue);

            if(isNum[i]){
                res = Math.max(res,minNum[i] - preMax);
                preMax = maxNum[i];
            }
        }
        return res;
    }

    public static int bucket(long num,long len,long min,long max){
        return (int)((num - min) * len / (max - min));  //非常巧妙 为什么？
    }


}
