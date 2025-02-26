import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while len(scoville) > 1:
        worst = heapq.heappop(scoville)
        if worst >= K:
            break 
            
        worse = heapq.heappop(scoville)

        mixed = worst + worse * 2

        heapq.heappush(scoville, mixed)
        answer += 1

    worst = heapq.heappop(scoville)
    if worst >= K:
        return answer
    else:
        return -1