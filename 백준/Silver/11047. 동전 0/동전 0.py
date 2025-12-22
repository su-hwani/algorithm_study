






import sys
input = sys.stdin.readline 

N, M = map(int, input().split())

graph = []

for _ in range(N):
    num = int(input().strip())
    
    graph.append(num)
    

graph.sort(reverse=True)


result = 0
for i in graph: 
    if M >= i : 
        result += M // i
        M = M % i
        

print(result)


# 10 4200
# 1
# 5
# 10
# 50
# 100
# 500
# 1000
# 5000
# 10000
# 50000