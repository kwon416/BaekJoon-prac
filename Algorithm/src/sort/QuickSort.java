package sort;

public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int start, int end) {
        // 배열 방의 시작과 끝을 주고
        // 나눈 파티션의 오른쪽 방 첫 번째 값을 받아온다
        int part2 = partition(arr, start, end);
        if (start < part2 -1 ) {
            // 왼쪽 파티션 데이터가 1개 정렬 X
            quickSort(arr, start, part2 - 1);
        }
        if (part2 < end) {
            // 오른쪽 파티션 처음 값이 마지막 값보다 작으면 정렬
            quickSort(arr, part2, end);
        }
    }
    private static int partition(int[] arr, int start, int end) {
        // 피벗 값은 배열의 중간 값
        int pivot = arr[(start + end) /2];
        while(start <= end) {
            // 피벗 값보다 큰 값을 찾을 때까지 start++
            while(arr[start] < pivot) start++;
            // 피벗 값보다 작은 값을 찾을 때까지 end--
            while(arr[end] > pivot) end--;
            // start와 end가 교차하지 않았다면
            if(start <= end) {
                // start와 end의 값을 교환
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        // 오른쪽 파티션의 첫 인덱스를 반환
        return start;
    }
    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    private static void printArray(int[] arr) {
        for(int data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
    public static void main(String[] args ) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        printArray(arr);
        quickSort(arr);
        printArray(arr);

    }
}
