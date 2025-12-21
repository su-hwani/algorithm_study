import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


N = int(input())



graph = [0 for i in range(N+1)]
graph[1] = 1

for i in range(2, N+1):
    
    num = int(i ** 0.5)
    
    # print(num)
    
    numbers = []
    
    for k in range(1, num + 1):
        
        # print(f"i: {i}, k: {k}")
        numbers.append(graph[i-k**2] + 1)
        
    graph[i] = min(numbers)

print(graph[-1])