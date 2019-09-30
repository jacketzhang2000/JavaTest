package Test0915;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class p1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        int length=nums.length;
        for(int i=0;i<length-2;i++){
            if(i==0||(i>0&&nums[i]!=nums[i-1])) {
                for (int j = i + 1; j < length - 1; j++) {
                    for (int k = j + 1; k < length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> l1 = new ArrayList<>();
                            l1.add(nums[i]);
                            l1.add(nums[j]);
                            l1.add(nums[k]);
                            list.add(l1);
                        }
                    }
                }
            }
        }
        return list;
    }
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int half=nums.length;
        for(int i=0;i<=half;i++){
            if(i==0||(i>0&&nums[i]!=nums[i+1])) {
                for (int j = i + 1; j <= half + 1; j++) {
                    for (int k = nums.length - 1; k > j; k--) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> l1 = new ArrayList<>();
                            l1.add(nums[i]);
                            l1.add(nums[j]);
                            l1.add(nums[k]);
                            list.add(l1);
                        }
                    }
                }
            }
        }
        return list;
    }
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            List<Integer> l1 = new ArrayList<>();
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int j = i + 1;
                int k = length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));

                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        j++;
                    } else {
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        k--;
                    }
                }
            }
        }
        return list;
    }
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                while (j < k && nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
                if (j >= k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> l1 = new ArrayList<>();
                    l1.add(nums[i]);
                    l1.add(nums[j]);
                    l1.add(nums[k]);
                    list.add(l1);
                    j++;
                }
                while (j < k && nums[j] == nums[j + 1]) {
                    j++;
                }
                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (j >= k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> l1 = new ArrayList<>();
                    l1.add(nums[i]);
                    l1.add(nums[j]);
                    l1.add(nums[k]);
                    list.add(l1);
                    k--;
                }
                while (j < k && nums[k] == nums[k - 1]) {
                    k--;
                }
            }
            while(i<length-2&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return list;
    }
    public List<List<Integer>> threeSum4(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s < 0) {

                    j++;
                } else if (s > 0) {

                    k--;
                } else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                }
            }
            while (i < length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        p1 p=new p1();
        List<List<Integer>> l=p.threeSum4 (nums);
        System.out.println(l);
    }
}
