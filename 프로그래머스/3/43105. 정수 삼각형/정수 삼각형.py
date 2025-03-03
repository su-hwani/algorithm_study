
def solution(triangle):
    graph = [ [] for i in range(len(triangle))]
    graph[0].append(triangle[0][0])
    
    for i in range(1, len(triangle)):
        for k in range(0, len(triangle[i])):
            if k == 0:
                graph[i].append(graph[i-1][0] + triangle[i][k])
            elif k == len(triangle[i])-1:
                graph[i].append(graph[i-1][k-1] + triangle[i][k])
            else:
                m = max(graph[i-1][k-1], graph[i-1][k])
                graph[i].append(m + triangle[i][k])
    
    answer = max(graph[-1])
    return answer