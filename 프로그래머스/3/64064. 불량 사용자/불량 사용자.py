user_ids, banned_ids, global_count = None, None, 0,
set_visited = []
def solution(user_id, banned_id):
    global user_ids, banned_ids,global_count
    
    user_ids, banned_ids = user_id, banned_id
    
    backtracking({i:False for i in user_ids}, 0, 0, len(banned_ids))
    
    
    answer = 0
    return global_count

def backtracking(visited, banned_id_idx, count, N): 
    
    global user_ids, banned_ids, global_count, set_visited
    
    
    if banned_id_idx == N: 
        v = list(visited.values())
        if v not in set_visited: 
            global_count += 1 
            set_visited.append(v)
        return
    
    
    banned_id = banned_ids[banned_id_idx]
    
    
    for user_id in user_ids: 
        if match_id(user_id, banned_id) and visited[user_id] is False: 
            
            visited[user_id] = True
            backtracking(visited, banned_id_idx + 1, count + 1, N)
            visited[user_id] = False 
    
    return 
        
        
        
        
        
        
def match_id(user_id: str, banned_id: str): 
    if len(user_id) != len(banned_id): 
        return False 
    
    for i in range(len(user_id)): 
        if (user_id[i] != banned_id[i]) and (banned_id[i] != "*"): 
            return False 
    
    return True 
            
        
        
    
    