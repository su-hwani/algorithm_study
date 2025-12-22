






import sys

input = sys.stdin.readline 




# 20 2

N, M = map(int, input().split())


graph = {
    (i, 1): 1 for i in range(0, N+1)
}

def fun(N, M):
    
    if N == 0 or M == 1: 
        return 1
    
    res = 0 
    
    for i in range(0, N+1):
        if (i, M-1) in graph: 
            res += graph[(i, M-1)]
        else:
            
            r = fun(i, M-1)
            graph[(i, M-1)] = r 
            res += r
    
    return res


print(fun(N, M) % 1000000000)