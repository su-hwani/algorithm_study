import sys
input = sys.stdin.readline

have_n = int(input())
have_s = set(map(int, input().split()))
n = int(input())
s = list(map(int, input().split()))

have_d = {value: 0 for value in have_s}

answer = []

for i in s:
    if i in have_s:
        print(1, end=" ")
    else:
        print(0, end=" ")