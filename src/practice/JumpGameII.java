package practice;

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/jump-game-ii/
 * Progress: Done
 */

public class JumpGameII {
    public static void main(String[] args) {
        int answer = jump(new int[]{1, 3, 4});
        System.out.println(answer + " " + (answer == 2));
        answer = jump(new int[]{1, 2, 3, 4, 5});
        System.out.println(answer + " " + (answer == 3));
        answer = jump(new int[]{2, 1});
        System.out.println(answer + " " + (answer == 1));
        answer = jump(new int[]{2, 1, 1});
        System.out.println(answer + " " + (answer == 1));
        answer = jump(new int[]{2, 1, 1, 1});
        System.out.println(answer + " " + (answer == 2));
        answer = jump(new int[]{2, 3, 1, 1, 1});
        System.out.println(answer + " " + (answer == 2));
        answer = jump(new int[]{4, 1, 1, 3, 1, 1, 1});
        System.out.println(answer + " " + (answer == 2));
        answer = jump(new int[]{3, 2, 1});
        System.out.println(answer + " " + (answer == 1));
        answer = jump(new int[]{5, 3, 1, 1, 1, 2, 1});
        System.out.println(answer + " " + (answer == 2));
        answer = jump(new int[]{2, 3, 1});
        System.out.println(answer + " " + (answer == 1));
        answer = jump(new int[]{7, 1, 4, 1, 1, 1, 1, 2, 1});
        System.out.println(answer + " " + (answer == 2));
        answer = jump(new int[]{3, 3, 2, 5, 4, 3, 9, 5, 5, 7, 9, 4, 9, 1, 0, 3, 6, 8, 2});
        System.out.println(answer + " " + (answer == 4));
    }

    public static int jump(int[] nums) {
        int index = 0, noOfJumps = 0;
        int length = nums.length - 1;

        if (length < 1)
            return 0;

        while (index < length) {
            index += optimalJump(nums, index);
            noOfJumps++;
        }
        return noOfJumps;
    }

    public static int optimalJump(int[] nums, int index) {
        int max = 0, indexOfMax = 0;
        for (int i = 1; i <= nums[index]; i++) {
            if (index + i >= nums.length - 1) {
                indexOfMax = i;
                break;
            }
            if (nums[index + i] + i >= indexOfMax + max) {
                max = nums[index + i];
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }
}
