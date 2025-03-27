from itertools import combinations

def get_count_item_in_list(list1, list2, count):
    ans = 0
    for i in list1:
        if i in list2:
            ans += 1
        if ans > count:
            return False
    if ans == count:
        return True


def solution(n, q, ans):
    
    numbers = [x for x in range(1, n+1)]
    combi = combinations(numbers, 5)
    answer = 0
    for i in combi:
        can = True
        for k in range(0, len(q)):
            if get_count_item_in_list(i, q[k], ans[k]):
                pass
            else:
                can = False
                break
        if can:
            answer += 1
                
    return answer