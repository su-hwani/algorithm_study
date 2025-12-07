



import sys

input = sys.stdin.readline 



N = int(input())

graph = [
    [' ' for _ in range(N)] for _ in range(N)
]

def fun(x, y, n): 
    
    if n == 3: 
        for dx in range(3): 
            for dy in range(3): 
                if dx == 1 and dy == 1: 
                    continue 
                graph[x+dx][y+dy] = '*'
                
    else: 
        for dx in range(0, n, n // 3): 
            for dy in range(0, n, n // 3):
                if dx == n // 3 and dy == n // 3: 
                    continue 
                
                fun(x+dx, y+dy, n//3)
    
fun(0, 0, N)

for i in range(N):
    for k in range(N):
        print(graph[i][k], end = "")
    print("")