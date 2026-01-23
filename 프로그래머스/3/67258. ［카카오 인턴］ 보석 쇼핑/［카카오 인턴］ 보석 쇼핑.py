def solution(gems):
    category = set(gems)
    N = len(category) 
    cur_items = set()
    
    start_items = {i: 0 for i in category}
    start_idx = 0
    
    answer = [0, len(gems)]
    
    for i in range(0, len(gems)): 

        
        if gems[i] not in cur_items: 
            cur_items.add(gems[i])
        start_items[gems[i]] += 1
        
        if len(cur_items) == N: 
            
            for idx in range(start_idx, i): 
                if start_items[gems[idx]] == 1: 
                    start_idx = idx
                    break 
                    
                start_items[gems[idx]] -= 1   
                
            answer = [start_idx, i] if answer[1] - answer[0] > i - start_idx else answer
            
            
        # print(f"answer: {answer} start_items: {start_items}, start_idx: {start_idx}")
    
    
    
    return [answer[0] + 1, answer[1] + 1]




# 10^5 = 힙, 정렬, 이분탐색 