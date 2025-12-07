



import sys

input = sys.stdin.readline 



N = int(input())

graph = [
    [
        ' ' for _ in range(N*2-1)
    ] for _ in range(N)
]

def fun(x, y, n): 
    
    if n == 3: 
        for i in range(0, n): 
            for k in range(0, i):
                graph[x+i][y+k] = ' '
            
            for k in range(i, n*2-1-i): 
                if i == 1 and k == 2: 
                    continue 
                graph[x+i][y+k] = '*'
                
                
            for k in range(n*2-1-i, n*2-1): 
                graph[x+i][y+k] = ' '
    
    else: 
        
        fun(x, y, n // 2)
        fun(x, y + n, n // 2)
        fun(x + n // 2, y + n // 2, n // 2)
        
        

fun(0, 0, N)

for i in range(N-1, -1, -1):
    for k in range(N*2-1): 
        print(graph[i][k], end="")
    print("")
                
            

