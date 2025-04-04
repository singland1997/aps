package com.example.aps.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClosestSearch implements CommandLineRunner {

    @Override
    public void run(String... args) {
        int[] sortedArr = new int[1_000_001];
        Random random = new Random();
        for (int i = 0; i < 1_000_001; i++) {
            sortedArr[i] = random.nextInt(1_000_001);
        }
        int target = random.nextInt(1_000_001);
        int closest = findClosest(sortedArr, target);
        log.info("closest {} is {}", target, closest);
    }

    public static int findClosest(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            log.error("arr is null or empty");
        }

        int low = 0;
        int high = arr.length - 1;

        if (target <= arr[low]) return arr[low];
        if (target >= arr[high]) return arr[high];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (target - arr[high] <= arr[low] - target) {
            return arr[high];
        } else {
            return arr[low];
        }
    }
}
