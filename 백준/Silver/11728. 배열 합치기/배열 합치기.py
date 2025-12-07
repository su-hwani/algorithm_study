import sys

input = sys.stdin.readline


N, M = map(int, input().split())

leftList = list(map(int, input().split()))
rightList = list(map(int, input().split()))

lis = sorted(leftList + rightList)

for i in lis:
    print(i, end=" ")
