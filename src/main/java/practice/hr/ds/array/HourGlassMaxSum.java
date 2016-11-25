package practice.hr.ds.array;

public class HourGlassMaxSum {

    public static void main(final String[] args) {

        int[][] arr = new int[][] {

                { -1, -1, 0, -9, -2, -2 },
                { -2, -1, -6, -8, -2, -5 },
                { -1, -1, -1, -2, -3, -4 },
                { -1, -9, -2, -4, -4, -5 },
                { -7, -3, -3, -2, -9, -9 },
                { -1, -3, -1, -2, -4, -5 }

        };

        hourGlassSum(arr);
    }

    public static void hourGlassSum(final int[][] arr) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.length - 1 - 2; i++) {

            for (int j = 0; j <= arr[0].length - 1 - 2; j++) {

                int sum = 0;
                sum += arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                if (maxSum < sum)
                    maxSum = sum;
            }
        }

        System.out.println(maxSum);

    }

}
