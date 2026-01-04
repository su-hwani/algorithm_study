






import sys

input = sys.stdin.readline 


N = int(input())
graph = list(map(int, input().split()))

visited = [False for _ in range(N)]

idx = 0
count = 0
is_complete = False

if N == 1: 
    print(0)
else: 

    while idx < N:
        # print(f"idx: {idx} count: {count}")
        visited[idx] = True 
        can_go = graph[idx] 
        
        max_idx = -1
        max_go = -1
        
        if idx + graph[idx] >= N - 1:
            count += 1
            is_complete = True 
            break 
        
        for i in range(idx+1, idx + 1 + graph[idx]):
            
            # print(f"graph[i] - (max_idx - i): {graph[i] - (max_idx - i)} max_go: {max_go}")
            if graph[i] - (max_idx - i) >= max_go and visited[i] is False: 
                
                max_go = graph[i]
                max_idx = i 
            
        if max_idx == -1:
            break
        
        idx = max_idx 
        count += 1
        
        


    print(count) if is_complete else print(-1)
            
        


        
    # # Output
    # 2
        
    # # Answer
    # 1