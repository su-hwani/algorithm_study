
from bisect import bisect_right
def solution(A, B):
    A.sort()
    B.sort()
    
    a_idx = 0
    b_idx = 0
    answer = 0
    
    while True: 
        if a_idx == len(A) or b_idx == len(B): 
            break 
        # print(f"A: {A[a_idx]} B: {B[b_idx]} answer: {answer}")
        
        if A[a_idx] >= B[b_idx]: 
            b_idx += 1
        else: 
            a_idx += 1
            b_idx += 1
            answer += 1
        
        
    
    
    
    return answer