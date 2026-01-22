def solution(n, works):
    import heapq 
    
    max_heap = [-1 * i for i in works]
    heapq.heapify(max_heap)
    
    for i in range(n): 
        k = heapq.heappop(max_heap)
        heapq.heappush(max_heap, k + 1)
    
    answer = 0
    for i in max_heap: 
        if i > 0: 
            continue
        answer += i**2
    
    return answer