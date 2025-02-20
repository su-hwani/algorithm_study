import sys
input = sys.stdin.readline

N, M = map(int, input().split())

up = {}
down = {}

for i in range(N):
    start, end = map(int, input().split())
    up[start] = end 

for i in range(M):
    start, end = map(int, input().split())
    down[start] = end 

from collections import deque
q = deque( [] )
q.append( (1, 0) )

answer = 999999999
visited = [False] * 200
while q:
    cur, count = q.popleft() 
    
    if visited[cur]:
        continue
    visited[cur] = True
    
    
    if count > answer: 
        continue
    
    if cur >= 94:
        if count+1 < answer: 
            answer = count+1
        continue
    
    for i in range(7):
        nx = cur + i 
        if nx in up:
            q.append( (up[nx], count+1) )
        elif nx in down:
            q.append( (down[nx], count+1) )
        else:
            q.append( (nx, count+1) )

print(answer)