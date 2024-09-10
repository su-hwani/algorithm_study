def solution(friends, gifts):
    gift_graph = {}
    
    arr = {}
    for i in gifts:
        A, B = map(str, i.split())
        if A not in gift_graph:
            gift_graph[A] = 1
        else:
            gift_graph[A] += 1
        
        if B not in gift_graph:
            gift_graph[B] = -1
        else:
            gift_graph[B] += -1

        
        if A not in arr:
            arr[A] = {B:1}
        else:
            if B not in arr[A]:
                arr[A][B] = 1
            else:
                arr[A][B] += 1
    
    answer = {} 
    
    for i in friends:
        answer[i] = 0
        for k in friends:
            if k not in answer:
                answer[k] = 0
            
            if i == k:
                continue
            give = 0
            receive = 0
            
            if i in arr and k in arr[i]:
                give = arr[i][k]
            if k in arr and i in arr[k]:
                receive = arr[k][i]
            
            # 선물지수 쓰기
            if give == receive:
                if i in gift_graph:
                    give_jisu = gift_graph[i]
                else: 
                    give_jisu = 0
                if k in gift_graph:
                    receive_jisu = gift_graph[k]
                else:
                    receive_jisu = 0
                
                if give_jisu > receive_jisu:
                    answer[i] += 1
            else:
                 if give > receive: 
                    answer[i] += 1
    
    answer_listaa = list(answer.values())
    return max(answer_listaa)