answer = [10**9, 10**9]
memo = set()

def bruthforce(info, idx, n, m, curA, curB):
    global memo
    global answer
    
    if (idx, curA, curB) in memo:
        return
    else:
        memo.add((idx, curA, curB))
    
    if idx == len(info):
        if answer[0] > curA:
            answer[0] = curA
            answer[1] = curB
        return
    
    if curA >= answer[0]:
        return
    
    costA, costB = info[idx]
    
    if (curA+costA) < n:
        bruthforce(info, idx+1, n, m, curA+costA, curB)
    if (curB+costB) < m:
        bruthforce(info, idx+1, n, m, curA, curB+costB)

    

def solution(info, n, m):
    global answer
    bruthforce(info, 0, n, m, 0, 0)
    
    ans = answer[0]
    if ans == 10**9:
        return -1
    return ans