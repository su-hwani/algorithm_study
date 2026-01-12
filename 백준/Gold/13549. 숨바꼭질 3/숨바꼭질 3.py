import sys

input = sys.stdin.readline


N, K = map(int, input().split())

from collections import deque 

q = deque([])
visited = {} 

q.append( (N, 0) )
visited[N] = 0
answer = abs(N-K)

while q: 
    
    cur_position, cur_count = q.popleft() 
    
    # print(f"cur_posit: {cur_position} cur_count: {cur_count} q: {q}")
    
    if cur_position == K: 
        answer = min(cur_count, answer) 
    
    if cur_position > K :
        if cur_position - 1 not in visited or visited[cur_position - 1] > cur_count + 1:
            q.append((cur_position - 1, cur_count + 1))
            visited[cur_position - 1] = cur_count + 1
    elif cur_position < 0: 
        continue
    else: 
        if cur_position - 1 not in visited or visited[cur_position -1] > cur_count + 1: 
            q.append((cur_position - 1, cur_count + 1))
            visited[cur_position -1] = cur_count + 1
            
        if cur_position * 2 not in visited or visited[cur_position * 2] > cur_count: 
            q.appendleft((cur_position * 2, cur_count))
            visited[cur_position * 2] = cur_count
        
        if cur_position + 1 not in visited or visited[cur_position + 1] > cur_count + 1: 
            q.append((cur_position+1, cur_count+1))
            visited[cur_position +1] = cur_count + 1
        

        
# print(f"answer: {answer}")
print(answer)
    
    