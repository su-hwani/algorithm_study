def get_connect(n, graph):
    visited = [0 for i in range(n+1)]
    
    q = [ (graph[0][0], graph[0][1])]
    count = 0
    
    while q:
        start, end = q.pop(0)
        # print(f"start: {start}, end: {end}")
        if visited[start] == 0:
            count += 1
            visited[start] = 1
        if visited[end] == 0:
            count += 1
            visited[end] = 1
        
        for i in graph:
            next_start, next_end = i[0], i[1]
            if end == next_start and visited[next_end] == 0:
                q.append( (next_start, next_end) )
            elif end == next_end and visited[next_start] == 0:
                q.append( (next_end, next_start) )
            elif start == next_start and visited[next_end] == 0:
                q.append( (next_start, next_end) )
                
    return count
    
    

def solution(n, wires):
    answer = 10**9
    if n == 2:
        return 0
    
    wires.sort()
    
    for i in range(0, len(wires)):
        new_wires = wires[:i] + wires[i+1:]
        
        count = get_connect(n, new_wires)
        # print(f"new_wires: {new_wires}, count: {count}")
        a = max(n-count, count) 
        b = min(n-count, count)
        if answer > (a - b):
            answer = a - b
            if answer == 0:
                return 0
    
    return answer