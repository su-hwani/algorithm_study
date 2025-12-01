

N = int(input())

graph = {} # 날짜: (기간, 보수)

for _ in range(1, N+1):
    T, P = map(int, input().split())
    graph[_] = (T, P)

from collections import deque 

q = deque([ (1, 0) ])
# 현재 날짜, 현재 보수 

result = 0

while q: 
    cur = q.popleft()
    curDate, curPrice = cur[0], cur[1]
    
    if curDate >= N+1: 
        result = max(result, curPrice)
        continue
    
    nextDate = curDate + graph[curDate][0]
    nextPrice = curPrice + graph[curDate][1]
    
    q.append( (nextDate, nextPrice) ) if nextDate <= N+1 else None 
    q.append( (curDate+1, curPrice) ) 
    
    
print(result)