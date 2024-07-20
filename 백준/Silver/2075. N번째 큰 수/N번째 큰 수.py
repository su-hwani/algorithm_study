import heapq

# 우선순위큐 쓰는 법 몰라서 풀이 봤음..
N = int(input())
hq = []

for _ in range(N):
    num_list = map(int, input().split())
    
    for __ in num_list:
        if len(hq) < N:
            heapq.heappush(hq, __)
        else:
            if hq[0] < __:
                heapq.heappop(hq)
                heapq.heappush(hq, __)
print(hq[0])