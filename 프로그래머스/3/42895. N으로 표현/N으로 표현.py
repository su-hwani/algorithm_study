graph = {1: set(), 2: set(), 3: set(), 4: set(), 5: set(), 6: set(), 7: set(), 8: set()}

def get(A, B):
    return [A+B, A-B, A*B, A//B if B!=0 else 0, B-A, B//A if A!=0 else 0]

def solution(N, number):
    answer = -1
    for i in range(1, 9):
        for k in range(0, (i//2) + 1):
            A = int("1" * (i-k)) * N
            B = int("1" * (k)) * N if k != 0 else 0
            res = get(A, B)
            
            if k >= 1:
                for w in graph[i-k]:
                    for e in graph[k]:
                        res.extend(get(w, e))
                        
            
            for q in res:
                graph[i].add(q)
                
            
        
        if i != 1:
            for k in graph[i-1]:
                res = get(k, N)
                for q in res:
                    graph[i].add(q)
        
        if number in graph[i]:
            answer = i
            break
            
    return answer