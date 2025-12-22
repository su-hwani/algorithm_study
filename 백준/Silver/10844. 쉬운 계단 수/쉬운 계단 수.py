






import sys
input = sys.stdin.readline 


N = int(input())



graph = {
    (1, i) : 1 for i in range(0, 10)
}

def fun(N, num):
    
    if num < 0 or num >= 10:
        return 0
    
    if (N, num) in graph: 
        return graph[(N, num)]
    
    res = fun(N-1, num - 1) + fun(N-1, num + 1)
    graph[(N, num)] = res 
    
    return res 


result = 0

for i in range(1, 10):
    
    result += fun(N, i)
print(result % 1000000000)



    






# 60 307863967