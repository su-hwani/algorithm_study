import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
N = int(input())

def fun(graph, numbers, number, x, y):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    for i in range(0, 4):
        if x+dx[i] >= 0 and x+dx[i] < len(graph) and y+dy[i] >= 0 and y+dy[i] < len(graph[0]) and graph[x+dx[i]][y+dy[i]] == 1 and numbers[x+dx[i]][y+dy[i]] == 0:
            numbers[x+dx[i]][y+dy[i]] = number
            fun(graph, numbers, number, x+dx[i], y+dy[i])
    

for _ in range(N):
    a, b, c = map(int, input().split())
    # 가로 세로 배추개수
    graph = [
        [0] * (b) for __ in range(a)
    ]
    
    
    for __ in range(c):
        X, Y = map(int, input().split())
        graph[X][Y] = 1
    
    numbers = [
        [0] * (b) for __ in range(a)
    ]
    number = 1
    
    for i in range(0, a):
        for k in range(0, b):
            if graph[i][k] == 1 and numbers[i][k] == 0:
                numbers[i][k] = number
                fun(graph, numbers, number, i, k)
                number += 1
    
    print(f"{number-1}")