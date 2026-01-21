

def solution(targets):
    
    targets.sort() 
    
    answer = 0
    
    cur_start = targets[0][0]
    cur_end = targets[0][1]
    
    for i in targets: 
        start, end = i[0], i[1]
        
        if start >= cur_end : 
            answer += 1
            cur_start, cur_end = start, end 
        else: 
            cur_start = max(cur_start, start)
            cur_end = min(cur_end, end)
        
        # print(f"start: {start} end: {end} count: {answer}")

    return answer+1




