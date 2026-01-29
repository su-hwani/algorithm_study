def solution(stones, k):
    from collections import deque 
    answer = 1e9 
    q = deque([])
    max_q = deque([])  # 추가: (값, 인덱스) - 내림차순 유지
    
    for i in range(len(stones)-k+1): 
        if not q: 
            for j in range(i, i+k):
                while max_q and max_q[-1][0] < stones[j]:
                    max_q.pop()
                max_q.append((stones[j], j))
                q.append(stones[j])
        else: 
            q.popleft()
            q.append(stones[i+k-1])
            
            # 윈도우 벗어난 인덱스 제거
            if max_q[0][1] < i:
                max_q.popleft()
            
            # 새 값 추가 (내림차순 유지)
            while max_q and max_q[-1][0] < stones[i+k-1]:
                max_q.pop()
            max_q.append((stones[i+k-1], i+k-1))
        
        m = max_q[0][0]  # max(q) 대신 O(1)
        answer = min(m, answer)
    
    return answer