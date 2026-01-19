def solution(citations):
    N = len(citations)
    citations.sort() 
    
    answer = 0 
    
    for h in range(0, 10001): 
        if h > citations[-1] : 
            break 
        
        for i in range(N): 
            if citations[i] >= h: 
                upper_case = N - i
                if upper_case >= h: 
                    answer = max(answer, h)
        
    
    return answer