from collections import deque
def solution(queue1, queue2):
    end = 300001
    zeo = 0
    
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    
    q1 = sum(queue1)
    q2 = sum(queue2)
    while end >= 0:
        if q1 > q2:
            n = queue1.popleft()
            queue2.append(n)
            q1 -= n 
            q2 += n
        elif q1 < q2:
            n = queue2.popleft()
            queue1.append(n)
            q2 -= n
            q1 += n
        else:
            break 
        zeo += 1
        end -= 1
        
    if end <= 0:
        answer = -1
    else:
        answer = zeo
    return answer