import sys
input = sys.stdin.readline

N = int(input())
start = list(input().strip())
target = list(input().strip())

def press(arr, i):
    for j in (i-1, i, i+1):
        if 0 <= j < N:
            arr[j] = '1' if arr[j] == '0' else '0'

def simulate(first_pressed):
    arr = start[:]
    cnt = 0

    if first_pressed:
        press(arr, 0)
        cnt += 1

    for i in range(1, N):
        if arr[i-1] != target[i-1]:
            press(arr, i)
            cnt += 1

    return cnt if arr == target else float('inf')

ans = min(simulate(False), simulate(True))
print(-1 if ans == float('inf') else ans)