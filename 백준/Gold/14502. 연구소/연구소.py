import sys
input = sys.stdin.readline 

from collections import deque
from copy import deepcopy


N, M = map(int, input().split())

graph = []

graph_0 = []
graph_1 = []
graph_2 = []

def get_score(one, two, three, graph_origin):
    graph = deepcopy(graph_origin)
    score = 0
    one_x, one_y = one 
    two_x, two_y = two
    three_x, three_y = three   
    graph[one_x][one_y] = 1
    graph[two_x][two_y] = 1
    graph[three_x][three_y] = 1
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    for i in range(len(graph_2)):
        x, y = graph_2[i]
        q = deque()
        q.append((x, y))
        while q:
            x, y = q.popleft()
            for j in range(4):
                nx = x + dx[j]
                ny = y + dy[j]
                if nx >= 0 and nx < N and ny >= 0 and ny < M:
                    if graph[nx][ny] == 0:
                        graph[nx][ny] = 2
                        q.append((nx, ny))
    
    for i in range(N):
        for k in range(M):
            if graph[i][k] == 0:
                score += 1
    return score

for _ in range(N):
    nums = list(map(int, input().split()))
    graph.append(nums)
    for i in range(M):
        if nums[i] == 2: 
            graph_2.append((_, i))
        elif nums[i] == 1:
            graph_1.append((_, i))
        else:
            graph_0.append((_, i))
    
from itertools import combinations

combi = list(combinations(graph_0, 3))

answer = 0 
for i in combi:
    res = get_score(i[0], i[1], i[2], graph)
    if res > answer: 
        answer = res 
    
print(answer)
            
        