import sys
input = sys.stdin.readline

def print_gra(graph):
    for i in range(len(graph)):
        for k in range(len(graph[i])):
            boom, life = graph[i][k]
            if boom:
                print('O', end="")
            else:
                print('.', end="")
        print()


row, col, num = map(int, input().split())

graph = []

# 초기 상태 (0 또는 1 : 폭탄 유무, 3 또는 2 또는 1 : 남은 시간)
for _ in range(row):
    c = str(input())
    q = []
    for i in range(col):
        if c[i] == '.':
            q.append( (0,0) )
        else:
            q.append( (1,2) )
    graph.append(q)

time = 1

while time < num:
    
    if time % 2 == 1:
        # 1, 3, 5초 -> 3번
        for i in range(len(graph)):
            for k in range(len(graph[i])):
                boom, life = graph[i][k] 
                if boom:
                    graph[i][k] = (boom, life-1)
                else:
                    graph[i][k] = (1, 3)
    else:
        # 2, 4, 6초 -> 4번
        for i in range(len(graph)):
            for k in range(len(graph[i])):
                boom, life = graph[i][k] 
                if boom:
                    graph[i][k] = (boom, life-1)
                    if life-1 == 0:
                        if (i-1) >= 0:
                            bo, li = graph[i-1][k] 
                            if bo and li == 1:
                                pass
                            else:
                                graph[i-1][k] = (0, 0)
                        if (i+1) < len(graph):
                            bo, li = graph[i+1][k] 
                            if bo and li == 1:
                                pass
                            else:
                                graph[i+1][k] = (0, 0) 
                        if (k-1) >= 0:
                            bo, li = graph[i][k-1] 
                            if bo and li == 1:
                                pass
                            else:
                                graph[i][k-1] = (0, 0) 
                        if (k+1) < len(graph[i]):
                            bo, li = graph[i][k+1] 
                            if bo and li == 1:
                                pass
                            else:
                                graph[i][k+1] = (0, 0)
                        graph[i][k] = (0, 0)

    time += 1
print_gra(graph=graph)

