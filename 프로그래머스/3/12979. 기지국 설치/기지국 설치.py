






def solution(n, stations, w):
    
    answer = 0
    start = 1
    
    
    for i in stations: 
        
        end = i - w - 1
        # print(f"start: {start} end: {end} answer: {answer}")
        
        if start == end: 
            start = end + 1
            continue 
        
        answer += (
            (end - start + 1) // (2 * w + 1)
            if (end - start + 1) % (2 * w + 1) == 0
            else (end - start + 1) // (2 * w + 1) + 1
        )
        start = i + w + 1
        
    # print(f"last_start: {start} last_end: {end}")
    
    if start <= n: 
        end = n 
        answer += (
            (end - start + 1) // (2 * w + 1)
            if (end - start + 1) % (2 * w + 1) == 0
            else (end - start + 1) // (2 * w + 1) + 1
        )
        

    return answer