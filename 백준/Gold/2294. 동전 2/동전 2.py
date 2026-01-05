
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline 

N, M = map(int, input().split())

graph = {}

nums = []
for _ in range(N):
    num = int(input())
    nums.append(num)
    graph[num] = 1 

graph[0] = 0

def dp(num):
    if num in graph:
        return graph[num]

    re = 1e9
    for coin in nums:  # ← 동전 종류만 순회 (N개)
        if coin <= num:
            re = min(dp(num - coin) + 1, re)

    graph[num] = re
    return re
    
        
result = dp(M)
# print(f"answer: {result if result != 1e9 else -1}")
print(result if result != 1e9 else -1)

