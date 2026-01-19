visited = [
    [
        False for _ in range(102)
    ] for _ in range(102)
]
# 테두리: 1, 내부: -1, 초기화: 0
graph = [
    [
        0 for _ in range(102)
    ] for _ in range(102)
]

def solution(rectangle, characterX, characterY, itemX, itemY):
    
    global visited
    global graph

    
    for item in rectangle: 
        left_x, left_y, right_x, right_y = item[0] * 2, item[1] * 2, item[2] * 2, item[3] * 2
        
        for i in range(left_y, right_y + 1): 
            graph[left_x][i] = -1 if graph[left_x][i] == -1 else 1
            graph[right_x][i] = -1 if graph[right_x][i] == -1 else 1
        
        for i in range(left_x, right_x + 1):
            graph[i][left_y] = -1 if graph[i][left_y] == -1 else 1 
            graph[i][right_y] = -1 if graph[i][right_y] == -1 else 1
        
        for i in range(left_x + 1, right_x): 
            for k in range(left_y + 1, right_y): 
                graph[i][k] = -1 
    
    
    visited[characterX * 2][characterY * 2] = True 
    
    from collections import deque 
    
    q = deque([])
    q.append((characterX * 2, characterY * 2, itemX * 2, itemY * 2, 0)) 
    
    answer = 1e9 
    
    while q: 
        curX, curY, lastX, lastY, count = q.popleft() 
        # print(f"curX: {curX} curY: {curY} count: {count}")
        
        if curX == lastX and curY == lastY: 
            answer = min(answer, count)
            continue 
        
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]
        
        for i in range(4): 
            nx = dx[i] + curX
            ny = dy[i] + curY
            
            if 102 >= nx >= 0 and 102 >= ny >= 0 and visited[nx][ny] is False and graph[nx][ny] == 1: 
                q.append((nx, ny, lastX, lastY, count + 1))
                visited[nx][ny] = True 
    
    
    
    
    
    
    return answer //  2
