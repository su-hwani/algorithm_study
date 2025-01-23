import sys
input = sys.stdin.readline

N = int(input())
cards = list(map(int, input().split()))

M = int(input())
nums = list(map(int, input().split()))

dicts = {}
for i in cards:
    if i in dicts:
        dicts[i] += 1
    else:
        dicts[i] = 1


for i in nums:
    if i in dicts:
        print(dicts[i], end=" ")
    else:
        print(0, end=" ")