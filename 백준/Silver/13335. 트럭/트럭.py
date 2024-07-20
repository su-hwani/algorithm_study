from collections import deque

N, W, L = map(int, input().split())
# 트럭수, 다리길이, 최대하중
num_list = list(map(int, input().split()))

second = 0
on_air = [0 for _ in range(W)]

while on_air:
    second += 1
    on_air.pop(0)
    if num_list:
        if sum(on_air) + num_list[0] <= L:
            on_air.append(num_list.pop(0))
        else:
            on_air.append(0)
print(second)
