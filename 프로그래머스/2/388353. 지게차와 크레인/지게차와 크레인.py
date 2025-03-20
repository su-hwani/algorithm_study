from collections import deque

answer = 0
len_storage = 0
len_storage_0 = 0

def can_access(storage, request):
    global len_storage
    global len_storage_0
    global answer
    
    flush = []
    
    for i in range(len_storage):
        for k in range(len_storage_0):
            if storage[i][k] == request:
                
                dx = [0, 0, -1, 1]
                dy = [-1, 1, 0, 0]
                visited = [(i, k)]
                q = deque([(i, k)])
                can_access = False
                while q:
                    cur_x, cur_y = q.popleft()
                    
                    for w in range(4):
                        next_x, next_y = cur_x+dx[w], cur_y+dy[w]
                        
                        if next_x < 0 or len_storage <= next_x or next_y < 0 or len_storage_0 <= next_y:
                            can_access = True
                            break
                        
                        if storage[next_x][next_y] == "1" and (next_x, next_y) not in visited:
                            q.append((next_x, next_y))
                            visited.append((next_x, next_y))
                    if can_access:
                        break
                    
                if can_access: 
                    flush.append((i,k))
    
    for i,k in flush:
        storage[i][k] = "1"
        answer += 1
    return 

    
    
def can_not_access(storage, request):
    global answer
    global len_storage
    global len_storage_0
    
    for i in range(len_storage):
        for k in range(len_storage_0):
            if storage[i][k] == request:
                storage[i][k] = "1"
                answer += 1
    return 
    
def solution(storage, requests):
    global len_storage
    global len_storage_0
    global answer
    len_storage = len(storage)
    len_storage_0 = len(storage[0])
    
    new_list = []
    
    for i in range(len_storage):
        storage[i] = list(storage[i])
    
    for i in requests:
        if len(i) == 2:
            can_not_access(storage, i[0])
        else: # len(i) == 1
            can_access(storage, i[0])
    
    return len_storage * len_storage_0 - answer