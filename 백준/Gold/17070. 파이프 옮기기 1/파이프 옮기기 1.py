



import sys

input = sys.stdin.readline 


N = int(input())
graph = []

for _ in range(N): 
    q = list(map(int, input().split()))
    graph.append(q)

result = 0



# print(graph)


def backtrack(start, end): 
    
    # print(f"start: {start} end: {end}")
    global graph 
    global result
    
    #print(f"start: {start} end: {end}")
    
    if end == (N-1, N-1): 
        result += 1
        return 
    
    
    # 가로인 경우 
    if start[0] == end[0] and end[1] - start[1] == 1: 
        # 직선으로 가는 경우 
        if end[1] + 1 < N and graph[end[0]][end[1] + 1] != 1: 
            backtrack(end, (end[0], end[1] + 1))
        
        # 대각으로 가는 경우
        if end[0] + 1 < N and end[1] + 1 < N and graph[end[0] + 1][end[1] + 1] != 1 and graph[end[0]][end[1]+1] != 1 and graph[end[0]+1][end[1]] != 1:
            backtrack(end, (end[0] + 1, end[1] + 1))
        
    # 세로인 경우
    elif end[0] - start[0] == 1 and start[1] == end[1]: 
        # 직선으로 가는 경우
        if end[0] + 1 < N and graph[end[0]+1][end[1]] != 1: 
            backtrack(end, (end[0] + 1, end[1]))
        
        # 대각으로 가는 경우
        if (
            end[0] + 1 < N
            and end[1] + 1 < N
            and graph[end[0] + 1][end[1] + 1] != 1
            and graph[end[0]][end[1] + 1] != 1
            and graph[end[0] + 1][end[1]] != 1
        ):
            backtrack(end, (end[0] + 1, end[1] + 1))
    
    # 대각인 경우 
    elif end[0] - start[0] == 1 and end[1] - start[1] == 1: 
        # 가로로 가는 경우
        if end[1] + 1 < N and graph[end[0]][end[1]+1] != 1: 
            backtrack(end, (end[0], end[1] + 1))
        
        # 세로로 가는 경우
        if end[0] + 1 < N and graph[end[0]+1][end[1]] != 1: 
            backtrack(end, (end[0] + 1, end[1]))
        
        # 대각으로 가는 경우
        if end[0] + 1 < N and  end[1] + 1 < N and graph[end[0]+1][end[1]+1] != 1 and graph[end[0]+1][end[1]] != 1 and graph[end[0]][end[1]+1] != 1: 
            backtrack(end, (end[0] + 1, end[1] + 1))

if graph[N - 1][N - 1] == 1:
    print("0")
else: 
    backtrack((0,0), (0,1)) 

    print(result)