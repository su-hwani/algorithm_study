

def solution(enroll, referral, seller, amount):
    graph = {}
    money_graph = {"CENTER": 0} 
    
    N = len(enroll)
    
    for i in range(N): 
        start, end = enroll[i], referral[i]
        if end == "-": 
            end = "CENTER"
        if start in graph: 
            graph[start].append(end)
        else: 
            graph[start] = [end]
        money_graph[start] = 0
        
        
    M = len(seller) 
    
    for i in range(M): 
        start, value = seller[i], amount[i] * 100 
        
        dfs(start, graph, money_graph, value)
    
    answer = []
    for i in range(N): 
        answer.append(money_graph[enroll[i]])
        
    
    # print("GRAPH --------------")
    # print(graph)
    # print("GRAPH --------------")
    # print("MONEY_GRAPH --------------")
    # print(money_graph)
    # print("MONEY_GRAPH --------------")
            
            
    return answer


def dfs(start, graph, money_graph, value): 
    
    
    your_money = value // 10 if value >= 10 else 0
    my_money = value - your_money 
    
    money_graph[start] += my_money 
    
    if your_money == 0 or start == "CENTER":
        return 
        
    dfs(graph[start][0], graph, money_graph, your_money)
    



