from itertools import combinations
def solution(orders, course):
    answer = []
    for i in course:
        s = set()
        d = {}
        max_list = []
        max_len = -1
        for k in orders:
            if len(k) < i:
                continue
            p = list(combinations(k, i))
            
            for q in p:
                aa = sorted(q)
                q = ""
                for ppp in aa:
                    q += ppp
                
                if q in s:
                    d[q] += 1
                else:
                    s.add(q)
                    d[q] = 1
                if d[q] > max_len:
                    max_list = [q]
                    max_len = d[q]
                elif d[q] == max_len:
                    max_list.append(q)
                else:
                    pass
        
        if max_len >= 2:
            answer += max_list
    return sorted(answer)