import sys
import heapq
from collections import defaultdict

input = sys.stdin.readline

N = int(input())

class Plus:

    def __init__(self):
        self.plus_q = []
        self.minus_q = []
        self.count = defaultdict(int)  # lazy deletion용

    def insert(self, num):
        heapq.heappush(self.plus_q, num)
        heapq.heappush(self.minus_q, -1 * num)
        self.count[num] += 1

    def _clean_plus(self):
        while self.plus_q and self.count[self.plus_q[0]] == 0:
            heapq.heappop(self.plus_q)

    def _clean_minus(self):
        while self.minus_q and self.count[-self.minus_q[0]] == 0:
            heapq.heappop(self.minus_q)

    def exist(self):
        self._clean_plus()
        return len(self.plus_q) > 0

    def delete_max_val(self) -> int | None:
        self._clean_minus()
        if self.minus_q:
            max_val = -heapq.heappop(self.minus_q)
            self.count[max_val] -= 1
            return max_val
        return None

    def delete_min_val(self) -> int | None:
        self._clean_plus()
        if self.plus_q:
            min_val = heapq.heappop(self.plus_q)
            self.count[min_val] -= 1
            return min_val
        return None


class Minus:

    def __init__(self):
        self.plus_q = []
        self.minus_q = []
        self.count = defaultdict(int)  # lazy deletion용

    def insert(self, num):
        heapq.heappush(self.plus_q, -1 * num)
        heapq.heappush(self.minus_q, num)
        self.count[num] += 1

    def _clean_plus(self):
        while self.plus_q and self.count[-self.plus_q[0]] == 0:
            heapq.heappop(self.plus_q)

    def _clean_minus(self):
        while self.minus_q and self.count[self.minus_q[0]] == 0:
            heapq.heappop(self.minus_q)

    def exist(self):
        self._clean_minus()
        return len(self.minus_q) > 0

    def delete_max_val(self) -> int | None:
        self._clean_plus()
        if self.plus_q:
            max_val = -heapq.heappop(self.plus_q)
            self.count[max_val] -= 1
            return max_val
        return None

    def delete_min_val(self) -> int | None:
        self._clean_minus()
        if self.minus_q:
            min_val = heapq.heappop(self.minus_q)
            self.count[min_val] -= 1
            return min_val
        return None


for _ in range(N):
    count = int(input())

    plus = Plus()
    minus = Minus()

    for __ in range(count):
        command, num = map(str, input().split())

        if command == "I":
            num = int(num)
            if num >= 0:
                plus.insert(num)
            else:
                minus.insert(num)

        elif command == "D" and num == "1":
            res = plus.delete_max_val()
            if res is None:
                minus.delete_max_val()

        elif command == "D" and num == "-1":
            res = minus.delete_min_val()
            if res is None:
                plus.delete_min_val()

    left_max_val = plus.delete_max_val()
    if left_max_val is None:
        left_max_val = minus.delete_max_val()

    left_min_val = minus.delete_min_val()
    if left_min_val is None:
        left_min_val = plus.delete_min_val()

    if left_max_val is None and left_min_val is None:
        print("EMPTY")
    elif left_max_val is None:
        print(f"{left_min_val} {left_min_val}")
    elif left_min_val is None:
        print(f"{left_max_val} {left_max_val}")
    else:
        print(f"{left_max_val} {left_min_val}")
