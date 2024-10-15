import sys
input = sys.stdin.readline
n, m = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(input().split())

answer = float('inf')
for i in range(n-7):
    for k in range(m-7):
        draw1 = 0 # 시작이 W 
        draw2 = 0 # 시작이 B
        
        for q in range(i, i+8):
            for w in range(k, k+8):
                if (q+w) % 2 == 0:
                    if graph[q][0][w] == "W":
                        draw2 += 1
                    elif graph[q][0][w] == "B":
                        draw1 += 1
                else:
                    if graph[q][0][w] == "B":
                        draw2 += 1
                    elif graph[q][0][w] == "W":
                        draw1 += 1
        dra = min(draw1, draw2)
        if answer > dra:
            answer = dra
            
print(answer)