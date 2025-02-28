import heapq

def solution(operations):
    hq = []
    
    for i in operations:
        A, B = i.split(' ')
        # print(f"A: {A}, B: {B}, hq: {hq}")
        if A == "I":
            heapq.heappush(hq, int(B))
        elif A == "D" and B == "1" and len(hq):
            m = max(hq)
            hq.remove(m)
            
        else: # A == "D" and B == "-1"
            if len(hq):
                heapq.heappop(hq)
    
    answer = []
    print(hq)
    
    if hq:
        answer = [max(hq), min(hq)]
    else:
        answer = [0, 0]
        
    return answer