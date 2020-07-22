package main;

public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        int len = s.length;

        reverse(s, 0, len - 1);

        int curr = 0;
        while (curr < len) {
            int end = curr;
            while (end < len && s[end] != ' ') end++;
            reverse(s, curr, end - 1);
            curr = end + 1;
        }
    }

    private void reverse(char[] nums, int low, int high) {
        while(low < high) {
            swap(nums, low++, high--);
        }
    }

    private void swap(char[] nums, int a, int b) {
        char temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        ReverseWordsInAStringII test = new ReverseWordsInAStringII();

        char[] s = new char[] {'1','2','3',' ','4','5','6','7'};
        int k = 3, len = s.length;

        test.reverseWords(s);

        for (int i = 0; i < len; i++) {
            System.out.print(s[i] + " ");
        }
    }
}
