def solution(a):
    left_list = [1e9 for _ in range(len(a))]
    right_list = [1e9 for _ in range(len(a))]
    
    cur_min_val = 1e9 
    
    for i in range(len(a)): 
        left_list[i] = cur_min_val 
        cur_min_val = min(cur_min_val, a[i])
    
    cur_min_val = 1e9
    
    for i in range(len(a)-1, -1, -1): 
        right_list[i] = cur_min_val 
        cur_min_val = min(cur_min_val, a[i])
    
    answer = 0
    for i in range(len(a)): 
        left = left_list[i]
        right = right_list[i]
        mid = a[i]
        
        if is_live(left,mid,right): 
            answer += 1
    
    return answer

def is_live(left, mid, right): 
    if mid > left and mid > right: 
        return False
    else: 
        return True 
