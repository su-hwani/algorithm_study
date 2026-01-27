def solution(s):
    answer = 1
    for i in range(len(s)-1, 0, -1):
        
        for start in range(0, len(s) - i): 
            # print(f"i: {i} start: {start} s: {s[start:start+i+1]}")
            if is_valid(s[start:start+i+1]): 
                answer += i
                break 
        if answer != 1: 
            break 
        
        


    return answer

def is_valid(s): 
    left = 0
    right = len(s)-1
    
    
    while left < right: 
        # print(f"s: {s} left: {s[left]} right: {s[right]}")
        if s[left] == s[right]: 
            left += 1
            right -= 1
            pass 
        else: 
            return False 
    return True
    
