



import sys
input = sys.stdin.readline 


N, M = map(int, input().split())

graph = []
destination = []

start_x, start_y = 0, 0

for i in range(N):
    line = str(input().strip())
    for k in range(M): 
        if line[k] == "S":
            start_x, start_y = i, k
            
        elif line[k] == "C":
            destination.append( (i, k) )
            
    graph.append(line)
    

from collections import deque 

# (X, Y), Time, (+-1, +-1), firstC, secondC
q = deque([])
q.append( ( (start_x, start_y ), 0, (0,0), False, False) )

visited = { (start_x, start_y, (0, 0), False, False): 0}

answer = 1e9

while q: 
    cur, time, direction, pass_first, pass_second = q.popleft()
    
    # print(f"cur: {cur} time: {time} direction: {direction} pass_first: {pass_first} pass_second: {pass_second} destination: {destination}, q: {q}")
    
    if cur[0] == destination[0][0] and cur[1] == destination[0][1]: 
        pass_first = True 
    elif cur[0] == destination[1][0] and cur[1] == destination[1][1]: 
        pass_second = True 
        
    if pass_first and pass_second: 
        answer = min(answer, time)
        break 
    
    d = [(1,0), (-1,0), (0,-1), (0,1)]
    
    for i in range(4):
        if direction == d[i]: 
            continue 
        
        nx, ny = cur[0] + d[i][0], cur[1] + d[i][1]
        
        
        if (
            N > nx >= 0
            and M > ny >= 0
            and (
                (nx, ny, d[i], pass_first, pass_second) not in visited
                or visited[(nx, ny, d[i], pass_first, pass_second)] > time + 1
            )
            and graph[nx][ny] != "#"
        ): 
            q.append( ( (nx,ny),time+1, d[i], pass_first, pass_second ) )
            visited[(nx, ny, d[i], pass_first, pass_second)] = time + 1
    
# print(f"answer: {answer if answer != 1e9 else -1}")
print(answer if answer != 1e9 else -1)

        
            